package com.example.root.myapplication.home;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 8/6/17.
 */

public class HomePresenterImpl implements HomePresenter {

    @Inject
    HomeInteractor interactor;

    HomeView mView;

    @Inject
    public HomePresenterImpl() {

    }


    @Override
    public void fetchFoodItems() {
        interactor.getFoodItemList(new Callback<ArrayList<Food>>() {
            @Override
            public void onResponse(Call<ArrayList<Food>> call, Response<ArrayList<Food>> response) {
                if (response.isSuccessful()) {
                    mView.showFoodList(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Food>> call, Throwable t) {
                mView.showEmptyView();
            }
        });
    }


    @Override
    public void attachView(HomeView view) {
        mView = view;
    }

    @Override
    public void detachView(HomeView view) {
        mView = null;
    }
}
