package biz.golek.whattodofordinner.modules;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.business.contract.controllers.AboutController;
import biz.golek.whattodofordinner.business.contract.interactors.About;
import biz.golek.whattodofordinner.business.contract.presenters.AboutPresenter;
import biz.golek.whattodofordinner.business.controllers.AboutControllerImpl;
import biz.golek.whattodofordinner.business.interactors.AboutImpl;
import biz.golek.whattodofordinner.view.presneters.AboutPresenterImpl;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-05.
 */
@Module
public class AboutModule {

    @Provides
    @Singleton
    static About provideAbout(
            AboutPresenter aboutPresenter
    ){
        return new AboutImpl(aboutPresenter);
    }

    @Provides
    @Singleton
    static AboutController provideAboutController(About about){
        return new AboutControllerImpl(about);
    }

    @Provides
    @Singleton
    static AboutPresenter provideAboutPresenter(ActivityPresenter starter){
        return new AboutPresenterImpl(starter);
    }
}
