package biz.golek.whattodofordinner.business.interactors;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.dao.SaveNewDinnerDao;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;
import biz.golek.whattodofordinner.models.Dinner;
import biz.golek.whattodofordinner.models.DinnerDao;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerImpl implements SaveNewDinner {
    private SaveNewDinnerPresenter presenter;
    private SaveNewDinnerDao saveNewDinnerDao;

    public SaveNewDinnerImpl(
            SaveNewDinnerPresenter presenter,
            SaveNewDinnerDao saveNewDinnerDao
    ) {
        this.presenter = presenter;
        this.saveNewDinnerDao = saveNewDinnerDao;
    }

    @Override
    public void Run(SaveNewDinnerRequestData requestData) {
        Dinner entity = new Dinner();
        entity.setName(requestData.name);
        entity.setDuration(requestData.duration);
        entity.setSoup(requestData.soup);
        entity.setVegetarian(requestData.vegetarian);
        entity.setSeasons(requestData.seasons);

        saveNewDinnerDao.saveDinner(entity);

        presenter.ShowSaved();
    }

}
