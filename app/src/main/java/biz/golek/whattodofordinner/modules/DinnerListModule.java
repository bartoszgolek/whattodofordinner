package biz.golek.whattodofordinner.modules;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.business.contract.dao.DinnerListDao;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.controllers.DinnerListControllerImpl;
import biz.golek.whattodofordinner.database.business.dao.DinnerListDaoImpl;
import biz.golek.whattodofordinner.business.interactors.DinnerListImpl;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.DinnerListPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-05.
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
}
