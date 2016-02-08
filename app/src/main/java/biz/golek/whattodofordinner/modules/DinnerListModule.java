package biz.golek.whattodofordinner.modules;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.DinnerListController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.AddNewDinner;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
import biz.golek.whattodofordinner.business.controllers.AddNewDinnerControllerImpl;
import biz.golek.whattodofordinner.business.controllers.DinnerListControllerImpl;
import biz.golek.whattodofordinner.business.controllers.SaveNewDinnerControllerImpl;
import biz.golek.whattodofordinner.business.interactors.AddNewDinnerImpl;
import biz.golek.whattodofordinner.business.interactors.DinnerListImpl;
import biz.golek.whattodofordinner.business.interactors.SaveNewDinnerImpl;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.AddNewDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.DinnerListPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.SaveNewDinnerPreseneterImpl;
import biz.golek.whattodofordinner.view.helpers.ViewState;
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
    static DinnerListPresenter provideDinnerListPresenter(ViewState viewState){
        return new DinnerListPresenterImpl(viewState);
    }
}
