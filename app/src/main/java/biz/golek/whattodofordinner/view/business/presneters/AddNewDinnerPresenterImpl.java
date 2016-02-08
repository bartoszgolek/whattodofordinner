package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;
import biz.golek.whattodofordinner.view.activities.AddNewDinnerActivity;
import biz.golek.whattodofordinner.view.helpers.ActivityStarter;

/**
 * Created by bgolek on 2016-02-05.
 */
public class AddNewDinnerPresenterImpl implements AddNewDinnerPresenter {
    private ActivityStarter starter;

    public AddNewDinnerPresenterImpl(ActivityStarter starter) {
        this.starter = starter;
    }

    @Override
    public void Run() {
        starter.startActivity(AddNewDinnerActivity.class);
    }
}
