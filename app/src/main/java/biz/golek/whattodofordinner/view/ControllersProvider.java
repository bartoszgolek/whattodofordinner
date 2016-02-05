package biz.golek.whattodofordinner.view;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;

/**
 * Created by bgolek on 2016-02-04.
 */
public class ControllersProvider {
    private final Provider<ShowSettingsController> showSettingsControllerProvider;
    private final Provider<AddNewDinnerController> addNewDinnerControllerProvider;
    private final Provider<SaveNewDinnerController> saveNewDinnerControllerProvider;

    public ControllersProvider(
            Provider<ShowSettingsController> showSettingsControllerProvider,
            Provider<AddNewDinnerController> addNewDinnerControllerProvider,
            Provider<SaveNewDinnerController> saveNewDinnerControllerProvider)
    {
        this.showSettingsControllerProvider = showSettingsControllerProvider;
        this.addNewDinnerControllerProvider = addNewDinnerControllerProvider;
        this.saveNewDinnerControllerProvider = saveNewDinnerControllerProvider;
    }

    public ShowSettingsController getShowSettingsController() {
        return showSettingsControllerProvider.get();
    }

    public AddNewDinnerController getAddNewDinnerController() {
        return addNewDinnerControllerProvider.get();
    }

    public SaveNewDinnerController getSaveNewDinnerController() {
        return saveNewDinnerControllerProvider.get();
    }
}
