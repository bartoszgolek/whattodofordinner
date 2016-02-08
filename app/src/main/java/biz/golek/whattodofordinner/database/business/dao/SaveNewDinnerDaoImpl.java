package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.SaveNewDinnerDao;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.models.DinnerDao;

public class SaveNewDinnerDaoImpl implements SaveNewDinnerDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public SaveNewDinnerDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    public void saveDinner(Dinner entity) {
        dinnerDaoProvider.get().insert(entity);
    }
}
