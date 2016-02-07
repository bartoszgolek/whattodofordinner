package biz.golek.whattodofordinner.business.interactors;

import android.database.sqlite.SQLiteDatabase;

import biz.golek.whattodofordinner.DinnerOpenHelper;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPreseneter;
import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;
import biz.golek.whattodofordinner.models.DaoMaster;
import biz.golek.whattodofordinner.models.DaoSession;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.helpers.ViewState;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerImpl implements SaveNewDinner {
    private SaveNewDinnerPreseneter presenter;
    private ViewState viewState;

    public SaveNewDinnerImpl(SaveNewDinnerPreseneter presenter, ViewState viewState) {
        this.presenter = presenter;
        this.viewState = viewState;
    }

    @Override
    public void Run(SaveNewDinnerRequestData requestData) {
        DinnerOpenHelper dinnerOpenHelper = new DinnerOpenHelper(viewState.getCurrentActivity());
        SQLiteDatabase db = dinnerOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        DinnerDao dinnerDao = daoSession.getDinnerDao();

        Dinner entity = new Dinner();
        entity.setName(requestData.name);
        entity.setDuration(requestData.duration);
        entity.setSoup(requestData.soup);
        entity.setVegetarian(requestData.vegetarian);
        dinnerDao.insert(entity);

        presenter.ShowSaved();
    }
}
