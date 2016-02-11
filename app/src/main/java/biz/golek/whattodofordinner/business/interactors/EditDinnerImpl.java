package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.EditDinnerDao;
import biz.golek.whattodofordinner.business.contract.interactors.EditDinner;
import biz.golek.whattodofordinner.business.contract.presenters.EditDinnerPresenter;

/**
 * Created by bgolek on 2016-02-10.
 */
public class EditDinnerImpl implements EditDinner {
    private EditDinnerPresenter editDinnerPresenter;
    private EditDinnerDao dao;

    public EditDinnerImpl(
            EditDinnerPresenter editDinnerPresenter,
            EditDinnerDao dao) {
        this.editDinnerPresenter = editDinnerPresenter;
        this.dao = dao;
    }

    @Override
    public void Run(Long id) {
        editDinnerPresenter.Show(dao.GetDinner(id));
    }
}
