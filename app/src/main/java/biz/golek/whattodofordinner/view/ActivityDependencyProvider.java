package biz.golek.whattodofordinner.view;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DeleteDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;

/**
 * Created by bgolek on 2016-02-04.
 */
public class ActivityDependencyProvider {
    private Provider<EventBus> eventBusProvider;
    private final Provider<AddNewDinnerController> addNewDinnerControllerProvider;
    private final Provider<SaveNewDinnerController> saveNewDinnerControllerProvider;
    private final Provider<DinnerListController> dinnerListControllerProvider;
    private final Provider<DeleteDinnerController> deleteDinnerControllerProvider;

    public ActivityDependencyProvider(
            Provider<EventBus> eventBusProvider,
            Provider<AddNewDinnerController> addNewDinnerControllerProvider,
            Provider<SaveNewDinnerController> saveNewDinnerControllerProvider,
            Provider<DinnerListController> dinnerListControllerProvider,
            Provider<DeleteDinnerController> deleteDinnerControllerProvider)
    {
        this.eventBusProvider = eventBusProvider;
        this.addNewDinnerControllerProvider = addNewDinnerControllerProvider;
        this.saveNewDinnerControllerProvider = saveNewDinnerControllerProvider;
        this.dinnerListControllerProvider = dinnerListControllerProvider;
        this.deleteDinnerControllerProvider = deleteDinnerControllerProvider;
    }

    public AddNewDinnerController getAddNewDinnerController() {
        return addNewDinnerControllerProvider.get();
    }

    public SaveNewDinnerController getSaveNewDinnerController() {
        return saveNewDinnerControllerProvider.get();
    }

    public DinnerListController getShowDinnerListController() {
        return dinnerListControllerProvider.get();
    }

    public DeleteDinnerController getDeleteDinnerController() {
        return deleteDinnerControllerProvider.get();
    }

    public Provider<EventBus> getEventBusProvider() {
        return eventBusProvider;
    }
}
