package biz.golek.whattodofordinner;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.modules.DatabaseModule;
import biz.golek.whattodofordinner.modules.DinnerListModule;
import biz.golek.whattodofordinner.modules.EditDinnerModule;
import biz.golek.whattodofordinner.modules.NewDinnerModule;
import biz.golek.whattodofordinner.modules.AppModule;
import dagger.Component;

/**
 * Created by bgolek on 2016-02-03.
 */
@Singleton
@Component(modules =
        {
                AppModule.class,
                DatabaseModule.class,
                NewDinnerModule.class,
                DinnerListModule.class,
                EditDinnerModule.class,
        })
public interface ApplicationComponent {
    ViewStateManager viewStateManager();
    ActivityDependencyProviderInjector activityDependencyProviderInjector();
}
