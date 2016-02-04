package biz.golek.whattodofordinner.view;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;

/**
 * Created by bgolek on 2016-02-04.
 */
public class ControllersProvider {
    private final Provider<ShowSettingsController> showSettingsControllerProvider;

    public ControllersProvider(Provider<ShowSettingsController> showSettingsControllerProvider)
    {
        this.showSettingsControllerProvider = showSettingsControllerProvider;
    }

    public ShowSettingsController getShowSettingsController() {
        return showSettingsControllerProvider.get();
    }
}
