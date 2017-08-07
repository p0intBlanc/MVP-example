package com.example.root.myapplication.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.myapplication.R;
import com.example.root.myapplication.databinding.FoodListItemLayoutBinding;

import java.util.ArrayList;

/**
 * Created by root on 8/6/17.
 */

public class FoodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<Food> mSource;


    public FoodAdapter(ArrayList<Food> items, Context context) {
        mSource = items;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new FoodHolder(FoodListItemLayoutBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.food_list_item_layout, parent, false)));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FoodHolder) holder).mBinding.setFoodItem(mSource.get(position));

    }

    @Override
    public int getItemCount() {
        return mSource.size();
    }


    class FoodHolder extends RecyclerView.ViewHolder {

        FoodListItemLayoutBinding mBinding;

        public FoodHolder(FoodListItemLayoutBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
