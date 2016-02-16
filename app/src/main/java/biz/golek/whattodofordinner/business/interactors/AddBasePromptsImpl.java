package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.dao.AddBasePromptsDao;
import biz.golek.whattodofordinner.business.contract.interactors.AddBasePrompts;
import biz.golek.whattodofordinner.business.contract.presenters.AddBasePromptsPresenter;
import biz.golek.whattodofordinner.models.Dinner;

/**
 * Created by bgolek on 2016-02-16.
 */
public class AddBasePromptsImpl implements AddBasePrompts {
    private AddBasePromptsPresenter presenter;
    private AddBasePromptsDao dao;

    public AddBasePromptsImpl(AddBasePromptsPresenter presenter, AddBasePromptsDao dao) {
        this.presenter = presenter;
        this.dao = dao;
    }

    @Override
    public void Run() {
        Dinner[] dinners = dao.Generate();
        presenter.Show(dinners);
    }
}