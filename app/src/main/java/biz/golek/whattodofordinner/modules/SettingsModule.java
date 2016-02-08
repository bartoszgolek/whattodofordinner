package biz.golek.whattodofordinner.modules;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.controllers.ShowSettingsControllerImpl;
import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;
import biz.golek.whattodofordinner.business.contract.interactors.ShowSettings;
import biz.golek.whattodofordinner.business.contract.presenters.ShowSettingsPresenter;
import biz.golek.whattodofordinner.business.interactors.ShowSettingsImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowSettingsPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ActivityStarter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-03.
 */
@Module
public class SettingsModule {

    @Provides
    @Singleton
    static ShowSettings provideShowSettings(ShowSettingsPresenter showSettingsPresenter){
        return new ShowSettingsImpl(showSettingsPresenter);
    }

    @Provides
    @Singleton
    static ShowSettingsController provideShowSettingsController(ShowSettings showSettings){
        return new ShowSettingsControllerImpl(showSettings);
    }

    @Provides
    @Singleton
    static ShowSettingsPresenter provideShowSettingsPresenter(ActivityStarter starter){
        return new ShowSettingsPresenterImpl(starter);
    }
}
