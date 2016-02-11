package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.DinnerAcceptedDao;
import biz.golek.whattodofordinner.business.contract.interactors.DinnerAccepted;
import biz.golek.whattodofordinner.business.contract.presenters.DinnerAcceptedPresenter;

/**
 * Created by bg on 11.02.16.
 */
public class DinnerAcceptedImpl implements DinnerAccepted {
    private DinnerAcceptedDao dao;
    private DinnerAcceptedPresenter presenter;

    public DinnerAcceptedImpl(DinnerAcceptedDao dao, DinnerAcceptedPresenter presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void Run(Long id) {
        dao.SetDinnerAccepted(id);
        presenter.ShowAccepted();
    }
}
