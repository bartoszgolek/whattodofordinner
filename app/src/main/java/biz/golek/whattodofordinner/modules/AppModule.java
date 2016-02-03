package biz.golek.whattodofordinner.modules;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.ViewStateManager;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bgolek on 2016-02-03.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    static ViewStateManager provideViewStateManager(){
        return new ViewStateManager();
    }

    @Provides
    @Singleton
    static ViewState provideViewState(){
        return new ViewState();
    }
}
