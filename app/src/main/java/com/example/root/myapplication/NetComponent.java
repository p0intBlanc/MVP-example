package com.example.root.myapplication;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by root on 8/5/17.
 */

@Singleton
@Component(modules = {Appmodule.class, NetModule.class})
public interface NetComponent {

    //void inject(MainActivity activity);

    Retrofit getRetrofit();

    OkHttpClient gethttpClient();
}
