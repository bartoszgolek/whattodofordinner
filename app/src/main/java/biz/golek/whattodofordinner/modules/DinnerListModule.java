package biz.golek.whattodofordinner.modules;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.controllers.DinnerListControllerImpl;
import biz.golek.whattodofordinner.business.interactors.DinnerListImpl;
import biz.golek.whattodofordinner.view.business.presneters.DinnerListPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ActivityStarter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-05.
 */
@Module
public class DinnerListModule {

    @Provides
    @Singleton
    static DinnerList provideDinnerList(DinnerListPresenter dinnerListPresenter){
        return new DinnerListImpl(dinnerListPresenter);
    }

    @Provides
    @Singleton
    static DinnerListController provideDinnerListController(DinnerList dinnerList){
        return new DinnerListControllerImpl(dinnerList);
    }

    @Provides
    @Singleton
    static DinnerListPresenter provideDinnerListPresenter(ActivityStarter starter){
        return new DinnerListPresenterImpl(starter);
    }
}
