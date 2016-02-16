package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.ShowMain;
import biz.golek.whattodofordinner.business.contract.presenters.ShowMainPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-11.
 */
public class ShowMainImpl implements ShowMain {
    private ShowMainPresenter presenter;

    public ShowMainImpl(ShowMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Run() {
        presenter.Run();
    }
}
