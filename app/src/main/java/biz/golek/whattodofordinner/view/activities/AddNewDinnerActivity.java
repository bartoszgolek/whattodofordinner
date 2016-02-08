package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import biz.golek.whattodofordinner.databinding.ActivityAddNewDinnerBinding;
import biz.golek.whattodofordinner.view.ControllersProvider;
import biz.golek.whattodofordinner.view.awareness.IControllersProviderAware;
import biz.golek.whattodofordinner.view.view_models.AddNewDinnerViewModel;

public class AddNewDinnerActivity extends AppCompatActivity implements IControllersProviderAware {

    private ControllersProvider controllerProvider;
    private AddNewDinnerViewModel addNewDinner;
    private String ADD_NEW_DINNER_VIEW_MODEL = "addNewDinnerViewModel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddNewDinnerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_dinner);

        setupActionBar();
        if (savedInstanceState != null)
            addNewDinner = (AddNewDinnerViewModel) savedInstanceState.getSerializable(ADD_NEW_DINNER_VIEW_MODEL);
        else
            addNewDinner = new AddNewDinnerViewModel();

        binding.setViewModel(addNewDinner);

        attachListeners();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, addNewDinner.getDurations(getResources()));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.duration);
        sItems.setAdapter(adapter);
    }

    private void attachListeners() {
        ((EditText)findViewById(R.id.name)).addTextChangedListener(addNewDinner.getNameListener());
        ((CompoundButton)findViewById(R.id.vege)).setOnCheckedChangeListener(addNewDinner.getVegetarianListener());
        ((CompoundButton)findViewById(R.id.soup)).setOnCheckedChangeListener(addNewDinner.getSoupListener());
        ((AdapterView)findViewById(R.id.duration)).setOnItemSelectedListener(addNewDinner.getDurationListener());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(ADD_NEW_DINNER_VIEW_MODEL, addNewDinner);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_new_dinner, menu);
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
        SaveNewDinnerRequestData requestData = new SaveNewDinnerRequestData();

        requestData.name = addNewDinner.getName();
        requestData.duration = addNewDinner.getDuration();
        requestData.soup = addNewDinner.getSoup();
        requestData.vegetarian = addNewDinner.getVegetarian();

        controllerProvider.getSaveNewDinnerController().Run(requestData);
    }

    @Override
    public void Set(ControllersProvider item) {
        this.controllerProvider = item;
    }
}
