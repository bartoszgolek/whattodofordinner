package biz.golek.whattodofordinner.view.view_models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.AdapterView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import biz.golek.whattodofordinner.BR;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;

/**
 * Created by bgolek on 2016-02-24.
 */
public class MarkDinnerUsedViewModel extends BaseObservable implements Serializable {
    public List<DinnerListItem> dinners = new ArrayList<>();
    private Date dinnerDate = new Date();
    private DinnerListItem dinner;

    @Bindable
    public String getDinnerDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return sdf.format(dinnerDate);
    }

    public Date getDinnerDate(){
        return dinnerDate;
    }

    public void setDinnerDate(Date dinnerDate) {
        this.dinnerDate = dinnerDate;
        notifyPropertyChanged(BR.dinnerDateString);
    }

    public AdapterView.OnItemSelectedListener getDinnerListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dinner = dinners.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }

    public DinnerListItem getDinner() {
        return dinner;
    }

    public void setDinner(DinnerListItem dinner) {
        this.dinner = dinner;
        notifyPropertyChanged(BR.dinner);
    }
}
