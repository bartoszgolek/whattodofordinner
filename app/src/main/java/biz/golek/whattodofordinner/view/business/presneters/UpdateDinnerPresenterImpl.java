package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.res.Resources;

import org.greenrobot.eventbus.EventBus;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.presenters.UpdateDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.messages.DinnerUpdatedMessage;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class UpdateDinnerPresenterImpl implements UpdateDinnerPresenter {
    private ViewState viewState;
    private NotificationPresenter notification;
    private EventBus eventBus;

    public UpdateDinnerPresenterImpl(ViewState viewState, NotificationPresenter notification, EventBus eventBus) {
        this.viewState = viewState;
        this.notification = notification;
        this.eventBus = eventBus;
    }

    @Override
    public void ShowSaved(Dinner dinner) {
        Activity currentActivity = viewState.getCurrentActivity();
        Resources res = currentActivity.getApplication().getApplicationContext().getResources();
        notification.show(res.getString(R.string.update_dinner_saved_message));

        eventBus.post(new DinnerUpdatedMessage(dinner.getId(), dinner.getName()));

        currentActivity.finish();
    }
}
