package biz.golek.whattodofordinner.modules;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.AddNewDinnerController;
import biz.golek.whattodofordinner.business.contract.controllers.SaveNewDinnerController;
import biz.golek.whattodofordinner.business.contract.interactors.AddNewDinner;
import biz.golek.whattodofordinner.business.contract.interactors.SaveNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
import biz.golek.whattodofordinner.business.interactors.SaveNewDinnerImpl;
import biz.golek.whattodofordinner.business.controllers.AddNewDinnerControllerImpl;
import biz.golek.whattodofordinner.business.interactors.AddNewDinnerImpl;
import biz.golek.whattodofordinner.business.controllers.SaveNewDinnerControllerImpl;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.AddNewDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.SaveNewDinnerPreseneterImpl;
import biz.golek.whattodofordinner.view.helpers.ActivityStarter;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-05.
 */
@Module
public class NewDinnerModule {

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
    static AddNewDinnerPresenter provideAddNewDinnerPresenter(ActivityStarter starter){
        return new AddNewDinnerPresenterImpl(starter);
    }

    @Provides
    @Singleton
    static SaveNewDinner provideSaveNewDinner(
            SaveNewDinnerPresenter saveNewDinnerPreseneter,
            Provider<DinnerDao> dinnerDaoProvider
    ){
        return new SaveNewDinnerImpl(saveNewDinnerPreseneter, dinnerDaoProvider);
    }

    @Provides
    @Singleton
    static SaveNewDinnerController provideSaveNewDinnerController(SaveNewDinner saveNewDinner){
        return new SaveNewDinnerControllerImpl(saveNewDinner);
    }

    @Provides
    @Singleton
    static SaveNewDinnerPresenter provideSaveNewDinnerPresenter(ViewState viewState){
        return new SaveNewDinnerPreseneterImpl(viewState);
    }
}
