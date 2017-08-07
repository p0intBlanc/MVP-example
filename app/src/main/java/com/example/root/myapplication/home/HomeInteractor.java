package com.example.root.myapplication.home;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 8/6/17.
 */

public class HomeInteractor {


    FoodApiInterface api;

    @Inject
    public HomeInteractor(FoodApiInterface api) {
        this.api = api;
    }

    public void getFoodItemList(Callback<ArrayList<Food>> callback) {
        Call<ArrayList<Food>> call = api.getFoodList();
        call.enqueue(callback);
    }

    public void setFoodApi(FoodApiInterface foodApiInterface) {
        api = foodApiInterface;
    }
}
