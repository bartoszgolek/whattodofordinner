package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.databinding.ActivityDinnerChosenBinding;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;
import biz.golek.whattodofordinner.view.view_models.DinnerChosenViewModel;

public class DinnerChosenActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private String DINNER_CHOSEN_VIEW_MODEL = "dinnerChosenViewModel";

    private DinnerChosenViewModel viewModel;
    private Button closeButton;
    private ActivityDependencyProvider activityDependencyProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDinnerChosenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dinner_chosen);

        if (savedInstanceState != null)
            viewModel = (DinnerChosenViewModel) savedInstanceState.getSerializable(DINNER_CHOSEN_VIEW_MODEL);
        else
            viewModel = (DinnerChosenViewModel) getIntent().getExtras().getSerializable("VIEW_MODEL");

        binding.setViewModel(viewModel);

        closeButton = (Button)findViewById(R.id.button_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityDependencyProvider.getShowMainController().Run();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(DINNER_CHOSEN_VIEW_MODEL, viewModel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void Set(ActivityDependencyProvider item) {
        activityDependencyProvider = item;
    }
}
