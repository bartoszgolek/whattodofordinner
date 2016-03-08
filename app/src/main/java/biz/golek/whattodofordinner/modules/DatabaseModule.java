package biz.golek.whattodofordinner.modules;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.DinnerOpenHelper;
import biz.golek.whattodofordinner.database.DaoMaster;
import biz.golek.whattodofordinner.database.DaoSession;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.DinnerStatDao;
import biz.golek.whattodofordinner.database.business.dao.DBDinnerToDinner;
import biz.golek.whattodofordinner.database.migrations.Migration1to2;
import biz.golek.whattodofordinner.utils.migrations.Migration;
import biz.golek.whattodofordinner.utils.migrations.MigrationHelper;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Bartosz Gołek on 2016-02-08.
 */
@Module
public class DatabaseModule {
    @Provides
    @Singleton
    public DinnerDao provideDinnerDao(DaoSession daoSession)
    {
        return daoSession.getDinnerDao();
    }

    @Provides
    @Singleton
    public DinnerStatDao provideDinnerStatDao(DaoSession daoSession)
    {
        return daoSession.getDinnerStatDao();
    }

    @Provides
    @Singleton
    public DaoSession provideDaoSession(ViewState viewState, MigrationHelper migrationHelper)
    {
        DinnerOpenHelper dinnerOpenHelper = new DinnerOpenHelper(viewState.getCurrentActivity(), migrationHelper);
        SQLiteDatabase db = dinnerOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

    @Provides
    public MigrationHelper provideMigrationHelper()
    {
        Class[] migrations = {
               Migration1to2.class
        };
        return new MigrationHelper(migrations);
    }

    @Provides
    @Singleton
    public DBDinnerToDinner provideDBDinnerToDinner()
    {
        return new DBDinnerToDinner();
    }
}
