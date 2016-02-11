package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
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
import biz.golek.whattodofordinner.view.messages.DinnerAddedMessage;
import biz.golek.whattodofordinner.view.messages.DinnerDeletedMessage;
import biz.golek.whattodofordinner.view.messages.DinnerUpdatedMessage;
import biz.golek.whattodofordinner.view.view_models.DinnerListViewModel;

public class DinnerListActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private String DINNER_LIST_VIEW_MODEL = "dinnerListViewModel";
    private DinnerListViewModel viewModel;
    private ActivityDependencyProvider activityDependencyProvider;
    private ArrayAdapter adapter;
    private ListView listView;

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

        listView =  (ListView) findViewById(R.id.dinner_list);
        adapter = new DinnerListItemArrayAdapter(this, viewModel.dinners);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        activityDependencyProvider.getEventBusProvider().get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityDependencyProvider.getEventBusProvider().get().unregister(this);
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
    };

    @Subscribe
    public void onDinnerAddedMessage(DinnerAddedMessage event) {
        DinnerListItem dinner = new DinnerListItem();
        dinner.id = event.getId();
        dinner.name = event.getName();

        viewModel.dinners.add(dinner);
        adapter.notifyDataSetChanged();
    };

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
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dinner_list_menu, menu);
        return true;
    }

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
        DinnerListItem dinnerListItem = (DinnerListItem)listView.getItemAtPosition(info.position);
        switch(item.getItemId()) {
            case R.id.dinner_list_item_menu_edit:
                activityDependencyProvider.getEditDinnerController().Run(dinnerListItem.id);
                return true;
            case R.id.dinner_list_item_menu_delete:
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

        if (id == R.id.dinner_list_menu_add) {
            this.activityDependencyProvider.getAddNewDinnerController().Run();
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
