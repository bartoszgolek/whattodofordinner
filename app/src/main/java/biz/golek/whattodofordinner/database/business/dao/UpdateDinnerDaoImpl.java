package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.UpdateDinnerDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.view.helpers.FlagHelper;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class UpdateDinnerDaoImpl implements UpdateDinnerDao {
    private Provider<DinnerDao> dinnerDaoProvider;
    private DBDinnerToDinner converter;

    public UpdateDinnerDaoImpl(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.converter = converter;
    }

    @Override
    public void updateDinner(Dinner dinner) {
        biz.golek.whattodofordinner.database.entities.Dinner dbDinner = dinnerDaoProvider.get()
                .queryBuilder()
                .where(DinnerDao.Properties.Id.eq(dinner.getId()))
                .unique();

        dinnerDaoProvider.get().update(converter.toDatabase(dbDinner, dinner));
    }
}
