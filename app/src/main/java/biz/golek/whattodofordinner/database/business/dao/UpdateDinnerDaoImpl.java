package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.UpdateDinnerDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class UpdateDinnerDaoImpl implements UpdateDinnerDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public UpdateDinnerDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public void updateDinner(Dinner entity) {
        Dinner dinner = dinnerDaoProvider.get()
                .queryBuilder()
                .where(DinnerDao.Properties.Id.eq(entity.getId()))
                .unique();

        entity.setCreationDate(dinner.getCreationDate());
        entity.setLastUsage(dinner.getLastUsage());
        entity.setLastDrop(dinner.getLastDrop());

        dinnerDaoProvider.get().update(entity);
    }
}
