package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.databinding.ActivityDinnerListBinding;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.adapters.DinnerListItemArrayAdapter;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;
import biz.golek.whattodofordinner.view.messages.DinnerDeletedMessage;
import biz.golek.whattodofordinner.view.view_models.DinnerListViewModel;

public class DinnerListActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private String DINNER_LIST_VIEW_MODEL = "dinnerListViewModel";
    private DinnerListViewModel viewModel;
    private ActivityDependencyProvider activityDependencyProvider;
    private ArrayAdapter adapter;

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

        ListView listView =  (ListView) findViewById(R.id.dinner_list);
        adapter = new DinnerListItemArrayAdapter(this, viewModel.dinners);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onStart() {
        super.onStart();
        activityDependencyProvider.getEventBusProvider().get().register(this);
    }

    @Override
    public void onStop() {
        activityDependencyProvider.getEventBusProvider().get().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onEvent(DinnerDeletedMessage event) {
        DinnerListItem dinner = null;
        for (DinnerListItem d : viewModel.dinners)
            if (d.id == event.getId())
                dinner = d;

        if (dinner != null)
            viewModel.dinners.remove(dinner);
            adapter.notifyDataSetChanged();
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId()==R.id.dinner_list) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.dinner_list_item_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {
            case R.id.dinner_list_item_menu_edit:
                Toast.makeText(this, "Edit", Toast.LENGTH_LONG);
                return true;
            case R.id.dinner_list_item_menu_delete:
                ListView lv = (ListView)findViewById(R.id.dinner_list);
                DinnerListItem dinnerListItem = (DinnerListItem)lv.getItemAtPosition(info.position);
                activityDependencyProvider.getDeleteDinnerController().Run(dinnerListItem.id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
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

    @Override
    public void Set(ActivityDependencyProvider item) {
        activityDependencyProvider = item;
    }
}
