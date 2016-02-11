package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.DinnerAcceptedController;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerAccepted;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerAcceptedControllerImpl implements DinnerAcceptedController {
    private DinnerAccepted interactor;

    public DinnerAcceptedControllerImpl(DinnerAccepted interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run(Long id) {
        interactor.Run(id);
    }
}
