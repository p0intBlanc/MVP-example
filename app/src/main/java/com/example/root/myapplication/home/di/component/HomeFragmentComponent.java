package com.example.root.myapplication.home.di.component;

import com.example.root.myapplication.NetComponent;
import com.example.root.myapplication.home.FoodApiInterface;
import com.example.root.myapplication.home.di.HomeScope;
import com.example.root.myapplication.home.di.modules.HomeModule;
import com.example.root.myapplication.home.ui.HomeFragment;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by root on 8/6/17.
 */

@HomeScope
@Component(dependencies = NetComponent.class, modules = {HomeModule.class})
public interface HomeFragmentComponent {

    void inject(HomeFragment fragment);

    FoodApiInterface getFoodApiInterface();

    Retrofit getRetrofit();
}
