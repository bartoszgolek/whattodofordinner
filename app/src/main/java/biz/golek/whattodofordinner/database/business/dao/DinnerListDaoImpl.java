package biz.golek.whattodofordinner.database.business.dao;

import java.util.List;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.DinnerListDao;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.models.DinnerDao;

/**
 * Created by bg on 08.02.16.
 */
public class DinnerListDaoImpl implements DinnerListDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public DinnerListDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public List<Dinner> getAllDinners() {
        return dinnerDaoProvider.get().loadAll();
    }
}
