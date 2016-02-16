package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.AddBasePromptsController;
import biz.golek.whattodofordinner.business.contract.interactors.AddBasePrompts;

/**
 * Created by Bartosz Gołek on 2016-02-16.
 */
public class AddBasePromptsControllerImpl implements AddBasePromptsController {
    private AddBasePrompts interactor;

    public AddBasePromptsControllerImpl(AddBasePrompts interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
