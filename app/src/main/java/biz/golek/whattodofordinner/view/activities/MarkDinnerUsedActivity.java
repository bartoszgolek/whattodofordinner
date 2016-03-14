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

import org.greenrobot.eventbus.Subscribe;

import java.util.Calendar;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.request_data.MarkDinnerUsedRequestData;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.databinding.ActivityMarkDinnerUsedBinding;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.adapters.DinnerListItemArrayAdapter;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;
import biz.golek.whattodofordinner.view.messages.Dinner;
import biz.golek.whattodofordinner.view.messages.DinnerAddedMessage;
import biz.golek.whattodofordinner.view.messages.DinnerDeletedMessage;
import biz.golek.whattodofordinner.view.messages.DinnerUpdatedMessage;
import biz.golek.whattodofordinner.view.view_models.MarkDinnerUsedViewModel;

public class MarkDinnerUsedActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private ActivityDependencyProvider activityDependencyProvider;
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
    private ArrayAdapter<DinnerListItem> adapter;
    private Spinner spinner;

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

        adapter = new DinnerListItemArrayAdapter(this, viewModel.dinners);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (Spinner) findViewById(R.id.mark_dish_used_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(viewModel.getDinnerListener());

        ImageButton button = (ImageButton)findViewById(R.id.mark_dish_used_add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityDependencyProvider.getAddNewDinnerController().Run();
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

        activityDependencyProvider.getEventBusProvider().get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityDependencyProvider.getEventBusProvider().get().unregister(this);
    }

    @Subscribe
    public void onDinnerAddedMessage(DinnerAddedMessage event) {
        DinnerListItem firstItem = null;
        for (Dinner addedDinner : event.getAddedDinners()) {
            DinnerListItem dinner = new DinnerListItem();
            dinner.id = addedDinner.getId();
            dinner.name = addedDinner.getName();

            viewModel.dinners.add(dinner);
            if (firstItem == null)
                firstItem = dinner;
        }

        if (event.getAddedDinners().length > 0) {
            adapter.notifyDataSetChanged();
            int position = viewModel.dinners.indexOf(firstItem);
            spinner.setSelection(position);
        }
    }

    @Subscribe
    public void onDinnerUpdatedMessage(DinnerUpdatedMessage event) {
        boolean updated = false;
        for (DinnerListItem dinner : viewModel.dinners) {
            if (dinner.id.equals(event.getId())) {
                dinner.id = event.getId();
                dinner.name = event.getName();
                updated = true;
            }
        }

        if (updated)
            adapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onDinnerDeleteMessage(DinnerDeletedMessage event) {
        DinnerListItem dinner = null;
        for (DinnerListItem d : viewModel.dinners)
            if (d.id.equals(event.getId()))
                dinner = d;

        if (dinner != null)
            viewModel.dinners.remove(dinner);
        adapter.notifyDataSetChanged();
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
        MarkDinnerUsedRequestData requestData = new MarkDinnerUsedRequestData();
        requestData.dinnerId = viewModel.getDinner().id;
        requestData.dinnerDate = viewModel.getDinnerDate();
        activityDependencyProvider.getMarkDinnerUsedController().Run(requestData);
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
    public void Set(ActivityDependencyProvider item) {
        activityDependencyProvider = item;
    }
}
