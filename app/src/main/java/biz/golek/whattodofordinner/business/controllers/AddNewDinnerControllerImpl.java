package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.AddNewDinner;

/**
 * Created by bgolek on 2016-02-05.
 */
public class AddNewDinnerControllerImpl implements AddNewDinnerController {

    private AddNewDinner interactor;

    public AddNewDinnerControllerImpl(AddNewDinner interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
