package com.mordreth.easyalertapp.app;

import android.app.Activity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by mordreth on 11/19/15.
 */
public class ServicesActivity extends Activity {
    private JSONArray services;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            services = new JSONArray(getIntent().getExtras().getString("locations"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
