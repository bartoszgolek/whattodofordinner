package biz.golek.whattodofordinner.database.business.dao;

import java.util.List;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.ShowMarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

/**
 * Created by bgolek on 2016-02-24.
 */
public class ShowMarkDinnerUsedDaoImpl implements ShowMarkDinnerUsedDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public ShowMarkDinnerUsedDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public List<Dinner> getAllDinners() {
        return dinnerDaoProvider.get().loadAll();
    }
}
