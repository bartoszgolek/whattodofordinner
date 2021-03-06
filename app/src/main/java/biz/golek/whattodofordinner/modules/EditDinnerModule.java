package biz.golek.whattodofordinner.modules;

import android.content.res.Resources;

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
import biz.golek.whattodofordinner.database.business.dao.DBDinnerToDinner;
import biz.golek.whattodofordinner.database.business.dao.EditDinnerDaoImpl;
import biz.golek.whattodofordinner.database.business.dao.UpdateDinnerDaoImpl;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.EditDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.UpdateDinnerPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.CloseCurrentActivityPresenter;
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
    static EditDinnerDao provideEditDinnerDao(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter){
        return new EditDinnerDaoImpl(dinnerDaoProvider, converter);
    }

    @Provides
    @Singleton
    static UpdateDinner provideUpdateDinner(
            UpdateDinnerPresenter updateDinnerPresenter,
            UpdateDinnerDao updateDinnerDao
    ){
        return new UpdateDinnerImpl(updateDinnerPresenter, updateDinnerDao);
    }

    @Provides
    @Singleton
    static UpdateDinnerController provideUpdateDinnerController(UpdateDinner updateDinner){
        return new UpdateDinnerControllerImpl(updateDinner);
    }

    @Provides
    @Singleton
    static UpdateDinnerPresenter provideUpdateDinnerPresenter(
            NotificationPresenter notification,
            CloseCurrentActivityPresenter closeCurrentActivityPresenter,
            Resources resources)
    {
        return new UpdateDinnerPresenterImpl(notification, closeCurrentActivityPresenter, resources);
    }

    @Provides
    @Singleton
    static UpdateDinnerDao provideUpdateDinnerDao(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter)
    {
        return new UpdateDinnerDaoImpl(dinnerDaoProvider, converter);
    }
}
