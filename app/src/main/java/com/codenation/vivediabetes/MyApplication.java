package com.codenation.vivediabetes;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by oscarvargas on 18/06/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
