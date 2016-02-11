package biz.golek.whattodofordinner.database.business.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.GeneratePromptsDao;
import biz.golek.whattodofordinner.business.contract.request_data.Duration;
import biz.golek.whattodofordinner.business.contract.request_data.Profile;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.models.DinnerDao;
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

        //queryBuilder.orderRaw("");

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
                d.setLestDrop(new Date());
                dinnerDao.update(d);
            }
        }
    }
}
