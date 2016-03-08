package biz.golek.whattodofordinner.database.business.dao;

import java.util.List;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.DinnerListDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

/**
 * Created by bg on 08.02.16.
 */
public class DinnerListDaoImpl implements DinnerListDao {
    private Provider<DinnerDao> dinnerDaoProvider;
    private DBDinnerToDinner converter;

    public DinnerListDaoImpl(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.converter = converter;
    }

    @Override
    public List<Dinner> getAllDinners() {
        return converter.toBusiness(dinnerDaoProvider.get().loadAll());
    }
}
