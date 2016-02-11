package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;
import biz.golek.whattodofordinner.databinding.ActivityEditDinnerBinding;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;
import biz.golek.whattodofordinner.view.view_models.EditDinnerFormViewModel;

public class EditDinnerActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private ActivityDependencyProvider activityDependencyProvider;
    private EditDinnerFormViewModel viewModel;
    private String EDIT_DINNER_VIEW_MODEL = "editDinnerViewModel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEditDinnerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_dinner);

        setupActionBar();
        if (savedInstanceState != null)
            viewModel = (EditDinnerFormViewModel) savedInstanceState.getSerializable(EDIT_DINNER_VIEW_MODEL);
        else
            viewModel = (EditDinnerFormViewModel) getIntent().getExtras().getSerializable("VIEW_MODEL");

        binding.setViewModel(viewModel);

        attachListeners();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, viewModel.getDurations(getResources()));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.duration);
        sItems.setAdapter(adapter);
    }

    private void attachListeners() {
        ((EditText)findViewById(R.id.name)).addTextChangedListener(viewModel.getNameListener());
        ((CompoundButton)findViewById(R.id.vege)).setOnCheckedChangeListener(viewModel.getVegetarianListener());
        ((CompoundButton)findViewById(R.id.soup)).setOnCheckedChangeListener(viewModel.getSoupListener());
        ((AdapterView)findViewById(R.id.duration)).setOnItemSelectedListener(viewModel.getDurationListener());

        ((CompoundButton)findViewById(R.id.spring_season)).setOnCheckedChangeListener(viewModel.getSpringListener());
        ((CompoundButton)findViewById(R.id.summer_season)).setOnCheckedChangeListener(viewModel.getSummerListener());
        ((CompoundButton)findViewById(R.id.autumn_season)).setOnCheckedChangeListener(viewModel.getAutumnListener());
        ((CompoundButton)findViewById(R.id.winter_season)).setOnCheckedChangeListener(viewModel.getWinterListener());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(EDIT_DINNER_VIEW_MODEL, viewModel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit_dinner, menu);
        return true;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        if (id == R.id.save) {
            saveDinner();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveDinner() {
        UpdateDinnerRequestData requestData = new UpdateDinnerRequestData();

        requestData.id = viewModel.id;
        requestData.name = viewModel.getName();
        requestData.duration = viewModel.getDuration();
        requestData.soup = viewModel.getSoup();
        requestData.vegetarian = viewModel.getVegetarian();
        requestData.seasons = viewModel.getSeasons();

        activityDependencyProvider.getUpdateDinnerController().Run(requestData);
    }

    @Override
    public void Set(ActivityDependencyProvider item) {
        this.activityDependencyProvider = item;
    }
}
