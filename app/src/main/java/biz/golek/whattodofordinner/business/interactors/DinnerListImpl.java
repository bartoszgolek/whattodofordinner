package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.DinnerList;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerListPresenter;

/**
 * Created by bgolek on 2016-02-08.
 */
public class DinnerListImpl implements DinnerList {
    private DinnerListPresenter presenter;

    public DinnerListImpl(DinnerListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Run() {
        presenter.Show(null);
    }
}
