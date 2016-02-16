package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;


import biz.golek.whattodofordinner.business.contract.controllers.EditDinnerController;
import biz.golek.whattodofordinner.business.contract.dao.EditDinnerDao;
import biz.golek.whattodofordinner.business.contract.dao.UpdateDinnerDao;
import biz.golek.whattodofordinner.business.contract.interactors.EditDinner;
import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinner;
import biz.golek.whattodofordinner.business.contract.interactors.UpdateDinnerController;
import biz.golek.whattodofordinner.business.contract.presenters.EditDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.UpdateDinnerPresenter;
import biz.golek.whattodofordinner.business.controllers.EditDinnerControllerImpl;
import biz.golek.whattodofordinner.business.controllers.UpdateDinnerControllerImpl;
import biz.golek.whattodofordinner.business.interactors.EditDinnerImpl;
import biz.golek.whattodofordinner.business.interactors.UpdateDinnerImpl;
import biz.golek.whattodofordinner.database.business.dao.EditDinnerDaoImpl;
import biz.golek.whattodofordinner.database.business.dao.UpdateDinnerDaoImpl;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.EditDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.UpdateDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Bartosz Gołek on 2016-02-05.
 */
@Module
public class EditDinnerModule {

    @Provides
    @Singleton
    static EditDinner provideEditDinner(EditDinnerPresenter editDinnerPresenter, EditDinnerDao editDinnerDao){
        return new EditDinnerImpl(editDinnerPresenter, editDinnerDao);
    }

    @Provides
    @Singleton
    static EditDinnerController provideEditDinnerController(EditDinner editDinner){
        return new EditDinnerControllerImpl(editDinner);
    }

    @Provides
    @Singleton
    static EditDinnerPresenter provideEditDinnerPresenter(ActivityPresenter starter){
        return new EditDinnerPresenterImpl(starter);
    }

    @Provides
    @Singleton
    static EditDinnerDao provideEditDinnerDao(Provider<DinnerDao> dinnerDaoProvider){
        return new EditDinnerDaoImpl(dinnerDaoProvider);
    }

    @Provides
    @Singleton
    static UpdateDinner provideUpdateDinner(
            UpdateDinnerPresenter updateDinnerPreseneter,
            UpdateDinnerDao updateDinnerDao
    ){
        return new UpdateDinnerImpl(updateDinnerPreseneter, updateDinnerDao);
    }

    @Provides
    @Singleton
    static UpdateDinnerController provideUpdateDinnerController(UpdateDinner updateDinner){
        return new UpdateDinnerControllerImpl(updateDinner);
    }

    @Provides
    @Singleton
    static UpdateDinnerPresenter provideUpdateDinnerPresenter(
            ViewState viewState,
            NotificationPresenter notification,
            EventBus eventBus)
    {
        return new UpdateDinnerPresenterImpl(viewState, notification, eventBus);
    }

    @Provides
    @Singleton
    static UpdateDinnerDao provideUpdateDinnerDao(Provider<DinnerDao> dinnerDaoProvider)
    {
        return new UpdateDinnerDaoImpl(dinnerDaoProvider);
    }
}
