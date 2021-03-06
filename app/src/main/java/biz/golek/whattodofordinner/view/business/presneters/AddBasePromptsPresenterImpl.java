package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.res.Resources;

import org.greenrobot.eventbus.EventBus;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.presenters.AddBasePromptsPresenter;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.messages.Dinner;
import biz.golek.whattodofordinner.view.messages.DinnerAddedMessage;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-16.
 */
public class AddBasePromptsPresenterImpl implements AddBasePromptsPresenter {
    private ViewState viewState;
    private NotificationPresenter notification;
    private EventBus eventBus;

    public AddBasePromptsPresenterImpl(
            ViewState viewState,
            NotificationPresenter notification,
            EventBus eventBus) {
        this.viewState = viewState;
        this.notification = notification;
        this.eventBus = eventBus;
    }

    @Override
    public void Show(biz.golek.whattodofordinner.business.contract.entities.Dinner[] dinners) {
        Activity currentActivity = viewState.getCurrentActivity();
        Resources res = currentActivity.getApplication().getApplicationContext().getResources();
        notification.show(res.getString(R.string.dinners_generated_from_base_prompts));

        Dinner[] added = new Dinner[dinners.length];
        for (int i = 0; i < dinners.length; i++) {
            biz.golek.whattodofordinner.business.contract.entities.Dinner d = dinners[i];
            added[i] = new Dinner(d.getId(), d.getName());
        }

        eventBus.post(new DinnerAddedMessage(added));
    }
}
