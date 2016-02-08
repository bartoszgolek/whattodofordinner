package biz.golek.whattodofordinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import biz.golek.whattodofordinner.view.ControllersProvider;
import biz.golek.whattodofordinner.view.awareness.IControllersProviderAware;

public class MainActivity extends AppCompatActivity implements IControllersProviderAware {

    private ControllersProvider controllerProvider;
    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.add_new_dinner, Snackbar.LENGTH_LONG)
                        .setAction("Action", listener).show();
            }
        });

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controllerProvider.getAddNewDinnerController().Run();
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            this.controllerProvider.getShowSettingsController().Run();
            return true;
        }

        if (id == R.id.action_dinner_list) {
            this.controllerProvider.getShowDinnerListController().Run();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Set(ControllersProvider item) {
        this.controllerProvider = item;
    }
}
