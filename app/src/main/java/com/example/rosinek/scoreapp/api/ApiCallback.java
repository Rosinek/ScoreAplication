package com.example.rosinek.scoreapp.api;

import com.example.rosinek.scoreapp.ui.BaseView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public abstract class ApiCallback<T> implements Callback<T> {

    private BaseView baseView;

    public ApiCallback(BaseView baseView) {
        this.baseView = baseView;
    }

    public abstract void onSuccess(T t);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            baseView.showMessage(response.message());
        }
    }


    @Override
    public void onFailure(Call<T> call, Throwable t) {
        baseView.showMessage(t.getMessage());
    }
}