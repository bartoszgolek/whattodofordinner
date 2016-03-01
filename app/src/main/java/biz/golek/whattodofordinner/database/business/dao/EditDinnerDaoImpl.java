package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.EditDinnerDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

/**
 * Created by bg on 10.02.16.
 */
public class EditDinnerDaoImpl implements EditDinnerDao {
    private Provider<DinnerDao> dinnerDaoProvider;
    private DBDinnerToDinner converter;

    public EditDinnerDaoImpl(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.converter = converter;
    }

    @Override
    public Dinner GetDinner(Long id) {
        return converter.toBusiness(dinnerDaoProvider.get()
                .queryBuilder()
                .where(DinnerDao.Properties.Id.eq(id))
                .unique());
    }
}
