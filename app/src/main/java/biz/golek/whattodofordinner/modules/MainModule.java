package biz.golek.whattodofordinner.modules;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.ShowMainController;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMain;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMainPresenter;
import biz.golek.whattodofordinner.business.controllers.ShowMainControllerImpl;
import biz.golek.whattodofordinner.business.interactors.ShowMainImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowMainPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.MainActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Bartosz Gołek on 2016-02-05.
 */
@Module
public class MainModule {

    @Provides
    @Singleton
    static ShowMain provideDinnerList(
            ShowMainPresenter showMainPresenter
    ){
        return new ShowMainImpl(showMainPresenter);
    }

    @Provides
    @Singleton
    static ShowMainController provideShowMainController(ShowMain showMain){
        return new ShowMainControllerImpl(showMain);
    }

    @Provides
    @Singleton
    static ShowMainPresenter provideShowMainPresenter(MainActivityPresenter starter){
        return new ShowMainPresenterImpl(starter);
    }
}
