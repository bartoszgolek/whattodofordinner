package biz.golek.whattodofordinner.view.view_models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

import biz.golek.whattodofordinner.BR;

/**
 * Created by Bartosz Gołek on 2016-02-11.
 */
public class DinnerChosenViewModel extends BaseObservable implements Serializable {
    private String dinner;

    @Bindable
    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
        notifyPropertyChanged(BR.dinner);
    }
}
