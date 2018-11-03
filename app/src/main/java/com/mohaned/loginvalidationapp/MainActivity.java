package com.mohaned.loginvalidationapp;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mohaned.loginvalidationapp.callbacks.LoginResultCallBacks;
import com.mohaned.loginvalidationapp.databinding.ActivityMainBinding;
import com.mohaned.loginvalidationapp.viewmodel.UserViewModel;
import com.mohaned.loginvalidationapp.viewmodel.UserViewModelFactory;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this, new UserViewModelFactory(this))
        .get(UserViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this, "Login Error", Toast.LENGTH_SHORT).show();

    }
}
