package biz.golek.whattodofordinner.modules;

import javax.inject.Provider;
import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.DinnerAcceptedController;
import biz.golek.whattodofordinner.business.contract.controllers.GeneratePromptsController;
import biz.golek.whattodofordinner.business.contract.controllers.ShowGeneratePromptsPreferencesController;
import biz.golek.whattodofordinner.business.contract.dao.DinnerAcceptedDao;
import biz.golek.whattodofordinner.business.contract.dao.GeneratePromptsDao;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerAccepted;
import biz.golek.whattodofordinner.business.contract.interactors.GeneratePrompts;
import biz.golek.whattodofordinner.business.contract.interactors.ShowGeneratePromptsPreferences;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerAcceptedPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.GeneratePromptsPresenter;
import biz.golek.whattodofordinner.business.contract.presenters.ShowGeneratePromptsPreferencesPresenter;
import biz.golek.whattodofordinner.business.controllers.DinnerAcceptedControllerImpl;
import biz.golek.whattodofordinner.business.controllers.GeneratePromptsControllerImpl;
import biz.golek.whattodofordinner.business.controllers.ShowGeneratePromptsPreferencesControllerImpl;
import biz.golek.whattodofordinner.business.interactors.DinnerAcceptedImpl;
import biz.golek.whattodofordinner.business.interactors.GeneratePromptsImpl;
import biz.golek.whattodofordinner.business.interactors.ShowGeneratePromptsPreferencesImpl;
import biz.golek.whattodofordinner.database.business.dao.DinnerAcceptedDaoImpl;
import biz.golek.whattodofordinner.database.business.dao.GeneratePromptsDaoImpl;
import biz.golek.whattodofordinner.models.DinnerDao;
import biz.golek.whattodofordinner.view.business.presneters.DinnerAcceptedPresenterImpl;
import biz.golek.whattodofordinner.view.business.presneters.ShowGeneratePromptsPreferencesPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.GeneratePromptsPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.MainActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-05.
 */
@Module
public class GeneratePromptsModule {

    @Provides
    @Singleton
    static ShowGeneratePromptsPreferences provideShowGeneratePromptsPreferences(
            ShowGeneratePromptsPreferencesPresenter showGeneratePromptsPreferencesPresenter
    ){
        return new ShowGeneratePromptsPreferencesImpl(showGeneratePromptsPreferencesPresenter);
    }

    @Provides
    @Singleton
    static ShowGeneratePromptsPreferencesController provideShowGeneratePromptsPreferencesController(
            ShowGeneratePromptsPreferences showGeneratePromptsPreferences
    ){
        return new ShowGeneratePromptsPreferencesControllerImpl(showGeneratePromptsPreferences);
    }

    @Provides
    @Singleton
    static ShowGeneratePromptsPreferencesPresenter provideShowGeneratePromptsPreferencesPresenter(
            ActivityPresenter starter
    ){
        return new ShowGeneratePromptsPreferencesPresenterImpl(starter);
    }

    @Provides
    @Singleton
    static GeneratePrompts provideGeneratePrompts(
            GeneratePromptsDao generatePromptsDao,
            GeneratePromptsPresenter generatePromptsPresenter
    ){
        return new GeneratePromptsImpl(generatePromptsDao, generatePromptsPresenter);
    }

    @Provides
    @Singleton
    static GeneratePromptsController provideGeneratePromptsController(
            GeneratePrompts generatePrompts
    ){
        return new GeneratePromptsControllerImpl(generatePrompts);
    }

    @Provides
    @Singleton
    static GeneratePromptsPresenter provideGeneratePromptsPresenter(
            ActivityPresenter starter
    ){
        return new GeneratePromptsPresenterImpl(starter);
    }

    @Provides
    @Singleton
    static GeneratePromptsDao provideGeneratePromptsDao(
            Provider<DinnerDao> dinnerDaoProvider
    ){
        return new GeneratePromptsDaoImpl(dinnerDaoProvider);
    }

    @Provides
    @Singleton
    static DinnerAccepted provideDinnerAccepted(
            DinnerAcceptedDao dinnerAcceptedDao,
            DinnerAcceptedPresenter dinnerAcceptedPresenter
    ){
        return new DinnerAcceptedImpl(dinnerAcceptedDao, dinnerAcceptedPresenter);
    }

    @Provides
    @Singleton
    static DinnerAcceptedController provideDinnerAcceptedController(
            DinnerAccepted dinnerAccepted
    ){
        return new DinnerAcceptedControllerImpl(dinnerAccepted);
    }

    @Provides
    @Singleton
    static DinnerAcceptedPresenter provideDinnerAcceptedPresenter(
            MainActivityPresenter starter
    ){
        return new DinnerAcceptedPresenterImpl(starter);
    }

    @Provides
    @Singleton
    static DinnerAcceptedDao provideDinnerAcceptedDao(
            Provider<DinnerDao> dinnerDaoProvider
    ){
        return new DinnerAcceptedDaoImpl(dinnerDaoProvider);
    }
}
