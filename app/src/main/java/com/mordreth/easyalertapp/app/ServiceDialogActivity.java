package com.mordreth.easyalertapp.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by mordreth on 11/19/15.
 */
public class ServiceDialogActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_service);
        setFields();
    }

    private void setFields() {
        TextView serviceTypeText = (TextView) findViewById(R.id.service_type_dg);
        TextView nitText = (TextView) findViewById(R.id.nit_dg);
        TextView razonSocialText = (TextView) findViewById(R.id.razon_social_dg);
        TextView addressText = (TextView) findViewById(R.id.direccion_dg);
        TextView phoneText = (TextView) findViewById(R.id.phone_dg);
        TextView emailText = (TextView) findViewById(R.id.email_dg);
        TextView representanteText = (TextView) findViewById(R.id.representante_dg);

        serviceTypeText.setText(getIntent().getExtras().getString("serviceType"));
        nitText.setText(String.valueOf(getIntent().getExtras().getLong("nit")));
        razonSocialText.setText(getIntent().getExtras().getString("razonSocial"));
        addressText.setText(getIntent().getExtras().getString("address"));
        phoneText.setText(String.valueOf(getIntent().getExtras().getLong("phone")));
        emailText.setText(getIntent().getExtras().getString("email"));
        representanteText.setText(getIntent().getExtras().getString("representative"));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
