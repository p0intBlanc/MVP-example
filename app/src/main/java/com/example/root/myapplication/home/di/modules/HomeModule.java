package com.example.root.myapplication.home.di.modules;

import com.example.root.myapplication.home.FoodApiInterface;
import com.example.root.myapplication.home.HomeInteractor;
import com.example.root.myapplication.home.HomePresenter;
import com.example.root.myapplication.home.HomePresenterImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by root on 8/6/17.
 */

@Module
public class HomeModule {

    @Provides
    FoodApiInterface getFoodApi(Retrofit retrofit) {
        return retrofit.create(FoodApiInterface.class);
    }

    @Provides
    HomeInteractor getHomeIteractor(FoodApiInterface foodApiInterface) {
        return new HomeInteractor(foodApiInterface);
    }

    @Provides
    HomePresenter getHomePresenter(HomePresenterImpl homePresenter) {
        return homePresenter;
    }
}
