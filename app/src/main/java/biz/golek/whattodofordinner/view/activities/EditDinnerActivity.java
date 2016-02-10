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
import biz.golek.whattodofordinner.business.contract.request_data.SaveNewDinnerRequestData;
import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;
import biz.golek.whattodofordinner.databinding.ActivityAddNewDinnerBinding;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;
import biz.golek.whattodofordinner.view.view_models.DinnerFormViewModel;

public class EditDinnerActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private ActivityDependencyProvider controllerProvider;
    private DinnerFormViewModel editDinner;
    private String EDIT_DINNER_VIEW_MODEL = "editDinnerViewModel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddNewDinnerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_dinner);

        setupActionBar();
        if (savedInstanceState != null)
            editDinner = (DinnerFormViewModel) savedInstanceState.getSerializable(EDIT_DINNER_VIEW_MODEL);
        else
            editDinner = (DinnerFormViewModel) getIntent().getExtras().getSerializable(EDIT_DINNER_VIEW_MODEL);

        binding.setViewModel(editDinner);

        attachListeners();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, editDinner.getDurations(getResources()));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.duration);
        sItems.setAdapter(adapter);
    }

    private void attachListeners() {
        ((EditText)findViewById(R.id.name)).addTextChangedListener(editDinner.getNameListener());
        ((CompoundButton)findViewById(R.id.vege)).setOnCheckedChangeListener(editDinner.getVegetarianListener());
        ((CompoundButton)findViewById(R.id.soup)).setOnCheckedChangeListener(editDinner.getSoupListener());
        ((AdapterView)findViewById(R.id.duration)).setOnItemSelectedListener(editDinner.getDurationListener());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(EDIT_DINNER_VIEW_MODEL, editDinner);
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

        requestData.name = editDinner.getName();
        requestData.duration = editDinner.getDuration();
        requestData.soup = editDinner.getSoup();
        requestData.vegetarian = editDinner.getVegetarian();
        requestData.seasons = editDinner.getSeasons();

        controllerProvider.getUpdateDinnerController().Run(requestData);
    }

    @Override
    public void Set(ActivityDependencyProvider item) {
        this.controllerProvider = item;
    }
}
