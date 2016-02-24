package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.MarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public class MarkDinnerUsedDaoImpl implements MarkDinnerUsedDao {
    private final Provider<DinnerDao> dinnerDaoProvider;

    public MarkDinnerUsedDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public Dinner GetDinner(Long dinnerId) {
        return dinnerDaoProvider.get()
            .queryBuilder()
            .where(DinnerDao.Properties.Id.eq(dinnerId))
            .unique();
    }

    @Override
    public void SaveDinner(Dinner dinner) {
        dinnerDaoProvider.get().update(dinner);
    }
}
