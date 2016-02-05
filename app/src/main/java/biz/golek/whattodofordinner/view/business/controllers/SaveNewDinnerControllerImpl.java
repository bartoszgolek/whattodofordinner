package biz.golek.whattodofordinner.view.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;
import biz.golek.whattodofordinner.view.view_models.Dinner;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerControllerImpl implements SaveNewDinnerController {
    private SaveNewDinner interactor;

    public SaveNewDinnerControllerImpl(SaveNewDinner interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run(Dinner requestData) {
        interactor.Run(null);
    }
}
