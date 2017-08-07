package com.example.root.myapplication.home;

/**
 * Created by root on 8/6/17.
 */

public interface BasePresenter<T> {

    void attachView(T view);

    void detachView(T view);
}
