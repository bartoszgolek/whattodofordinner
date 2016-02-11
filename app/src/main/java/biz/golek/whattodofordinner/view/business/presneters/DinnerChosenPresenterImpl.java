package biz.golek.whattodofordinner.view.business.presneters;

import biz.golek.whattodofordinner.business.contract.presenters.DinnerChosenPresenter;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerChosenResponseData;
import biz.golek.whattodofordinner.view.activities.DinnerChosenActivity;
import biz.golek.whattodofordinner.view.presneters.ActivityPresenter;
import biz.golek.whattodofordinner.view.view_models.DinnerChosenViewModel;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerChosenPresenterImpl implements DinnerChosenPresenter {
    private ActivityPresenter presenter;

    public DinnerChosenPresenterImpl(ActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Show(DinnerChosenResponseData responseData) {
        DinnerChosenViewModel data = new DinnerChosenViewModel();
        data.setDinner(responseData.getName());
        presenter.startActivity(DinnerChosenActivity.class, data);
    }
}
