package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.DeleteDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.business.contract.dao.DeleteDinnerDao;
import biz.golek.whattodofordinner.business.contract.dao.DinnerListDao;
import biz.golek.whattodofordinner.business.contract.interactors.DeleteDinner;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.DeleteDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.controllers.DeleteDinnerControllerImpl;
import biz.golek.whattodofordinner.business.controllers.DinnerListControllerImpl;
import biz.golek.whattodofordinner.business.interactors.DeleteDinnerImpl;
import biz.golek.whattodofordinner.database.business.dao.DeleteDinnerDaoImpl;
import biz.golek.whattodofordinner.database.business.dao.DinnerListDaoImpl;
import biz.golek.whattodofordinner.business.interactors.DinnerListImpl;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.DeleteDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.DinnerListPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Bartosz Gołek on 2016-02-05.
 */
@Module
public class DinnerListModule {

    @Provides
    @Singleton
    static DinnerList provideDinnerList(
            DinnerListPresenter dinnerListPresenter,
            DinnerListDao dinnerListDao
    ){
        return new DinnerListImpl(dinnerListPresenter, dinnerListDao);
    }

    @Provides
    @Singleton
    static DinnerListController provideDinnerListController(DinnerList dinnerList){
        return new DinnerListControllerImpl(dinnerList);
    }

    @Provides
    @Singleton
    static DinnerListPresenter provideDinnerListPresenter(ActivityPresenter starter){
        return new DinnerListPresenterImpl(starter);
    }

    @Provides
    @Singleton
    static DinnerListDao provideDinnerListDao(Provider<DinnerDao> dinnerDaoProvider){
        return new DinnerListDaoImpl(dinnerDaoProvider);
    }

    @Provides
    @Singleton
    static DeleteDinnerController provideDeleteDinnerListController(DeleteDinner interactor){
        return new DeleteDinnerControllerImpl(interactor);
    }

    @Provides
    @Singleton
    static DeleteDinner provideDeleteDinner(
            DeleteDinnerPresenter deleteDinnerPresenter,
            DeleteDinnerDao deleteDinnerDao
    ){
        return new DeleteDinnerImpl(deleteDinnerDao, deleteDinnerPresenter);
    }

    @Provides
    @Singleton
    static DeleteDinnerPresenter provideDeleteDinnerPresenter(
            NotificationPresenter presenter,
            EventBus eventBus,
            ViewState viewState){
        return new DeleteDinnerPresenterImpl(presenter, eventBus, viewState);
    }

    @Provides
    @Singleton
    static DeleteDinnerDao provideDeleteDinnerDao(Provider<DinnerDao> dinnerDaoProvider){
        return new DeleteDinnerDaoImpl(dinnerDaoProvider);
    }
}
