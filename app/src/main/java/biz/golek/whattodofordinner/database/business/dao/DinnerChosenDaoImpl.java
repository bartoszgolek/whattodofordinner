package biz.golek.whattodofordinner.database.business.dao;

import java.util.Date;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.DinnerChosenDao;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.models.DinnerDao;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerChosenDaoImpl implements DinnerChosenDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public DinnerChosenDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public void SetDinnerAccepted(Long id) {
        DinnerDao dinnerDao = dinnerDaoProvider.get();
        Dinner dinner = dinnerDao.queryBuilder()
                .where(DinnerDao.Properties.Id.eq(id))
                .unique();
        dinner.setLastUsage(new Date());
        dinnerDao.update(dinner);

    }
}
