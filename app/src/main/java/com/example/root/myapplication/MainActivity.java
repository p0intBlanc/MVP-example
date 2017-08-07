package com.example.root.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.myapplication.home.ui.HomeFragment;
import com.google.gson.Gson;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Gson mGsoon;
    @Inject
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ((MyApplication) getApplication()).getnetComponent().inject(this);
        getSupportFragmentManager().beginTransaction().add(R.id.parent_container, new HomeFragment()).commit();
    }
}
