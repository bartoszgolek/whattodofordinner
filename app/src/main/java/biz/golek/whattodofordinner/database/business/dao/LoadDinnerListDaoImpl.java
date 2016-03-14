package biz.golek.whattodofordinner.database.business.dao;

import java.util.List;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.LoadDinnerListDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

/**
 * Created by bg on 08.02.16.
 */
public class LoadDinnerListDaoImpl implements LoadDinnerListDao {
    private Provider<DinnerDao> dinnerDaoProvider;
    private DBDinnerToDinner converter;

    public LoadDinnerListDaoImpl(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.converter = converter;
    }

    @Override
    public List<Dinner> getAllDinners() {
        return converter.toBusiness(
                dinnerDaoProvider.get()
                    .queryBuilder()
                    .orderAsc(DinnerDao.Properties.Name)
                    .list()
                );
    }
}
