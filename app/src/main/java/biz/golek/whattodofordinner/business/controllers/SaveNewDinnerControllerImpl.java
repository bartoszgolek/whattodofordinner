package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerControllerImpl implements SaveNewDinnerController {
    private SaveNewDinner interactor;

    public SaveNewDinnerControllerImpl(SaveNewDinner interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run(SaveNewDinnerRequestData requestData) {
        interactor.Run(requestData);
    }
}
