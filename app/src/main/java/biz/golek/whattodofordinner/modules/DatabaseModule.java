package biz.golek.whattodofordinner.modules;

import android.database.sqlite.SQLiteDatabase;

import biz.golek.whattodofordinner.DinnerOpenHelper;
import biz.golek.whattodofordinner.models.DaoMaster;
import biz.golek.whattodofordinner.models.DaoSession;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-08.
 */
@Module
public class DatabaseModule {
    @Provides
    public DinnerDao provideDinnerDao(ViewState viewState)
    {
        DinnerOpenHelper dinnerOpenHelper = new DinnerOpenHelper(viewState.getCurrentActivity());
        SQLiteDatabase db = dinnerOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        return daoSession.getDinnerDao();
    }
}