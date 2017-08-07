package com.example.root.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by root on 8/6/17.
 */

public abstract class BaseFragment extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        injectDependencies();
    }



    public abstract void injectDependencies();
}
