package biz.golek.whattodofordinner.view.business.presneters;

import javax.inject.Inject;

import biz.golek.whattodofordinner.business.contract.presenters.ShowSettingsPresenter;
import biz.golek.whattodofordinner.view.activities.SettingsActivity;
import biz.golek.whattodofordinner.view.helpers.ActivityStarter;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsPresenterImpl implements ShowSettingsPresenter {
    @Inject
    public ShowSettingsPresenterImpl(ActivityStarter starter){
        this.starter = starter;
    }

    ActivityStarter starter;

    @Override
    public void Show() {
        starter.startActivity(SettingsActivity.class);
    }
}
