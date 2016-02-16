package biz.golek.whattodofordinner.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import biz.golek.whattodofordinner.business.contract.entities.Dinner;

import biz.golek.whattodofordinner.database.DinnerDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dinnerDaoConfig;

    private final DinnerDao dinnerDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dinnerDaoConfig = daoConfigMap.get(DinnerDao.class).clone();
        dinnerDaoConfig.initIdentityScope(type);

        dinnerDao = new DinnerDao(dinnerDaoConfig, this);

        registerDao(Dinner.class, dinnerDao);
    }
    
    public void clear() {
        dinnerDaoConfig.getIdentityScope().clear();
    }

    public DinnerDao getDinnerDao() {
        return dinnerDao;
    }

}