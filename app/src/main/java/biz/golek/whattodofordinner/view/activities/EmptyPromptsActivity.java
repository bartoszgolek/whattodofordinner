package biz.golek.whattodofordinner.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.view.ActivityDependencyProvider;
import biz.golek.whattodofordinner.view.awareness.IActivityDependencyProviderAware;

public class EmptyPromptsActivity extends AppCompatActivity implements IActivityDependencyProviderAware {

    private Button closeButton;
    private Button addNewDinnerButton;
    private ActivityDependencyProvider activityDependencyProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_prompts);

        closeButton = (Button) findViewById(R.id.button_close);
        addNewDinnerButton = (Button) findViewById(R.id.button_add_new_dinner);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityDependencyProvider.getShowMainController().Run();
            }
        });

        addNewDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityDependencyProvider.getAddNewDinnerController().Run();
            }
        });
    }

    @Override
    public void Set(ActivityDependencyProvider item) {
        activityDependencyProvider = item;
    }
}
