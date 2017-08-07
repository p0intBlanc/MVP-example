package com.example.root.myapplication.home.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.myapplication.BaseFragment;
import com.example.root.myapplication.MyApplication;
import com.example.root.myapplication.NetComponent;
import com.example.root.myapplication.R;
import com.example.root.myapplication.databinding.HomeFragmentBinding;
import com.example.root.myapplication.home.Food;
import com.example.root.myapplication.home.FoodAdapter;
import com.example.root.myapplication.home.HomePresenter;
import com.example.root.myapplication.home.HomeView;
import com.example.root.myapplication.home.di.component.DaggerHomeFragmentComponent;
import com.example.root.myapplication.home.di.component.HomeFragmentComponent;
import com.example.root.myapplication.home.di.modules.HomeModule;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by root on 8/6/17.
 */

public class HomeFragment extends BaseFragment implements HomeView {


    private HomeFragmentBinding mBinding;
    private NetComponent netComponent;

    private HomeFragmentComponent homeComponent;
    FoodAdapter mAdapter;
    ArrayList<Food> mFoodItems = new ArrayList<>();

    @Inject
    HomePresenter mPresenter;

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);


        mAdapter = new FoodAdapter(mFoodItems, getContext());
        mBinding.homeList.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.homeList.setAdapter(mAdapter);
        mPresenter.fetchFoodItems();

        return mBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter.attachView(this);
    }

    @Override
    public void injectDependencies() {
        netComponent = ((MyApplication) getActivity().getApplication()).getnetComponent();
        homeComponent = DaggerHomeFragmentComponent.builder().netComponent(netComponent).homeModule(new HomeModule()).build();
        homeComponent.inject(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detachView(this);
    }

    @Override
    public void showFoodList(ArrayList<Food> foods) {
        mFoodItems.addAll(foods);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyView() {

    }
}
