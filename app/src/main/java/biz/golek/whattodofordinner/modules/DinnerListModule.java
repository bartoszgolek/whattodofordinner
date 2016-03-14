package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.DeleteDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowDinnerListController;
import biz.golek.whattodofordinner.business.contract.controllers.LoadDinnerListController;
import biz.golek.whattodofordinner.business.contract.dao.DeleteDinnerDao;
import biz.golek.whattodofordinner.business.contract.dao.LoadDinnerListDao;
import biz.golek.whattodofordinner.business.contract.interactors.DeleteDinner;
import biz.golek.whattodofordinner.business.contract.interactors.ShowDinnerList;
import biz.golek.whattodofordinner.business.contract.interactors.LoadDinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.DeleteDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.ShowDinnerListPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.LoadDinnerListPresenter;
import biz.golek.whattodofordinner.business.controllers.DeleteDinnerControllerImpl;
import biz.golek.whattodofordinner.business.controllers.ShowDinnerListControllerImpl;
import biz.golek.whattodofordinner.business.controllers.LoadDinnerListControllerImpl;
import biz.golek.whattodofordinner.business.interactors.DeleteDinnerImpl;
import biz.golek.whattodofordinner.business.interactors.LoadDinnerListImpl;
import biz.golek.whattodofordinner.database.business.dao.DBDinnerToDinner;
import biz.golek.whattodofordinner.database.business.dao.DeleteDinnerDaoImpl;
import biz.golek.whattodofordinner.database.business.dao.LoadDinnerListDaoImpl;
import biz.golek.whattodofordinner.business.interactors.ShowDinnerListImpl;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.DeleteDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowDinnerListPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.LoadDinnerListPresenterImpl;
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
    static ShowDinnerList provideShowDinnerList(
            ShowDinnerListPresenter showDinnerListPresenter
    ){
        return new ShowDinnerListImpl(showDinnerListPresenter);
    }

    @Provides
    @Singleton
    static ShowDinnerListController provideShowDinnerListController(ShowDinnerList showDinnerList){
        return new ShowDinnerListControllerImpl(showDinnerList);
    }

    @Provides
    @Singleton
    static ShowDinnerListPresenter provideShowDinnerListPresenter(ActivityPresenter activityPresenter){
        return new ShowDinnerListPresenterImpl(activityPresenter);
    }

    @Provides
    @Singleton
    static LoadDinnerList provideLoadDinnerList(
            LoadDinnerListPresenter loadDinnerListPresenter,
            LoadDinnerListDao loadDinnerListDao
    ){
        return new LoadDinnerListImpl(loadDinnerListPresenter, loadDinnerListDao);
    }

    @Provides
    @Singleton
    static LoadDinnerListController provideLoadDinnerListController(LoadDinnerList loadDinnerList){
        return new LoadDinnerListControllerImpl(loadDinnerList);
    }

    @Provides
    @Singleton
    static LoadDinnerListPresenter provideLoadDinnerListPresenter(EventBus eventBus){
        return new LoadDinnerListPresenterImpl(eventBus);
    }

    @Provides
    @Singleton
    static LoadDinnerListDao provideLoadDinnerListDao(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter){
        return new LoadDinnerListDaoImpl(dinnerDaoProvider, converter);
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
