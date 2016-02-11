package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.About;
import biz.golek.whattodofordinner.business.contract.presenters.AboutPresenter;

/**
 * Created by bg on 12.02.16.
 */
public class AboutImpl implements About {
    private AboutPresenter presenter;

    public AboutImpl(AboutPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void Run() {
        presenter.Show();
    }
}
