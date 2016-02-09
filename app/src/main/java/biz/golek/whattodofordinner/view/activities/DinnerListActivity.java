package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.databinding.ActivityDinnerListBinding;
import biz.golek.whattodofordinner.view.adapters.DinnerListItemArrayAdapter;
import biz.golek.whattodofordinner.view.view_models.DinnerListViewModel;

public class DinnerListActivity extends AppCompatActivity {

    private String DINNER_LIST_VIEW_MODEL = "dinnerListViewModel";
    private DinnerListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDinnerListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dinner_list);

        setupActionBar();
        if (savedInstanceState != null)
            viewModel = (DinnerListViewModel) savedInstanceState.getSerializable(DINNER_LIST_VIEW_MODEL);
        else
            viewModel = (DinnerListViewModel)getIntent().getSerializableExtra("VIEW_MODEL");

        binding.setViewModel(viewModel);

        ListView listView = (ListView) findViewById(R.id.dinner_list);
        ArrayAdapter adapter = new DinnerListItemArrayAdapter(this, viewModel.dinners);
        listView.setAdapter(adapter);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(DINNER_LIST_VIEW_MODEL, viewModel);
        super.onSaveInstanceState(outState);
    }
}
