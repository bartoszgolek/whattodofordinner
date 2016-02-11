package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.DinnerChosenController;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerChosen;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerChosenControllerImpl implements DinnerChosenController {
    private DinnerChosen interactor;

    public DinnerChosenControllerImpl(DinnerChosen interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run(Long id, String name) {
        interactor.Run(id, name);
    }
}
