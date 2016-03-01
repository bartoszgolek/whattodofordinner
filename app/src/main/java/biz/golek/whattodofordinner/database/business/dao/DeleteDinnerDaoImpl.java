package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.DeleteDinnerDao;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.entities.Dinner;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class DeleteDinnerDaoImpl implements DeleteDinnerDao {
    private Provider<DinnerDao> dinnerDao;

    public DeleteDinnerDaoImpl(Provider<DinnerDao> dinnerDao) {
        this.dinnerDao = dinnerDao;
    }

    @Override
    public void Delete(Long id) {
        dinnerDao.get().delete(new Dinner(id));
    }
}
