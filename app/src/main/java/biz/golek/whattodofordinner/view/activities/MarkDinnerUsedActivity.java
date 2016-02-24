package biz.golek.whattodofordinner.view.activities;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.request_data.UpdateDinnerRequestData;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.databinding.ActivityMarkDinnerUsedBinding;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.adapters.DinnerListItemArrayAdapter;
import biz.golek.whattodofordinner.view.view_models.MarkDinnerUsedViewModel;

public class MarkDinnerUsedActivity extends AppCompatActivity {

    private ActivityDependencyProvider controllerProvider;
    private MarkDinnerUsedViewModel viewModel;
    private String VIEW_MODEL = "markDinnerUsedViewModel";

    private Calendar dinnerDateCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dinnerDateCalendar.set(Calendar.YEAR, year);
            dinnerDateCalendar.set(Calendar.MONTH, monthOfYear);
            dinnerDateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            viewModel.setDinnerDate(dinnerDateCalendar.getTime());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMarkDinnerUsedBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mark_dinner_used);

        setupActionBar();

        if (savedInstanceState != null)
            viewModel = (MarkDinnerUsedViewModel) savedInstanceState.getSerializable(VIEW_MODEL);
        else
            viewModel = (MarkDinnerUsedViewModel)getIntent().getSerializableExtra("VIEW_MODEL");

        binding.setViewModel(viewModel);

        ArrayAdapter<DinnerListItem> adapter = new DinnerListItemArrayAdapter(this, viewModel.dinners);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.mark_dish_used_spinner);
        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(viewModel.getDinnerListener());

        ImageButton button = (ImageButton)findViewById(R.id.mark_dish_used_add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controllerProvider.getShowMarkDinnerUsedController();
            }
        });

        TextView tv = (TextView)findViewById(R.id.mark_dish_used_dinner_date);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MarkDinnerUsedActivity.this, date, dinnerDateCalendar
                        .get(Calendar.YEAR), dinnerDateCalendar.get(Calendar.MONTH),
                        dinnerDateCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mark_dinner_used, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(VIEW_MODEL, viewModel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        if (id == R.id.save) {
            markDinnerUsed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void markDinnerUsed() {
        //activityDependencyProvider.getUpdateDinnerController().Run(requestData);
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
}
