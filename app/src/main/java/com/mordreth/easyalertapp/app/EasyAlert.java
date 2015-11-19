package com.mordreth.easyalertapp.app;

import android.app.Application;
import rest.RequestCaller;

/**
 * Created by mordreth on 11/19/15.
 */
public class EasyAlert extends Application {
    private RequestCaller masterCaller;

    public EasyAlert() {
        this.masterCaller = new RequestCaller();
    }

    public RequestCaller getMasterCaller() {
        return masterCaller;
    }

    public void setMasterCaller(RequestCaller masterCaller) {
        this.masterCaller = masterCaller;
    }
}
