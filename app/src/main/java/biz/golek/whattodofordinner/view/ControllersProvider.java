package biz.golek.whattodofordinner.view;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;

/**
 * Created by bgolek on 2016-02-04.
 */
public class ControllersProvider {
    private final Provider<ShowSettingsController> showSettingsControllerProvider;
    private final Provider<AddNewDinnerController> addNewDinnerControllerProvider;

    public ControllersProvider(
        Provider<ShowSettingsController> showSettingsControllerProvider,
        Provider<AddNewDinnerController> addNewDinnerControllerProvider)
    {
        this.showSettingsControllerProvider = showSettingsControllerProvider;
        this.addNewDinnerControllerProvider = addNewDinnerControllerProvider;
    }

    public ShowSettingsController getShowSettingsController() {
        return showSettingsControllerProvider.get();
    }

    public AddNewDinnerController getAddNewDinnerController() {
        return addNewDinnerControllerProvider.get();
    }
}
