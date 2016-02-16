package biz.golek.whattodofordinner;

import javax.inject.Singleton;

import biz.golek.whattodofordinner.modules.AboutModule;
import biz.golek.whattodofordinner.modules.AddBasePromptsModule;
import biz.golek.whattodofordinner.modules.DatabaseModule;
import biz.golek.whattodofordinner.modules.DinnerListModule;
import biz.golek.whattodofordinner.modules.EditDinnerModule;
import biz.golek.whattodofordinner.modules.GeneratePromptsModule;
import biz.golek.whattodofordinner.modules.MainModule;
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
                GeneratePromptsModule.class,
                MainModule.class,
                AboutModule.class,
                AddBasePromptsModule.class
        })
public interface ApplicationComponent {
    ViewStateManager viewStateManager();
    ActivityDependencyProviderInjector activityDependencyProviderInjector();
}
