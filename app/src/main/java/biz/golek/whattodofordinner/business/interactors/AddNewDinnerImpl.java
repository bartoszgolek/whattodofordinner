package biz.golek.whattodofordinner.business.interactors;

import biz.golek.whattodofordinner.business.contract.interactors.AddNewDinner;
import biz.golek.whattodofordinner.business.contract.presenters.AddNewDinnerPresenter;

/**
 * Created by Bartosz Gołek on 2016-02-05.
 */
public class AddNewDinnerImpl implements AddNewDinner {

    private AddNewDinnerPresenter presenter;

    public AddNewDinnerImpl(AddNewDinnerPresenter presenter){

        this.presenter = presenter;
    }

    @Override
    public void Run() {
        presenter.Run();
    }
}
