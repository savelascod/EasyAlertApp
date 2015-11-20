package com.mordreth.easyalertapp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mordreth on 11/19/15.
 */
public class ServicesActivity extends Activity {
    ListView serviceList;
    private ArrayList<Service> services;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);
        setServices();
        setListAdapter();
        setListeners();
    }

    private void setListeners() {
        serviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ServiceDialogActivity.class);
                Service service = services.get(position);
                Bundle values = new Bundle();
                values.putString("serviceType", service.getTiposervicio());
                values.putLong("nit", service.getNit());
                values.putString("razonSocial", service.getRazonsocial());
                values.putString("address", service.getDireccion());
                values.putLong("phone", service.getTelefonofijovigilado());
                values.putString("email", service.getCorreoelectronicovigilado());
                values.putString("representative", service.getRepresentantelegal());
                intent.putExtras(values);
                startActivity(intent);
            }
        });
    }

    private void setListAdapter() {
        // instantiate our ItemAdapter class
        serviceList = (ListView) findViewById(R.id.service_list);
        MyServiceAdapter serviceAdapter = new MyServiceAdapter(this, R.layout.service_row, services);
        serviceList.setAdapter(serviceAdapter);
    }

    private void setServices() {
        services = new ArrayList<Service>();
        try {
            JSONArray jsonServices = new JSONArray(getIntent().getExtras().getString("services"));
            for (int i = 0; i < jsonServices.length(); i++) {
                JSONObject jsonService = (JSONObject) jsonServices.get(i);
                services.add(new Service(
                        jsonService.getLong("nit"),
                        jsonService.getString("tiposervicio"),
                        jsonService.getString("razonsocial"),
                        jsonService.getString("direccion"),
                        jsonService.getLong("telefonofijovigilado"),
                        jsonService.getString("correoelectronicovigilado"),
                        jsonService.getString("representantelegal")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("serviceList", String.valueOf(services.size()));

    }

}
