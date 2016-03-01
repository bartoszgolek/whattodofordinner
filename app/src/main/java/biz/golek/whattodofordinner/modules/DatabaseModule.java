package biz.golek.whattodofordinner.modules;

import android.database.sqlite.SQLiteDatabase;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.DinnerOpenHelper;
import biz.golek.whattodofordinner.database.DaoMaster;
import biz.golek.whattodofordinner.database.DaoSession;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.business.dao.DBDinnerToDinner;
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
    public DinnerDao provideDinnerDao(ViewState viewState)
    {
        DinnerOpenHelper dinnerOpenHelper = new DinnerOpenHelper(viewState.getCurrentActivity());
        SQLiteDatabase db = dinnerOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        return daoSession.getDinnerDao();
    }

    @Provides
    @Singleton
    public DBDinnerToDinner provideDBDinnerToDinner()
    {
        return new DBDinnerToDinner();
    }
}
