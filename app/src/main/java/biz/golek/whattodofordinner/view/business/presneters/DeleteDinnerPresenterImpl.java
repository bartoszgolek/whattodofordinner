package biz.golek.whattodofordinner.view.business.presneters;

import android.app.Activity;
import android.content.res.Resources;

import org.greenrobot.eventbus.EventBus;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.presenters.DeleteDinnerPresenter;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.messages.DinnerDeletedMessage;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class DeleteDinnerPresenterImpl implements DeleteDinnerPresenter {
    private NotificationPresenter notification;
    private EventBus eventBus;
    private ViewState viewState;

    public DeleteDinnerPresenterImpl(
            NotificationPresenter notification,
            EventBus eventBus,
            ViewState viewState
    ) {
        this.notification = notification;
        this.eventBus = eventBus;
        this.viewState = viewState;
    }

    @Override
    public void ShowDeleted(Long id) {
        Activity currentActivity = viewState.getCurrentActivity();
        Resources res = currentActivity.getApplication().getApplicationContext().getResources();
        notification.show(res.getString(R.string.dinner_deleted_message));
        eventBus.post(new DinnerDeletedMessage(id));
    }
}
