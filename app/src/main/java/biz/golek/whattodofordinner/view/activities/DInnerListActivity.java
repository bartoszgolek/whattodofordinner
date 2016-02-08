package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.databinding.ActivityDinnerListBinding;
import biz.golek.whattodofordinner.view.view_models.DinnerListViewModel;

public class DinnerListActivity extends AppCompatActivity {

    private String DINNER_LIST_VIEW_MODEL = "dinnerListViewModel";
    private DinnerListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDinnerListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dinner_list);

        //setupActionBar();
        if (savedInstanceState != null)
            viewModel = (DinnerListViewModel) savedInstanceState.getSerializable(DINNER_LIST_VIEW_MODEL);
        else
            viewModel = new DinnerListViewModel();

        binding.setViewModel(viewModel);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(DINNER_LIST_VIEW_MODEL, viewModel);
        super.onSaveInstanceState(outState);
    }
}
