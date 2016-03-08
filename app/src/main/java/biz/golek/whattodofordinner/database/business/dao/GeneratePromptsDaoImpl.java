package biz.golek.whattodofordinner.database.business.dao;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.GeneratePromptsDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.request_data.Duration;
import biz.golek.whattodofordinner.business.contract.request_data.Profile;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.DinnerStatDao;
import biz.golek.whattodofordinner.database.entities.DinnerStat;
import biz.golek.whattodofordinner.database.entities.DinnerStatType;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by bg on 10.02.16.
 */
public class GeneratePromptsDaoImpl implements GeneratePromptsDao {
    private Provider<DinnerDao> dinnerDaoProvider;
    private Provider<DinnerStatDao> dinnerStatDaoProvider;
    private biz.golek.whattodofordinner.database.business.dao.DBDinnerToDinner converter;

    public GeneratePromptsDaoImpl(
            Provider<DinnerDao> dinnerDaoProvider,
            Provider<DinnerStatDao> dinnerStatDaoProvider,
            DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.dinnerStatDaoProvider = dinnerStatDaoProvider;
        this.converter = converter;
    }

    @Override
    public List<Dinner> GetPrompts(Duration maximum_duration, Profile vegetarian_profile, Profile soup_profile, Long[] excludes) {
        QueryBuilder<biz.golek.whattodofordinner.database.entities.Dinner> queryBuilder = dinnerDaoProvider.get().queryBuilder();

        if (excludes != null && excludes.length > 0)
            queryBuilder.where(DinnerDao.Properties.Id.notIn(excludes));

        queryBuilder.where(DinnerDao.Properties.Duration.le(Duration.toInt(maximum_duration)));

        if (soup_profile == Profile.Only || soup_profile == Profile.OnlyNot)
            queryBuilder.where(DinnerDao.Properties.Soup.eq(soup_profile == Profile.Only));

        if (vegetarian_profile == Profile.Only || vegetarian_profile == Profile.OnlyNot)
            queryBuilder.where(DinnerDao.Properties.Vegetarian.eq(vegetarian_profile == Profile.Only));

        String orderByString = new ScoreFunctionGenerator(vegetarian_profile, soup_profile).getOrderByString();
        queryBuilder.orderRaw(orderByString);

        return converter.toBusiness(queryBuilder.limit(3).list());
    }

    @Override
    public void StoreDeny(Long[] excludes) {
        if (excludes != null && excludes.length > 0) {
            DinnerDao dinnerDao = dinnerDaoProvider.get();
            DinnerStatDao dinnerStatDao = dinnerStatDaoProvider.get();

            List<biz.golek.whattodofordinner.database.entities.Dinner> list = dinnerDao.queryBuilder()
                    .where(DinnerDao.Properties.Id.in(excludes))
                    .list();

            for (biz.golek.whattodofordinner.database.entities.Dinner dinner : list) {
                Date dropDate = new Date();
                dinner.setLastDrop(dropDate);
                dinnerDao.update(dinner);

                DinnerStat dinnerStat = new DinnerStat();
                dinnerStat.setType(DinnerStatType.Drop);
                dinnerStat.setDate(dropDate);
                dinnerStat.setDinnerId(dinner.getId());
                dinnerStatDao.insert(dinnerStat);
            }
        }
    }

    private class ScoreFunctionGenerator
    {
        private final String season_score_weight = "30";
        private final String last_usage_score_weight = "1";
        private final String last_drop_score_weight = "0.2";

        private Profile vegetarian_profile;
        private Profile soup_profile;

        public ScoreFunctionGenerator(Profile vegetarian_profile, Profile soup_profile)
        {
            this.vegetarian_profile = vegetarian_profile;
            this.soup_profile = soup_profile;
        }

        public String getOrderByString()
        {
            return getCompleteScoreString() + " DESC";
        }

        @NonNull
        private String getCompleteScoreString() {
            return getVegetarianScoreString() + " + " +
                    getSoupScoreString() + " + " +
                    getSeasonScoreString() + " + " +
                    getLastUsageScoreString() + " + " +
                    getLastDropScoreString();
        }

        @NonNull
        private String getLastUsageScoreString() {
            return getScoreString(getLastUsageClause(), last_usage_score_weight);
        }

        @NonNull
        private String getLastDropScoreString() {
            return getScoreString(getLastDropClause(), last_drop_score_weight);
        }

