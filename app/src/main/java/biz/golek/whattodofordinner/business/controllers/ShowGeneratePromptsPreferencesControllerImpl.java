package biz.golek.whattodofordinner.business.controllers;

import biz.golek.whattodofordinner.business.contract.controllers.ShowGeneratePromptsPreferencesController;
import biz.golek.whattodofordinner.business.contract.interactors.ShowGeneratePromptsPreferences;

/**
 * Created by bg on 10.02.16.
 */
public class ShowGeneratePromptsPreferencesControllerImpl implements ShowGeneratePromptsPreferencesController {
    private ShowGeneratePromptsPreferences interactor;

    public ShowGeneratePromptsPreferencesControllerImpl(ShowGeneratePromptsPreferences interactor) {
        this.interactor = interactor;
    }

    @Override
    public void Run() {
        interactor.Run();
    }
}
