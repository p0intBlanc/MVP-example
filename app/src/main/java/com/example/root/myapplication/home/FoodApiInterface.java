package com.example.root.myapplication.home;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by root on 8/6/17.
 */

public interface FoodApiInterface {

    @GET("http://beta.json-generator.com/api/json/get/N1e2GoTsM")
    Call<ArrayList<Food>> getFoodList();
}
