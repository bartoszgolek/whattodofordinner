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
    private DBDinnerToDinner converter;

    public MarkDinnerUsedDaoImpl(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.converter = converter;
    }

    @Override
    public Dinner GetDinner(Long dinnerId) {
        return converter.toBusiness(dinnerDaoProvider.get()
            .queryBuilder()
            .where(DinnerDao.Properties.Id.eq(dinnerId))
            .unique());
    }

    @Override
    public void SaveDinner(Dinner dinner) {
        dinnerDaoProvider.get().update(converter.toDatabase(dinner));
    }
}
