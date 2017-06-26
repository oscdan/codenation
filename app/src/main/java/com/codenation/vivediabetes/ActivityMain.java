package com.codenation.vivediabetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.codenation.vivediabetes.beans.Catalog;
import com.codenation.vivediabetes.control.ControlCatalog;
import com.codenation.vivediabetes.database.DataBaseHandler;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {

    protected Spinner physicalActivity;
    protected Spinner lifecycle;
    private static final int PHYSICAL_TYPE = 2;
    private static final int LIFECYCLE_TYPE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        physicalActivity = (Spinner) findViewById(R.id.activity_main_physic);
        lifecycle = (Spinner) findViewById(R.id.activity_main_lifecycle);

        DataBaseHandler dh = DataBaseHandler.getInstance(this);
        ControlCatalog controlCatalog = new ControlCatalog();

        ArrayList<Catalog> activitiesArray = controlCatalog.getCatalogByType(PHYSICAL_TYPE, dh);
        ArrayList<Catalog> lifecycleArray = controlCatalog.getCatalogByType(LIFECYCLE_TYPE, dh);

        ArrayAdapter<Catalog> adapterActivities = new ArrayAdapter<Catalog>(this,
                android.R.layout.simple_spinner_item, activitiesArray);
        ArrayAdapter<Catalog> adapterLifecycle = new ArrayAdapter<Catalog>(this,
                android.R.layout.simple_spinner_item, lifecycleArray);

        physicalActivity.setAdapter(adapterActivities);
        lifecycle.setAdapter(adapterLifecycle);

    }
}
