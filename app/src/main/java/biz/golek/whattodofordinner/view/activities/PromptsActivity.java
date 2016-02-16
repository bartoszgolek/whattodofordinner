package biz.golek.whattodofordinner.view.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.request_data.GeneratePromptsRequestData;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.adapters.DinnerListItemArrayAdapter;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;
import biz.golek.whattodofordinner.view.messages.DinnerDeletedMessage;
import biz.golek.whattodofordinner.view.messages.DinnerUpdatedMessage;
import biz.golek.whattodofordinner.view.view_models.PromptsActivityViewModel;

public class PromptsActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private String PROMPTS_LIST_VIEW_MODEL = "promptsListViewModel";
    private PromptsActivityViewModel viewModel;
    private ActivityDependencyProvider activityDependencyProvider;
    private ArrayAdapter adapter;
    private ListView listView;
    private DinnerListItem nonOfThisListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_prompts);

        setupActionBar();
        if (savedInstanceState != null)
            viewModel = (PromptsActivityViewModel) savedInstanceState.getSerializable(PROMPTS_LIST_VIEW_MODEL);
        else
            viewModel = (PromptsActivityViewModel)getIntent().getSerializableExtra("VIEW_MODEL");

        listView =  (ListView) findViewById(R.id.prompts_list);
        List<DinnerListItem> prompts = viewModel.prompts;
        nonOfThisListItem = new DinnerListItem();
        nonOfThisListItem.id = -1L;
        nonOfThisListItem.name = getResources().getString(R.string.non_of_this);
        prompts.add(nonOfThisListItem);

        adapter = new DinnerListItemArrayAdapter(this, prompts);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DinnerListItem item = (DinnerListItem)listView.getItemAtPosition(position);
                if (item == nonOfThisListItem)
                    activityDependencyProvider.getGeneratePromptsController().Run(getDenyRequestData());
                else
                    activityDependencyProvider.getDinnerChosenController().Run(item.id, item.name);
            }
        });

        registerForContextMenu(listView);

        activityDependencyProvider.getEventBusProvider().get().register(this);
    }

    @Subscribe
    public void onDinnerDeleteMessage(DinnerDeletedMessage event) {
        DinnerListItem dinner = null;
        for (DinnerListItem d : viewModel.prompts)
            if (d.id.equals(event.getId()))
                dinner = d;

        if (dinner != null)
            viewModel.prompts.remove(dinner);
        adapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onDinnerUpdatedMessage(DinnerUpdatedMessage event) {
        boolean updated = false;
        for (DinnerListItem dinner : viewModel.prompts) {
            if (dinner.id.equals(event.getId())) {
                dinner.id = event.getId();
                dinner.name = event.getName();
                updated = true;
            }
        }

        if (updated)
            adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityDependencyProvider.getEventBusProvider().get().unregister(this);
    }

    @NonNull
    private GeneratePromptsRequestData getDenyRequestData() {
        GeneratePromptsRequestData rd = new GeneratePromptsRequestData();
        rd.soup_profile = viewModel.getSoupProfile();
        rd.vegetarian_profile = viewModel.getVegetarianProfile();
        rd.maximum_duration = viewModel.getMaximumDuration();

        Long[] oldExcludes = viewModel.getExcludes();
        List<DinnerListItem> prompts = viewModel.prompts;
        int oldExcludesLength = oldExcludes!= null ? oldExcludes.length : 0;
        int promptsSize = prompts != null ? prompts.size() : 0;
        if (oldExcludesLength + promptsSize > 0)
        {
            Long[] excludes = new Long[oldExcludesLength + promptsSize];

            Integer index = 0;
            if (oldExcludes != null)
            {
                for (Long id: oldExcludes) {
                    excludes[index++] = id;
                }
            }

            if (prompts != null)
            {
                for (DinnerListItem dli: prompts) {
                    excludes[index++] = dli.id;
                }
            }

            rd.excludes = excludes;
        }
        return rd;
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId()==R.id.prompts_list) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            DinnerListItem dinnerListItem = (DinnerListItem)listView.getItemAtPosition(info.position);
            if (dinnerListItem != nonOfThisListItem)
            {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.dinner_list_item_menu, menu);
            }
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(PROMPTS_LIST_VIEW_MODEL, viewModel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void Set(ActivityDependencyProvider item) {
        activityDependencyProvider = item;
    }
}
