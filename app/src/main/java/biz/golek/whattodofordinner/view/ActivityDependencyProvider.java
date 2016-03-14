package biz.golek.whattodofordinner.view;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;

import biz.golek.whattodofordinner.business.contract.controllers.AboutController;
import biz.golek.whattodofordinner.business.contract.controllers.AddBasePromptsController;
import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DeleteDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerChosenController;
import biz.golek.whattodofordinner.business.contract.controllers.EditDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.GeneratePromptsController;
import biz.golek.whattodofordinner.business.contract.controllers.LoadDinnerListController;
import biz.golek.whattodofordinner.business.contract.controllers.MarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowDinnerListController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowGeneratePromptsPreferencesController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowMainController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowMarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinnerController;

/**
 * Created by Bartosz Gołek on 2016-02-04.
 */
public class ActivityDependencyProvider {
    private Provider<EventBus> eventBusProvider;
    private final Provider<AddNewDinnerController> addNewDinnerControllerProvider;
    private final Provider<SaveNewDinnerController> saveNewDinnerControllerProvider;
    private final Provider<ShowDinnerListController> dinnerListControllerProvider;
    private final Provider<DeleteDinnerController> deleteDinnerControllerProvider;
    private final Provider<UpdateDinnerController> updateDinnerControllerProvider;
    private final Provider<EditDinnerController> editDinnerControllerProvider;
    private final Provider<ShowGeneratePromptsPreferencesController> showGeneratePromptsPreferencesControllerProvider;
    private final Provider<GeneratePromptsController> generatePromptsControllerProvider;
    private final Provider<DinnerChosenController> dinnerChosenControllerProvider;
    private final Provider<ShowMainController> showMainControllerProvider;
    private final Provider<AboutController> aboutControllerProvider;
    private final Provider<AddBasePromptsController> addBasePromptsControllerProvider;
    private final Provider<ShowMarkDinnerUsedController> showMarkDinnerUsedControllerProvider;
    private final Provider<MarkDinnerUsedController> markDinnerUsedControllerProvider;
    private final Provider<LoadDinnerListController> loadDinnerListControllerProvider;

    public ActivityDependencyProvider(
            Provider<EventBus> eventBusProvider,
            Provider<AddNewDinnerController> addNewDinnerControllerProvider,
            Provider<SaveNewDinnerController> saveNewDinnerControllerProvider,
            Provider<ShowDinnerListController> dinnerListControllerProvider,
            Provider<DeleteDinnerController> deleteDinnerControllerProvider,
            Provider<UpdateDinnerController> updateDinnerControllerProvider,
            Provider<EditDinnerController> editDinnerControllerProvider,
            Provider<ShowGeneratePromptsPreferencesController> showGeneratePromptsPreferencesControllerProvider,
            Provider<GeneratePromptsController> generatePromptsControllerProvider,
            Provider<DinnerChosenController> dinnerAcceptedControllerProvider,
            Provider<ShowMainController> showMainControllerProvider,
            Provider<AboutController> aboutControllerProvider,
            Provider<AddBasePromptsController> addBasePromptsControllerProvider,
            Provider<ShowMarkDinnerUsedController> showMarkDinnerUsedControllerProvider,
            Provider<MarkDinnerUsedController> markDinnerUsedControllerProvider,
            Provider<LoadDinnerListController> loadDinnerListControllerProvider)
    {
        this.eventBusProvider = eventBusProvider;
        this.addNewDinnerControllerProvider = addNewDinnerControllerProvider;
        this.saveNewDinnerControllerProvider = saveNewDinnerControllerProvider;
        this.dinnerListControllerProvider = dinnerListControllerProvider;
        this.deleteDinnerControllerProvider = deleteDinnerControllerProvider;
        this.updateDinnerControllerProvider = updateDinnerControllerProvider;
        this.editDinnerControllerProvider = editDinnerControllerProvider;
        this.showGeneratePromptsPreferencesControllerProvider = showGeneratePromptsPreferencesControllerProvider;
        this.generatePromptsControllerProvider = generatePromptsControllerProvider;
        this.dinnerChosenControllerProvider = dinnerAcceptedControllerProvider;
        this.showMainControllerProvider = showMainControllerProvider;
        this.aboutControllerProvider = aboutControllerProvider;
        this.addBasePromptsControllerProvider = addBasePromptsControllerProvider;
        this.showMarkDinnerUsedControllerProvider = showMarkDinnerUsedControllerProvider;
        this.markDinnerUsedControllerProvider = markDinnerUsedControllerProvider;
        this.loadDinnerListControllerProvider = loadDinnerListControllerProvider;
    }

    public AddNewDinnerController getAddNewDinnerController() {
        return addNewDinnerControllerProvider.get();
    }

    public SaveNewDinnerController getSaveNewDinnerController() {
        return saveNewDinnerControllerProvider.get();
    }

    public ShowDinnerListController getShowDinnerListController() {
        return dinnerListControllerProvider.get();
    }

    public EditDinnerController getEditDinnerController() {
        return editDinnerControllerProvider.get();
    }

    public DeleteDinnerController getDeleteDinnerController() {
        return deleteDinnerControllerProvider.get();
    }

    public Provider<EventBus> getEventBusProvider() {
        return eventBusProvider;
    }

    public UpdateDinnerController getUpdateDinnerController() {
        return updateDinnerControllerProvider.get();
    }

    public ShowGeneratePromptsPreferencesController getShowGeneratePromptsPreferencesController() {
        return showGeneratePromptsPreferencesControllerProvider.get();
    }

    public GeneratePromptsController getGeneratePromptsController() {
        return generatePromptsControllerProvider.get();
    }

    public DinnerChosenController getDinnerChosenController() {
        return dinnerChosenControllerProvider.get();
    }

    public ShowMainController getShowMainController() {
        return showMainControllerProvider.get();
    }

    public AboutController getShowAboutController() {
        return aboutControllerProvider.get();
    }

    public ShowMarkDinnerUsedController getShowMarkDinnerUsedController() {
        return showMarkDinnerUsedControllerProvider.get();
    }

    public MarkDinnerUsedController getMarkDinnerUsedController() {
        return markDinnerUsedControllerProvider.get();
    }

    public AddBasePromptsController getAddBasePromptsController() {
        return addBasePromptsControllerProvider.get();
    }

    public LoadDinnerListController getLoadDinnerListController() {
        return loadDinnerListControllerProvider.get();
    }
}
