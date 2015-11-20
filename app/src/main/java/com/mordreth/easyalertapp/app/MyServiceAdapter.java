package com.mordreth.easyalertapp.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mordreth on 11/19/15.
 */
public class MyServiceAdapter extends ArrayAdapter<Service> {
    // declaring our ArrayList of items
    private ArrayList<Service> services;

    public MyServiceAdapter(Context context, int textViewResourceId, ArrayList<Service> services) {
        super(context, textViewResourceId, services);
        this.services = services;
    }

    /*
     * we are overriding the getView method here - this is what defines how each
	 * list item will look.
	 */

    public View getView(int position, View convertView, ViewGroup parent) {

        // assign the view we are converting to a local variable
        View view = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.service_row, null);
        }

		/*
         * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        Service service = services.get(position);

        if (service != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView typeText = (TextView) view.findViewById(R.id.service_type);
            TextView nitText = (TextView) view.findViewById(R.id.service_nit);
            TextView emailText = (TextView) view.findViewById(R.id.service_email);
            TextView phoneText = (TextView) view.findViewById(R.id.service_phone);

            // check to see if each individual textview is null.
            // if not, assign some text!
            if (typeText != null) {
                typeText.setText(service.getTiposervicio());
            }
            if (nitText != null) {
                nitText.setText(String.valueOf(service.getNit()));
            }
            if (emailText != null) {
                emailText.setText(service.getCorreoelectronicovigilado());
            }
            if (phoneText != null) {
                phoneText.setText(String.valueOf(service.getTelefonofijovigilado()));
            }
        }

        // the view must be returned to our activity
        return view;

    }

}
