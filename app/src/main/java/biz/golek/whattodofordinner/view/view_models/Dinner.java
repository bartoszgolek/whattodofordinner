package biz.golek.whattodofordinner.view.view_models;

import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import biz.golek.whattodofordinner.BR;
import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.view.helpers.SimpleTextWatcher;

/**
 * Created by bgolek on 2016-02-05.
 */
public class Dinner extends BaseObservable {
    public Integer duration = 1;

    public List<String> getDurations(Resources resources) {
        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add(resources.getString(R.string.dinner_duration_short));
        spinnerArray.add(resources.getString(R.string.dinner_duration_medium));
        spinnerArray.add(resources.getString(R.string.dinner_duration_long));
        return spinnerArray;
    }

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

    public TextWatcher getNameListener() {
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

    public CompoundButton.OnCheckedChangeListener getVegetarianListener(){
        return new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                vegetarian = isChecked;
            }
        };
    }

    public CompoundButton.OnCheckedChangeListener getSoupListener() {
        return new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                soup = isChecked;
            }
        };
    }

    private String name = "Put Name";
    private boolean soup = true;
    private boolean vegetarian = true;

    public AdapterView.OnItemSelectedListener getDurationListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                duration = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                duration = -1;
            }
        };
    }
}
