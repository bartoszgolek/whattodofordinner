package biz.golek.whattodofordinner.modules;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.AddNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;
import biz.golek.whattodofordinner.business.controllers.AddNewDinnerControllerImpl;
import biz.golek.whattodofordinner.business.interactors.AddNewDinnerImpl;
import biz.golek.whattodofordinner.view.business.presneters.AddNewDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-05.
 */
@Module
public class AddNewDinnerModule {

    @Provides
    @Singleton
    static AddNewDinner provideAddNewDinner(AddNewDinnerPresenter addNewDinnerPresenter){
        return new AddNewDinnerImpl(addNewDinnerPresenter);
    }

    @Provides
    @Singleton
    static AddNewDinnerController provideAddNewDinnerController(AddNewDinner addNewDinner){
        return new AddNewDinnerControllerImpl(addNewDinner);
    }

    @Provides
    @Singleton
    static AddNewDinnerPresenter provideAddNewDinnerPresenter(ViewState viewState){
        return new AddNewDinnerPresenterImpl(viewState);
    }
}