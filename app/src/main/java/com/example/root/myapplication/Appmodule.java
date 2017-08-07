package com.example.root.myapplication;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 8/5/17.
 */

@Singleton
@Module
public class Appmodule {


    Application mApplication;


    public Appmodule(Application application) {
        mApplication = application;
    }


    @Provides
    public Application getApplication() {

        return mApplication;
    }
}
