package biz.golek.whattodofordinner;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.modules.NewDinnerModule;
import biz.golek.whattodofordinner.modules.AppModule;
import biz.golek.whattodofordinner.modules.SettingsModule;
import dagger.Component;

/**
 * Created by bgolek on 2016-02-03.
 */
@Singleton
@Component(modules =
        {
                AppModule.class,
                SettingsModule.class,
                NewDinnerModule.class
        })
public interface ApplicationComponent {
    ViewStateManager viewStateManager();
    ControllersProviderInjector controllersProviderInjector();
}
