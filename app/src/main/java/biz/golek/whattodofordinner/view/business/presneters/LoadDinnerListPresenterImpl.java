package biz.golek.whattodofordinner.view.business.presneters;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.entities.Dinner;
import biz.golek.whattodofordinner.business.contract.presenters.LoadDinnerListPresenter;
import biz.golek.whattodofordinner.view.messages.DinnerLoadedMessage;

/**
 * Created by bg on 14.03.16.
 */
public class LoadDinnerListPresenterImpl implements LoadDinnerListPresenter {
    private EventBus eventBus;

    public LoadDinnerListPresenterImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void Show(List<Dinner> dinners) {
        biz.golek.whattodofordinner.view.messages.Dinner[] messageDinners
            = new biz.golek.whattodofordinner.view.messages.Dinner[dinners.size()];

        for (int i = 0; i < dinners.size(); i++) {
            Dinner d = dinners.get(i);
            messageDinners[i] = new biz.golek.whattodofordinner.view.messages.Dinner(d.getId(), d.getName());
        }

        eventBus.post(new DinnerLoadedMessage(messageDinners));
    }
}
