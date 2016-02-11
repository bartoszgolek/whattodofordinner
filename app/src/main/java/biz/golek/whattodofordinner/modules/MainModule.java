package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.DeleteDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowMainController;
import biz.golek.whattodofordinner.business.contract.dao.DeleteDinnerDao;
import biz.golek.whattodofordinner.business.contract.dao.DinnerListDao;
import biz.golek.whattodofordinner.business.contract.interactors.DeleteDinner;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMain;
import biz.golek.whattodofordinner.business.contract.presenters.DeleteDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMainPresenter;
import biz.golek.whattodofordinner.business.controllers.DeleteDinnerControllerImpl;
import biz.golek.whattodofordinner.business.controllers.DinnerListControllerImpl;
import biz.golek.whattodofordinner.business.controllers.ShowMainControllerImpl;
import biz.golek.whattodofordinner.business.interactors.DeleteDinnerImpl;
import biz.golek.whattodofordinner.business.interactors.DinnerListImpl;
import biz.golek.whattodofordinner.business.interactors.ShowMainImpl;
import biz.golek.whattodofordinner.database.business.dao.DeleteDinnerDaoImpl;
import biz.golek.whattodofordinner.database.business.dao.DinnerListDaoImpl;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.DeleteDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.DinnerListPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowMainPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.MainActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-05.
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
