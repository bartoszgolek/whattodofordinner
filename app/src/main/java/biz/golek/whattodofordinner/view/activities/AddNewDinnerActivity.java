package biz.golek.whattodofordinner.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.databinding.ActivityAddNewDinnerBinding;
import biz.golek.whattodofordinner.view.ControllersProvider;
import biz.golek.whattodofordinner.view.awareness.IControllersProviderAware;
import biz.golek.whattodofordinner.view.view_models.Dinner;

public class AddNewDinnerActivity extends AppCompatActivity implements IControllersProviderAware {

    private ControllersProvider controllerProvider;
    private Dinner dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddNewDinnerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_dinner);

        setupActionBar();

        dinner = new Dinner();
        binding.setDinner(dinner);
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
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Set(ControllersProvider item) {
        this.controllerProvider = item;
    }
}
