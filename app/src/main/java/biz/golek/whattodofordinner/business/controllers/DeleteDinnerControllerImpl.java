package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.DeleteDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.DeleteDinner;

/**
 * Created by bgolek on 2016-02-10.
 */
public class DeleteDinnerControllerImpl implements DeleteDinnerController {
    private DeleteDinner interactor;

    public DeleteDinnerControllerImpl(DeleteDinner interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run(Long id) {
        interactor.Run(id);
    }
}
