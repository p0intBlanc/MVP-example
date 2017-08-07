package com.example.root.myapplication;

import android.app.Application;

/**
 * Created by root on 8/5/17.
 */

public class MyApplication extends Application {

    NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appmodule(new Appmodule(this))
                .netModule(new NetModule("https://shetty.com"))
                .build();
    }


    public NetComponent getnetComponent() {
        return mNetComponent;
    }
}
