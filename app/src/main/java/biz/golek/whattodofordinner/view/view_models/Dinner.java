package biz.golek.whattodofordinner.view.view_models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import biz.golek.whattodofordinner.BR;
import biz.golek.whattodofordinner.view.helpers.SimpleTextWatcher;

/**
 * Created by bgolek on 2016-02-05.
 */
public class Dinner extends BaseObservable {
    public List<Map.Entry<Integer, String>> durations = new ArrayList<>();
    public Integer duration = 1;

    @Bindable
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
        notifyPropertyChanged(BR.duration);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public TextWatcher getNameWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString();
            }
        };
    }

    @Bindable
    public boolean getSoup() {
        return soup;
    }

    public void setSoup(boolean soup) {
        this.soup = soup;
        notifyPropertyChanged(BR.soup);
    }

    @Bindable
    public boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
        notifyPropertyChanged(BR.vegetarian);
    }

    private String name = "Put Name";
    private boolean soup = true;
    private boolean vegetarian = true;
}
