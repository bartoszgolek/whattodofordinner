package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;
import biz.golek.whattodofordinner.view.activities.AddNewDinnerActivity;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-05.
 */
public class AddNewDinnerPresenterImpl implements AddNewDinnerPresenter {
    private ActivityPresenter starter;

    public AddNewDinnerPresenterImpl(ActivityPresenter starter) {
        this.starter = starter;
    }

    @Override
    public void Run() {
        starter.startActivity(AddNewDinnerActivity.class);
    }
}
