package biz.golek.whattodofordinner.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import biz.golek.whattodofordinner.database.entities.Dinner;
import biz.golek.whattodofordinner.database.entities.DinnerStat;
import biz.golek.whattodofordinner.database.entities.Ingredient;
import biz.golek.whattodofordinner.database.entities.DinnerIngredient;

import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.DinnerStatDao;
import biz.golek.whattodofordinner.database.IngredientDao;
import biz.golek.whattodofordinner.database.DinnerIngredientDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dinnerDaoConfig;
    private final DaoConfig dinnerStatDaoConfig;
    private final DaoConfig ingredientDaoConfig;
    private final DaoConfig dinnerIngredientDaoConfig;

    private final DinnerDao dinnerDao;
    private final DinnerStatDao dinnerStatDao;
    private final IngredientDao ingredientDao;
    private final DinnerIngredientDao dinnerIngredientDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dinnerDaoConfig = daoConfigMap.get(DinnerDao.class).clone();
        dinnerDaoConfig.initIdentityScope(type);

        dinnerStatDaoConfig = daoConfigMap.get(DinnerStatDao.class).clone();
        dinnerStatDaoConfig.initIdentityScope(type);

        ingredientDaoConfig = daoConfigMap.get(IngredientDao.class).clone();
        ingredientDaoConfig.initIdentityScope(type);

        dinnerIngredientDaoConfig = daoConfigMap.get(DinnerIngredientDao.class).clone();
        dinnerIngredientDaoConfig.initIdentityScope(type);

        dinnerDao = new DinnerDao(dinnerDaoConfig, this);
        dinnerStatDao = new DinnerStatDao(dinnerStatDaoConfig, this);
        ingredientDao = new IngredientDao(ingredientDaoConfig, this);
        dinnerIngredientDao = new DinnerIngredientDao(dinnerIngredientDaoConfig, this);

        registerDao(Dinner.class, dinnerDao);
        registerDao(DinnerStat.class, dinnerStatDao);
        registerDao(Ingredient.class, ingredientDao);
        registerDao(DinnerIngredient.class, dinnerIngredientDao);
    }
    
    public void clear() {
        dinnerDaoConfig.getIdentityScope().clear();
        dinnerStatDaoConfig.getIdentityScope().clear();
        ingredientDaoConfig.getIdentityScope().clear();
        dinnerIngredientDaoConfig.getIdentityScope().clear();
    }

    public DinnerDao getDinnerDao() {
        return dinnerDao;
    }

    public DinnerStatDao getDinnerStatDao() {
        return dinnerStatDao;
    }

    public IngredientDao getIngredientDao() {
        return ingredientDao;
    }

    public DinnerIngredientDao getDinnerIngredientDao() {
        return dinnerIngredientDao;
    }

}
