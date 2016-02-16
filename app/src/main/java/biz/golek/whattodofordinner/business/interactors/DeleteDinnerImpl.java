package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.DeleteDinner;
import biz.golek.whattodofordinner.business.contract.presenters.DeleteDinnerPresenter;
import biz.golek.whattodofordinner.business.contract.dao.DeleteDinnerDao;

/**
 * Created by Bartosz Gołek on 2016-02-10.
 */
public class DeleteDinnerImpl implements DeleteDinner {
    private DeleteDinnerDao dao;
    private DeleteDinnerPresenter presenter;

    public DeleteDinnerImpl(DeleteDinnerDao dao, DeleteDinnerPresenter presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void Run(Long id) {
        dao.Delete(id);
        presenter.ShowDeleted(id);
    }
}
