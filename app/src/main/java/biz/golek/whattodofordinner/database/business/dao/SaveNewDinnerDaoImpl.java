package biz.golek.whattodofordinner.database.business.dao;

import java.util.Date;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.SaveNewDinnerDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

public class SaveNewDinnerDaoImpl implements SaveNewDinnerDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public SaveNewDinnerDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    public void saveDinner(Dinner entity) {
        entity.setCreationDate(new Date());
        dinnerDaoProvider.get().insert(entity);
    }
}
