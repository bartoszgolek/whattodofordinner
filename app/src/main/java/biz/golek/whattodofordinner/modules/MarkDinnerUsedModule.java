package biz.golek.whattodofordinner.modules;

import android.content.res.Resources;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.MarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowMarkDinnerUsedController;
import biz.golek.whattodofordinner.business.contract.dao.MarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.dao.ShowMarkDinnerUsedDao;
import biz.golek.whattodofordinner.business.contract.interactors.MarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.interactors.ShowMarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.presenters.MarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMarkDinnerUsedPresenter;
import biz.golek.whattodofordinner.business.controllers.MarkDinnerUsedControllerImpl;
import biz.golek.whattodofordinner.business.controllers.ShowMarkDinnerUsedControllerImpl;
import biz.golek.whattodofordinner.business.interactors.MarkDinnerUsedImpl;
import biz.golek.whattodofordinner.business.interactors.ShowMarkDinnerUsedImpl;
import biz.golek.whattodofordinner.database.DinnerDao;
import biz.golek.whattodofordinner.database.business.dao.DBDinnerToDinner;
import biz.golek.whattodofordinner.database.business.dao.MarkDinnerUsedDaoImpl;
import biz.golek.whattodofordinner.database.business.dao.ShowMarkDinnerUsedDaoImpl;
import biz.golek.whattodofordinner.view.business.presneters.MarkDinnerUsedPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowMarkDinnerUsedPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.CloseCurrentActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
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
    static ShowMarkDinnerUsedDao provideShowMarkDinnerUsedDao(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter){
        return new ShowMarkDinnerUsedDaoImpl(dinnerDaoProvider, converter);
    }

    public ShowMarkDinnerUsedController getShowMarkDinnerUsedController(ShowMarkDinnerUsed interactor) {
        return new ShowMarkDinnerUsedControllerImpl(interactor);
    }

    public MarkDinnerUsedController getMarkDinnerUsedController(MarkDinnerUsed interactor) {
        return new MarkDinnerUsedControllerImpl(interactor);
    }

    @Provides
    @Singleton
    static MarkDinnerUsed provideMarkDinnerUsed(
            MarkDinnerUsedPresenter markDinnerUsedPreseneter,
            MarkDinnerUsedDao markDinnerUsedDao
    ){
        return new MarkDinnerUsedImpl(markDinnerUsedDao, markDinnerUsedPreseneter);
    }

    @Provides
    @Singleton
    static MarkDinnerUsedController provideMarkDinnerUsedController(MarkDinnerUsed markDinnerUsed){
        return new MarkDinnerUsedControllerImpl(markDinnerUsed);
    }

    @Provides
    @Singleton
    static MarkDinnerUsedPresenter provideMarkDinnerUsedPresenter(
            CloseCurrentActivityPresenter closeCurrentActivityPresenter,
            NotificationPresenter notification,
            Resources resources)
    {
        return new MarkDinnerUsedPresenterImpl(closeCurrentActivityPresenter, notification, resources);
    }

    @Provides
    @Singleton
    static MarkDinnerUsedDao provideMarkDinnerUsedDao(Provider<DinnerDao> dinnerDaoProvider, DBDinnerToDinner converter)
    {
        return new MarkDinnerUsedDaoImpl(dinnerDaoProvider, converter);
    }
}
