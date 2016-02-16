package biz.golek.whattodofordinner.modules;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.AddBasePromptsController;
import biz.golek.whattodofordinner.business.contract.dao.AddBasePromptsDao;
import biz.golek.whattodofordinner.business.contract.interactors.AddBasePrompts;
import biz.golek.whattodofordinner.business.contract.presenters.AddBasePromptsPresenter;
import biz.golek.whattodofordinner.business.controllers.AddBasePromptsControllerImpl;
import biz.golek.whattodofordinner.business.interactors.AddBasePromptsImpl;
import biz.golek.whattodofordinner.database.business.dao.AddBasePromptsDaoImpl;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.AddBasePromptsPresenterImpl;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-16.
 */
@Module
public class AddBasePromptsModule {

    @Provides
    @Singleton
    static AddBasePrompts provideAddBasePrompts(
            AddBasePromptsPresenter addBasePromptsPresenter,
            AddBasePromptsDao dao){
        return new AddBasePromptsImpl(addBasePromptsPresenter, dao);
    }

    @Provides
    @Singleton
    static AddBasePromptsController provideAddBasePromptsController(AddBasePrompts addBasePrompts){
        return new AddBasePromptsControllerImpl(addBasePrompts);
    }

    @Provides
    @Singleton
    static AddBasePromptsPresenter provideAddBasePromptsPresenter(
            ViewState viewState,
            NotificationPresenter notification,
            EventBus eventBus){
        return new AddBasePromptsPresenterImpl(viewState, notification, eventBus);
    }

    @Provides
    @Singleton
    static AddBasePromptsDao provideAddBasePromptsDao(Provider<DinnerDao> daoProvider){
        return new AddBasePromptsDaoImpl(daoProvider);
    }
}
