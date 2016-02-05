package biz.golek.whattodofordinner.modules;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.ViewStateManager;
import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;
import biz.golek.whattodofordinner.view.ControllersProvider;
import biz.golek.whattodofordinner.view.helpers.ViewState;
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
            Provider<AddNewDinnerController> addNewDinnerControllerProvider
    ){
        return new ControllersProvider(
            showSettingsControllerProvider,
            addNewDinnerControllerProvider
        );
    }
}
