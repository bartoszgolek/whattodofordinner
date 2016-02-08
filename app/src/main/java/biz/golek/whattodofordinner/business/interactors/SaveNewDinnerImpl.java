package biz.golek.whattodofordinner.business.interactors;

import android.database.sqlite.SQLiteDatabase;

import javax.inject.Provider;

import biz.golek.whattodofordinner.DinnerOpenHelper;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
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
    private SaveNewDinnerPresenter presenter;
    private Provider<DinnerDao> dinnerDaoProvider;

    public SaveNewDinnerImpl(
            SaveNewDinnerPresenter presenter,
            Provider<DinnerDao> dinnerDaoProvider
            ) {
        this.presenter = presenter;
        this.dinnerDaoProvider = dinnerDaoProvider;
    }

    @Override
    public void Run(SaveNewDinnerRequestData requestData) {
        DinnerDao dinnerDao = dinnerDaoProvider.get();

        Dinner entity = new Dinner();
        entity.setName(requestData.name);
        entity.setDuration(requestData.duration);
        entity.setSoup(requestData.soup);
        entity.setVegetarian(requestData.vegetarian);
        dinnerDao.insert(entity);

        presenter.ShowSaved();
    }
}
