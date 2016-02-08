package biz.golek.whattodofordinner.view.business.presneters;

import java.util.List;

import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.view.activities.DinnerListActivity;
import biz.golek.whattodofordinner.view.helpers.ActivityStarter;
import biz.golek.whattodofordinner.view.view_models.DinnerListViewModel;

/**
 * Created by bgolek on 2016-02-08.
 */
public class DinnerListPresenterImpl implements DinnerListPresenter {
    private ActivityStarter starter;

    public DinnerListPresenterImpl(ActivityStarter starter) {

        this.starter = starter;
    }

    @Override
    public void Show(List<DinnerListItem> dinners) {
        DinnerListViewModel data = new DinnerListViewModel();
        data.dinners = dinners;
        starter.startActivity(DinnerListActivity.class, data);
    }
}
