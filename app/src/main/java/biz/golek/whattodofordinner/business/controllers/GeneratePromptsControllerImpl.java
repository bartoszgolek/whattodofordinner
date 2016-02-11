package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.GeneratePromptsController;
import biz.golek.whattodofordinner.business.contract.interactors.GeneratePrompts;
import biz.golek.whattodofordinner.business.contract.request_data.GeneratePromptsRequestData;

/**
 * Created by bg on 10.02.16.
 */
public class GeneratePromptsControllerImpl implements GeneratePromptsController {
    private GeneratePrompts interactor;

    public GeneratePromptsControllerImpl(GeneratePrompts interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run(GeneratePromptsRequestData requestData) {
        interactor.Run(requestData);
    }
}
