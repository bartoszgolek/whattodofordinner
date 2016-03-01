package biz.golek.whattodofordinner.view.business.presneters;

import android.content.res.Resources;

import org.greenrobot.eventbus.EventBus;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.presenters.SaveNewDinnerPresenter;
import biz.golek.whattodofordinner.view.helpers.ViewState;
import biz.golek.whattodofordinner.view.messages.AddedDinner;
import biz.golek.whattodofordinner.view.messages.DinnerAddedMessage;
import biz.golek.whattodofordinner.view.presneters.CloseCurrentActivityPresenter;
import biz.golek.whattodofordinner.view.presneters.NotificationPresenter;

/**
 * Created by bg on 05.02.16.
 */
public class SaveNewDinnerPresenterImpl implements SaveNewDinnerPresenter {
    private ViewState viewState;
    private NotificationPresenter notification;
    private EventBus eventBus;
    private Resources resources;
    private CloseCurrentActivityPresenter closeCurrentActivityPresenter;

    public SaveNewDinnerPresenterImpl(
            ViewState viewState,
            NotificationPresenter notification,
            EventBus eventBus, Resources resources, CloseCurrentActivityPresenter closeCurrentActivityPresenter) {
        this.viewState = viewState;
        this.notification = notification;
        this.eventBus = eventBus;
        this.resources = resources;
        this.closeCurrentActivityPresenter = closeCurrentActivityPresenter;
    }

    @Override
    public void ShowSaved(Dinner dinner) {
        notification.show(resources.getString(R.string.save_new_dinner_saved_message));

        eventBus.post(
            new DinnerAddedMessage(
                new AddedDinner[]{
                    new AddedDinner(dinner.getId(), dinner.getName())
                }
            )
        );

        closeCurrentActivityPresenter.closeActivity();
    }
}
