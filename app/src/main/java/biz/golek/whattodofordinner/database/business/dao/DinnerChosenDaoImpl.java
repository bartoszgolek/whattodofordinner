package biz.golek.whattodofordinner.database.business.dao;

import java.util.Date;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.DinnerChosenDao;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.DinnerStatDao;
import biz.golek.whattodofordinner.database.entities.Dinner;
import biz.golek.whattodofordinner.database.entities.DinnerStat;
import biz.golek.whattodofordinner.database.entities.DinnerStatType;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerChosenDaoImpl implements DinnerChosenDao {
    private Provider<DinnerDao> dinnerDaoProvider;
    private Provider<DinnerStatDao> dinnerStatDaoProvider;

    public DinnerChosenDaoImpl(
            Provider<DinnerDao> dinnerDaoProvider,
            Provider<DinnerStatDao> dinnerStatDaoProvider)
    {
        this.dinnerDaoProvider = dinnerDaoProvider;
        this.dinnerStatDaoProvider = dinnerStatDaoProvider;
    }

    @Override
    public void SetDinnerAccepted(Long id) {
        DinnerDao dinnerDao = dinnerDaoProvider.get();
        DinnerStatDao dinnerStatDao = dinnerStatDaoProvider.get();

        Dinner dinner = dinnerDao.queryBuilder()
                .where(DinnerDao.Properties.Id.eq(id))
                .unique();

        Date usageDate = new Date();
        dinner.setLastUsage(usageDate);

        DinnerStat dinnerStat = new DinnerStat();
        dinnerStat.setType(DinnerStatType.Usage);
        dinnerStat.setDate(usageDate);
        dinnerStat.setDinnerId(dinner.getId());
        dinnerStatDao.insert(dinnerStat);

        dinnerDao.update(dinner);

    }
}
