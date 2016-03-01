package biz.golek.whattodofordinner.database.business.dao;

import java.util.Date;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.SaveNewDinnerDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

public class SaveNewDinnerDaoImpl implements SaveNewDinnerDao {
    private Provider<DinnerDao> dinnerDaoProvider;
    private DBDinnerToDinner converter;

    public SaveNewDinnerDaoImpl(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.converter = converter;
    }

    public void saveDinner(Dinner dinner) {
        biz.golek.whattodofordinner.database.entities.Dinner entity = converter.toDatabase(dinner);
        entity.setCreationDate(new Date());
        dinnerDaoProvider.get().insert(entity);
    }
}