        @NonNull
        private String getSeasonScoreString() {
            return getScoreString(getSeasonClause(), season_score_weight);
        }

        @NonNull
        private String getSoupScoreString() {
            return getScoreString(getBoolFactor(DinnerDao.Properties.Soup.columnName), calc_score_weight(soup_profile));
        }

        @NonNull
        private String getVegetarianScoreString() {
            return getScoreString(getBoolFactor(DinnerDao.Properties.Vegetarian.columnName), calc_score_weight(vegetarian_profile));
        }

        @NonNull
        private String getScoreString(String score_string, String score_weight) {
            return "(" + score_string + " * " + score_weight + ")";
        }

        private String calc_score_weight(Profile profile) {
            if (vegetarian_profile == Profile.PreferNot)
                return "-20";
            else if (vegetarian_profile == Profile.Prefer)
                return "20";
            else
                return "0";
        }

        private String getLastUsageClause() {
            return SqlFunctionsProvider.subtract(
                    getCurrentDayNumber(),
                    SqlFunctionsProvider.ternary(
                        SqlFunctionsProvider.isNull(DinnerDao.Properties.LastUsage.columnName),
                        getDayNumber(-300),
                        SqlFunctionsProvider.daysOf(DinnerDao.Properties.LastUsage.columnName)
                    )
            );
        }

        private String getLastDropClause() {
            return SqlFunctionsProvider.ternary(
                SqlFunctionsProvider.isNull(DinnerDao.Properties.LastDrop.columnName),
                "0",
                SqlFunctionsProvider.getMaxOf(
                    SqlFunctionsProvider.subtract(
                        "100",
                        SqlFunctionsProvider.subtract(
                            getCurrentDayNumber(),
                            SqlFunctionsProvider.daysOf(DinnerDao.Properties.LastDrop.columnName)
                        )
                    ),
                    "0"
                )
            );
        }

        private String getCurrentDayNumber()
        {
            return Long.toString(getDayNumber(new Date()));
        }

        private long getDayNumber(Date date)
        {
            return date.getTime() / 1000 / 60 / 60 / 24;
        }

        private String getDayNumber(long addDays)
        {
            return Long.toString(getDayNumber(new Date()) + addDays);
        }

        private String getBoolFactor(String field)
        {
            return "CASE " + field + " WHEN 1 THEN 1 ELSE -1 END";
        }

        private String getSeasonInClause(Date date) {
            return seasons[Calendar.getInstance().get(Calendar.MONTH)];
        }

        private String getSeasonClause() {
            return DinnerDao.Properties.Seasons.columnName + " IN " + getSeasonInClause(new Date());
        }

        private final String seasons[] = {
                "(8,9,10,11,12,13,14,15)", //Winter
                "(8,9,10,11,12,13,14,15)", //Winter
                "(1,3,5,7,9,11,13,15)", //Spring
                "(1,3,5,7,9,11,13,15)", //Spring
                "(1,3,5,7,9,11,13,15)", //Spring
                "(2,3,6,7,10,11,14,15)", //Summer
                "(2,3,6,7,10,11,14,15)", //Summer
                "(2,3,6,7,10,11,14,15)", //Summer
                "(4,5,6,7,12,13,14,15)", //Autumn
                "(4,5,6,7,12,13,14,15)", //Autumn
                "(4,5,6,7,12,13,14,15)", //Autumn
                "(8,9,10,11,12,13,14,15)", //Winter
        };
    }

    public static class SqlFunctionsProvider
    {
        public static String getMinOf(String value, String value2)
        {
            return "CASE WHEN " + value + " < " + value2 + " THEN " + value + " ELSE " + value2 + " END";
        }

        public static String getMaxOf(String value, String value2)
        {
            return "CASE WHEN " + value + " > " + value2 + " THEN " + value + " ELSE " + value2 + " END";
        }

        public static String ifNull(String value, String defaultValue)
        {
            return "CASE WHEN " + value + " IS NULL THEN " + defaultValue + " ELSE " + value + " END";
        }

        public static String isNull(String value)
        {
            return value + " IS NULL";
        }

        public static String ternary(String condition, String trueValue, String falseValue)
        {
            return "CASE WHEN " + condition + " THEN " + trueValue + " ELSE " + falseValue + " END";
        }

        public static String daysOf(String value)
        {
            return "(" + value + " / 1000 / 60 / 60 / 24)";
        }

        public static String subtract(String value, String value2)
        {
            return "(" + value + " - " + value2 + ")";
        }
    }
}
