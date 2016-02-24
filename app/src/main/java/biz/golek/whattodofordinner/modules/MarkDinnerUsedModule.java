package biz.golek.whattodofordinner.modules;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.ShowMarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.dao.ShowMarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.business.controllers.ShowMarkDinnerUsedControllerImpl;
import biz.golek.whattodofordinner.business.interactors.ShowMarkDinnerUsedImpl;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.business.dao.ShowMarkDinnerUsedDaoImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowMarkDinnerUsedPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Bartosz Gołek on 2016-02-05.
 */
@Module
public class MarkDinnerUsedModule {

    @Provides
    @Singleton
    static ShowMarkDinnerUsed provideShowMarkDinnerUsed(ShowMarkDinnerUsedPresenter showMarkDinnerUsedPresenter, ShowMarkDinnerUsedDao dao){
        return new ShowMarkDinnerUsedImpl(showMarkDinnerUsedPresenter, dao);
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

    @Provides
    @Singleton
    static ShowMarkDinnerUsedDao provideShowMarkDinnerUsedDao(Provider<DinnerDao> dinnerDaoProvider){
        return new ShowMarkDinnerUsedDaoImpl(dinnerDaoProvider);
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
