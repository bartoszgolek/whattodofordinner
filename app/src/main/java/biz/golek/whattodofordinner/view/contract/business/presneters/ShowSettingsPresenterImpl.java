package biz.golek.whattodofordinner.view.contract.business.presneters;

import android.app.Activity;
import android.content.Intent;

import biz.golek.whattodofordinner.business.contract.controllers.presenters.ShowSettingsPresenter;
import biz.golek.whattodofordinner.view.activities.SettingsActivity;

/**
 * Created by bg on 02.02.16.
 */
public class ShowSettingsPresenterImpl implements ShowSettingsPresenter {
    @Override
    public void Show() {
        Intent intent = new Intent(, SettingsActivity.class);
    }
}
