package com.mordreth.easyalertapp.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import rest.AsyncResponse;

import java.util.ArrayList;

public class MainActivity extends Activity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendData(View view) {

        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("$format", "json"));
        params.add(new BasicNameValuePair("$top", "30"));
        String filters = setFilters();
        if (!filters.equals("")) {
            params.add(new BasicNameValuePair("$filter", filters));
        }
        Log.v("params", params.toString());

        ((EasyAlert) getApplication()).getMasterCaller().getData(
                "v1/superintendencia_de_vigilancia_y_seguridad_privada/directoriodeservicios",
                this, params);
    }

    public String setFilters() {
        String streamFilters = "";
        ArrayList<String> filters = new ArrayList<String>();
        EditText nitText = (EditText) findViewById(R.id.nit);
        EditText serviceTypeText = (EditText) findViewById(R.id.service_type);
        EditText razonSocialText = (EditText) findViewById(R.id.razon_social);
        EditText addressText = (EditText) findViewById(R.id.address);
        EditText phoneText = (EditText) findViewById(R.id.phone);
        EditText emailText = (EditText) findViewById(R.id.email);
        EditText representativeText = (EditText) findViewById(R.id.representative);

        if (nitText.getText().toString() != null && !nitText.getText().equals("") && nitText.getText().length() != 0) {
            filters.add("\"nit\"" + "=" + "\'" + nitText.getText().toString() + "\'");
        }
        if (serviceTypeText.getText() != null && !serviceTypeText.getText().equals("") && serviceTypeText.getText().length() != 0) {
            filters.add("\"tiposervicio\"" + "=" + "\'" + serviceTypeText.getText().toString() + "\'");
        }
        if (razonSocialText.getText() != null && !razonSocialText.getText().equals("") && razonSocialText.getText().length() != 0) {
            filters.add("\"razonsocial\"" + "=" + "\'" + razonSocialText.getText().toString() + "\'");
        }
        if (addressText.getText() != null && !addressText.getText().equals("") && addressText.getText().length() != 0) {
            filters.add("\"direccion\"" + "=" + "\'" + addressText.getText().toString() + "\'");
        }
        if (phoneText.getText() != null && !phoneText.getText().equals("") && phoneText.getText().length() != 0) {
            filters.add("\"telefonofijovigilado\"" + "=" + "\'" + phoneText.getText().toString() + "\'");
        }
        if (emailText.getText() != null && !emailText.getText().equals("") && emailText.getText().length() != 0) {
            filters.add("\"correoelectronicovigilado\"" + "=" + "\'" + emailText.getText().toString() + "\'");
        }

        for (int i = 0; i < filters.size() - 1; i++) {
            streamFilters += filters.get(i) + "and";
        }
        if (!filters.isEmpty()) {
            streamFilters += filters.get(filters.size() - 1);
        }
        Log.v("filters", streamFilters);
        return streamFilters;
    }

    @Override
    public void processFinish(String result) {
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
    }
}
