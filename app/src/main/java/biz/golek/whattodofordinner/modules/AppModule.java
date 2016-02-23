package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.ViewStateManager;
import biz.golek.whattodofordinner.business.contract.controllers.AboutController;
import biz.golek.whattodofordinner.business.contract.controllers.AddBasePromptsController;
import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DeleteDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerChosenController;
import biz.golek.whattodofordinner.business.contract.controllers.EditDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.GeneratePromptsController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowGeneratePromptsPreferencesController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowMainController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowMarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinnerController;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.MainActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Bartosz Gołek on 2016-02-03.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    static ViewStateManager provideViewStateManager(ViewState viewState){
        return new ViewStateManager(viewState);
    }

    @Provides
    @Singleton
    static ViewState provideViewState(){
        return new ViewState();
    }

    @Provides
    @Singleton
    static ActivityDependencyProvider provideActivityDependencyProvider(
            Provider<EventBus> eventBus,
            Provider<AddNewDinnerController> addNewDinnerControllerProvider,
            Provider<SaveNewDinnerController> saveNewDinnerControllerProvider,
            Provider<DinnerListController> dinnerListControllerProvider,
            Provider<DeleteDinnerController> deleteDinnerControllerProvider,
            Provider<UpdateDinnerController> updateDinnerControllerProvider,
            Provider<EditDinnerController> editDinnerControllerProvider,
            Provider<ShowGeneratePromptsPreferencesController> showGeneratePromptsPreferencesControllerProvider,
            Provider<GeneratePromptsController> generatePromptsControllerProvider,
            Provider<DinnerChosenController> dinnerAcceptedControllerProvider,
            Provider<ShowMainController> showMainControllerProvider,
            Provider<AboutController> aboutControllerProvider,
            Provider<AddBasePromptsController> addBasePromptsControllerProvider,
            Provider<ShowMarkDinnerUsedController> showMarkDinnerUsedControllerProvider){
        return new ActivityDependencyProvider(
            eventBus,
            addNewDinnerControllerProvider,
            saveNewDinnerControllerProvider,
            dinnerListControllerProvider,
            deleteDinnerControllerProvider,
            updateDinnerControllerProvider,
            editDinnerControllerProvider,
            showGeneratePromptsPreferencesControllerProvider,
            generatePromptsControllerProvider,
            dinnerAcceptedControllerProvider,
            showMainControllerProvider,
            aboutControllerProvider,
            addBasePromptsControllerProvider,
            showMarkDinnerUsedControllerProvider);
    }

    @Provides
    @Singleton
    static ActivityPresenter providesActivityPresenter(ViewState viewState){
        return new ActivityPresenter(viewState);
    }

    @Provides
    @Singleton
    static MainActivityPresenter providesMainActivityPresenter(ViewState viewState){
        return new MainActivityPresenter(viewState);
    }

    @Provides
    @Singleton
    static NotificationPresenter providesNotificationPresenter(ViewState viewState){
        return new NotificationPresenter(viewState);
    }

    @Provides
    @Singleton
    static EventBus providesEventBus(){
        return EventBus.getDefault();
    }
}
