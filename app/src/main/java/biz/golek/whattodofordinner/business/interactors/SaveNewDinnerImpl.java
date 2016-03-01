package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.SaveNewDinnerDao;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;

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
        Dinner entity = new Dinner(
            requestData.name,
            requestData.duration,
            requestData.soup,
            requestData.vegetarian,
            requestData.spring,
            requestData.summer,
            requestData.autumn,
            requestData.winter);

        saveNewDinnerDao.saveDinner(entity);

        presenter.ShowSaved(entity);
    }

}
