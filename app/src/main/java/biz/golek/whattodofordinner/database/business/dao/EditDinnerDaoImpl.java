package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.EditDinnerDao;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.models.DinnerDao;

/**
 * Created by bg on 10.02.16.
 */
public class EditDinnerDaoImpl implements EditDinnerDao {
    private Provider<DinnerDao> dinnerDaoProvider;

    public EditDinnerDaoImpl(Provider<DinnerDao> dinnerDaoProvider) {
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public Dinner GetDinner(Long id) {
        return dinnerDaoProvider.get()
                .queryBuilder()
                .where(DinnerDao.Properties.Id.eq(id))
                .unique();
    }
}
