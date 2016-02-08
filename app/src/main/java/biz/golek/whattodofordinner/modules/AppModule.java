package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.ViewStateManager;
import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.view.ControllersProvider;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-03.
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
    static ControllersProvider provideControllersProvider(
            Provider<ShowSettingsController> showSettingsControllerProvider,
            Provider<AddNewDinnerController> addNewDinnerControllerProvider,
            Provider<SaveNewDinnerController> saveNewDinnerControllerProvider,
            Provider<DinnerListController> dinnerListControllerProvider){
        return new ControllersProvider(
            showSettingsControllerProvider,
            addNewDinnerControllerProvider,
            saveNewDinnerControllerProvider,
            dinnerListControllerProvider);
    }

    @Provides
    @Singleton
    static ActivityPresenter providesActivityPresenter(ViewState viewState){
        return new ActivityPresenter(viewState);
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
