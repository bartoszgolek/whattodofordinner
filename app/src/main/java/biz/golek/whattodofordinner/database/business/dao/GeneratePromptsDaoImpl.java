package biz.golek.whattodofordinner.database.business.dao;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.GeneratePromptsDao;
import biz.golek.whattodofordinner.business.contract.request_data.Duration;
import biz.golek.whattodofordinner.business.contract.request_data.Profile;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by bg on 10.02.16.
 */
public class GeneratePromptsDaoImpl implements GeneratePromptsDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public GeneratePromptsDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public List<Dinner> GetPrompts(Duration maximum_duration, Profile vegetarian_profile, Profile soup_profile, Long[] excludes) {
        QueryBuilder<Dinner> queryBuilder = dinnerDaoProvider.get().queryBuilder();

        if (excludes != null && excludes.length > 0)
            queryBuilder.where(DinnerDao.Properties.Id.notIn(excludes));

        queryBuilder.where(DinnerDao.Properties.Duration.le(Duration.toInt(maximum_duration)));

        if (soup_profile == Profile.Only || soup_profile == Profile.OnlyNot)
            queryBuilder.where(DinnerDao.Properties.Soup.eq(soup_profile == Profile.Only));

        if (vegetarian_profile == Profile.Only || vegetarian_profile == Profile.OnlyNot)
            queryBuilder.where(DinnerDao.Properties.Vegetarian.eq(vegetarian_profile == Profile.Only));

        String orderByString = new ScoreFunctionGenerator(vegetarian_profile, soup_profile).getOrderByString();
        queryBuilder.orderRaw(orderByString);

        return queryBuilder.limit(3).list();
    }

    @Override
    public void StoreDeny(Long[] excludes) {
        if (excludes != null && excludes.length > 0) {
            DinnerDao dinnerDao = dinnerDaoProvider.get();

            List<Dinner> list = dinnerDao.queryBuilder()
                    .where(DinnerDao.Properties.Id.in(excludes))
                    .list();

            for (Dinner d : list) {
                d.setLastDrop(new Date());
                dinnerDao.update(d);
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
            return getScoreString(getlastUsageClause(), last_usage_score_weight);
        }

        @NonNull
        private String getLastDropScoreString() {
            return getScoreString(getlastDropClause(), last_drop_score_weight);
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

        private String getlastUsageClause() {
            return "(" + getCurrentDayNumber() + " - " + getDayNumberFactor(DinnerDao.Properties.LastUsage.columnName) +")";
        }

        private String getlastDropClause() {
            return "(" + getMinOf(subtract("100", subtract(getCurrentDayNumber(), getDayNumberFactor(DinnerDao.Properties.LastDrop.columnName))), "0") +")";
        }

        private String subtract(String value, String value2)
        {
            return "(" + value + " - " + value2 + ")";
        }

        private String getDayNumberFactor(String fieldOrValue)
        {
            return "(" + fieldOrValue  + " * 1000 * 60 * 60 * 24)";
        }

        private String getCurrentDayNumber()
        {
            return getDayNumberFactor(Long.toString(new Date().getTime()));
        }

        private String getBoolFactor(String field)
        {
            return "CASE " + field + " WHEN 1 THEN 1 ELSE -1 END";
        }

        private String getMinOf(String value, String value2)
        {
            return "CASE WHEN" + value + " < " + value2 + " THEN " + value2 + " ELSE " + value + " END";
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
}
