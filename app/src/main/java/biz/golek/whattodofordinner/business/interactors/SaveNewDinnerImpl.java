package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPreseneter;
import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerImpl implements SaveNewDinner {
    private SaveNewDinnerPreseneter presenter;

    public SaveNewDinnerImpl(SaveNewDinnerPreseneter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Run(SaveNewDinnerRequestData requestData) {
        //TODO: DO ORM logic
        presenter.ShowSaved();
    }
}
