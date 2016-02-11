package biz.golek.whattodofordinner.view.view_models;

import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import biz.golek.whattodofordinner.BR;
import biz.golek.whattodofordinner.R;

/**
 * Created by bg on 10.02.16.
 */
public class GeneratePreferencesViewModel extends BaseObservable implements Serializable {
    private Integer vegetarian_profile = 2;
    private String[] vegetarian_profile_labels;
    private Integer soup_profile = 2;
    private String[] soup_profile_labels;
    private Integer duration = 1;

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
    public Integer getVegetarian_profile() {
        return vegetarian_profile;
    }

    public void setVegetarian_profile(Integer vegetarian_profile) {
        this.vegetarian_profile = vegetarian_profile;
        notifyPropertyChanged(BR.vegetarian_profile);
        notifyPropertyChanged(BR.vegetarian_profile_label);
    }

    @Bindable
    public String getVegetarian_profile_label() {
        return vegetarian_profile_labels[vegetarian_profile];
    }

    @Bindable
    public Integer getSoup_profile() {
        return soup_profile;
    }

    public void setSoup_profile(Integer soup_profile) {
        this.soup_profile = soup_profile;
        notifyPropertyChanged(BR.soup_profile);
        notifyPropertyChanged(BR.soup_profile_label);
    }

    @Bindable
    public String getSoup_profile_label() {
        return soup_profile_labels[soup_profile];
    }

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

    public SeekBar.OnSeekBarChangeListener getVegetarianProfileListener() {
        return new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vegetarian_profile = progress;
                notifyPropertyChanged(BR.vegetarian_profile_label);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
    }

    public void initVegetarianProfileLabels(String[] labels) {
        this.vegetarian_profile_labels = labels;
    }

    public void initSoupProfileLabels(String[] labels) {
        this.soup_profile_labels = labels;
    }

    public SeekBar.OnSeekBarChangeListener getSoupProfileListener() {
        return new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                soup_profile = progress;
                notifyPropertyChanged(BR.soup_profile_label);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
    }
}
