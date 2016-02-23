package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowMarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.dao.SaveNewDinnerDao;
import biz.golek.whattodofordinner.business.contract.interactors.AddNewDinner;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.business.controllers.AddNewDinnerControllerImpl;
import biz.golek.whattodofordinner.business.controllers.SaveNewDinnerControllerImpl;
import biz.golek.whattodofordinner.business.controllers.ShowMarkDinnerUsedControllerImpl;
import biz.golek.whattodofordinner.business.interactors.AddNewDinnerImpl;
import biz.golek.whattodofordinner.business.interactors.SaveNewDinnerImpl;
import biz.golek.whattodofordinner.business.interactors.ShowMarkDinnerUsedImpl;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.business.dao.SaveNewDinnerDaoImpl;
import biz.golek.whattodofordinner.view.business.presneters.AddNewDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.SaveNewDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowMarkDinnerUsedPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Bartosz Gołek on 2016-02-05.
 */
@Module
public class MarkDinnerUsedModule {

    @Provides
    @Singleton
    static ShowMarkDinnerUsed provideShowMarkDinnerUsed(ShowMarkDinnerUsedPresenter showMarkDinnerUsedPresenter){
        return new ShowMarkDinnerUsedImpl(showMarkDinnerUsedPresenter);
    }

    @Provides
    @Singleton
    static ShowMarkDinnerUsedController provideShowMarkDinnerUsedController(ShowMarkDinnerUsed showMarkDinnerUsed){
        return new ShowMarkDinnerUsedControllerImpl(showMarkDinnerUsed);
    }

    @Provides
    @Singleton
    static ShowMarkDinnerUsedPresenter provideShowMarkDinnerUsedPresenter(ActivityPresenter starter){
        return new ShowMarkDinnerUsedPresenterImpl(starter);
    }

//    @Provides
//    @Singleton
//    static SaveNewDinner provideSaveNewDinner(
//            SaveNewDinnerPresenter saveNewDinnerPreseneter,
//            SaveNewDinnerDao saveNewDinnerDao
//    ){
//        return new SaveNewDinnerImpl(saveNewDinnerPreseneter, saveNewDinnerDao);
//    }
//
//    @Provides
//    @Singleton
//    static SaveNewDinnerController provideSaveNewDinnerController(SaveNewDinner saveNewDinner){
//        return new SaveNewDinnerControllerImpl(saveNewDinner);
//    }
//
//    @Provides
//    @Singleton
//    static SaveNewDinnerPresenter provideSaveNewDinnerPresenter(
//            ViewState viewState,
//            NotificationPresenter notification,
//            EventBus eventBus)
//    {
//        return new SaveNewDinnerPresenterImpl(viewState, notification, eventBus);
//    }
//
//    @Provides
//    @Singleton
//    static SaveNewDinnerDao provideSaveNewDinnerDao(Provider<DinnerDao> dinnerDaoProvider)
//    {
//        return new SaveNewDinnerDaoImpl(dinnerDaoProvider);
//    }
}
