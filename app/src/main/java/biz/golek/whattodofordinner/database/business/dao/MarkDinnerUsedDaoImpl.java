package biz.golek.whattodofordinner.database.business.dao;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.MarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.DinnerStatDao;
import biz.golek.whattodofordinner.database.entities.DinnerStat;
import biz.golek.whattodofordinner.database.entities.DinnerStatType;

/**
 * Created by Bartosz Gołek on 24.02.16.
 */
public class MarkDinnerUsedDaoImpl implements MarkDinnerUsedDao {
    private final Provider<DinnerDao> dinnerDaoProvider;
    private Provider<DinnerStatDao> dinnerStatDaoProvider;
    private DBDinnerToDinner converter;


    public MarkDinnerUsedDaoImpl(Provider<DinnerDao> dinnerDaoProvider, Provider<DinnerStatDao> dinnerStatDaoProvider, DBDinnerToDinner converter) {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.dinnerStatDaoProvider = dinnerStatDaoProvider;
        this.converter = converter;
    }

    @Override
    public Dinner GetDinner(Long dinnerId) {
        return converter.toBusiness(dinnerDaoProvider.get()
            .queryBuilder()
            .where(DinnerDao.Properties.Id.eq(dinnerId))
            .unique());
    }

    @Override
    public void SaveDinner(Dinner dinner) {
        biz.golek.whattodofordinner.database.entities.Dinner entity = converter.toDatabase(dinner);

        DinnerStat dinnerStat = new DinnerStat();
        dinnerStat.setType(DinnerStatType.Usage);
        dinnerStat.setDate(entity.getLastUsage());
        dinnerStat.setDinnerId(dinner.getId());
        dinnerStatDaoProvider.get().insert(dinnerStat);

        dinnerDaoProvider.get().update(entity);
    }
}
