package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.ShowMarkDinnerUsed;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMarkDinnerUsedPresenter;

/**
 * Created by Bartosz Gołek on 23.02.16.
 */
public class ShowMarkDinnerUsedImpl implements ShowMarkDinnerUsed {
    private ShowMarkDinnerUsedPresenter presenter;

    public ShowMarkDinnerUsedImpl(ShowMarkDinnerUsedPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Run() {
        presenter.Show();
    }
}
