package biz.golek.whattodofordinner.business.interactors;

import javax.inject.Inject;

import biz.golek.whattodofordinner.business.contract.controllers.interactors.ShowSettings;
import biz.golek.whattodofordinner.business.contract.controllers.presenters.ShowSettingsPresenter;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsImpl implements ShowSettings {

    @Inject
    ShowSettingsPresenter controller;

    @Override
    public void Run() {
        controller.Show();
    }
}
