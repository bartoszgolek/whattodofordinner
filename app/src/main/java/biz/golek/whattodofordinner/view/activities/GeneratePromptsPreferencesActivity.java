package biz.golek.whattodofordinner.view.activities;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.request_data.Duration;
import biz.golek.whattodofordinner.business.contract.request_data.GeneratePromptsRequestData;
import biz.golek.whattodofordinner.business.contract.request_data.Profile;
import biz.golek.whattodofordinner.databinding.ActivityGeneratePromptsPreferencesBinding;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;
import biz.golek.whattodofordinner.view.view_models.GeneratePreferencesViewModel;

public class GeneratePromptsPreferencesActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private ActivityDependencyProvider activityDependencyProvider;
    private GeneratePreferencesViewModel viewModel;
    private String GENERATE_PREFERENCES_VIEW_MODEL = "generatePreferencesViewModel";
    private Spinner maximumDurationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGeneratePromptsPreferencesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_generate_prompts_preferences);

        setupActionBar();

        if (savedInstanceState != null)
            viewModel = (GeneratePreferencesViewModel) savedInstanceState.getSerializable(GENERATE_PREFERENCES_VIEW_MODEL);
        else
            viewModel = new GeneratePreferencesViewModel();

        Resources r = getResources();
        viewModel.initVegetarianProfileLabels(new String[]{
                r.getString(R.string.only_not_vegetarian),
                r.getString(R.string.prefer_not_vegetarian),
                r.getString(R.string.doesnt_matter),
                r.getString(R.string.prefer_vegetarian),
                r.getString(R.string.only_vegetarian)
        });

        viewModel.initSoupProfileLabels(new String[]{
                r.getString(R.string.only_not_soups),
                r.getString(R.string.prefer_not_soups),
                r.getString(R.string.doesnt_matter),
                r.getString(R.string.prefer_soups),
                r.getString(R.string.only_soups)
        });

        binding.setViewModel(viewModel);

        maximumDurationSpinner = (Spinner) findViewById(R.id.maximum_duration);
        attachListeners();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, viewModel.getDurations(getResources()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maximumDurationSpinner.setAdapter(adapter);
        maximumDurationSpinner.setSelection(2, false);
    }



    private void attachListeners() {
        maximumDurationSpinner.setOnItemSelectedListener(viewModel.getDurationListener());
        ((SeekBar)findViewById(R.id.vegetarian_profile)).setOnSeekBarChangeListener(viewModel.getVegetarianProfileListener());
        ((SeekBar)findViewById(R.id.soup_profile)).setOnSeekBarChangeListener(viewModel.getSoupProfileListener());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(GENERATE_PREFERENCES_VIEW_MODEL, viewModel);
        super.onSaveInstanceState(outState);
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_generate_prompts_preferences, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        if (id == R.id.generate_prompts_preferences_ok) {
            GeneratePromptsRequestData requestData = new GeneratePromptsRequestData();
            requestData.maximum_duration = Duration.fromInt(viewModel.getDuration());
            requestData.vegetarian_profile = Profile.fromInt(viewModel.getVegetarian_profile() + 1);
            requestData.soup_profile = Profile.fromInt(viewModel.getSoup_profile() + 1);
            activityDependencyProvider.getGeneratePromptsController().Run(requestData);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Set(ActivityDependencyProvider item) {
        activityDependencyProvider = item;
    }
}
