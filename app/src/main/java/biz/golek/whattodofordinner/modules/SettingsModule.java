package biz.golek.whattodofordinner.modules;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.ShowSettingsControllerImpl;
import biz.golek.whattodofordinner.business.contract.controllers.ShowSettingsController;
import biz.golek.whattodofordinner.business.contract.controllers.interactors.ShowSettings;
import biz.golek.whattodofordinner.business.contract.controllers.presenters.ShowSettingsPresenter;
import biz.golek.whattodofordinner.business.interactors.ShowSettingsImpl;
import biz.golek.whattodofordinner.view.contract.business.presneters.ShowSettingsPresenterImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-03.
 */
@Module
public class SettingsModule {

    @Provides
    @Singleton
    static ShowSettings provideShowSettings(){
        return new ShowSettingsImpl();
    }

    @Provides
    @Singleton
    static ShowSettingsController provideShowSettingsController(){
        return new ShowSettingsControllerImpl();
    }

    @Provides
    @Singleton
    static ShowSettingsPresenter provideShowSettingsPresenter(){
        return new ShowSettingsPresenterImpl();
    }

    @Provides
    @Singleton
    static ShowSettings provideViewState(){
        return new ShowSettingsImpl();
    }
}
