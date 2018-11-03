package com.mohaned.loginvalidationapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.mohaned.loginvalidationapp.callbacks.LoginResultCallBacks;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private LoginResultCallBacks loginResultCallBacks;

    public UserViewModelFactory(LoginResultCallBacks loginResultCallBacks) {
        this.loginResultCallBacks = loginResultCallBacks;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(loginResultCallBacks);
    }

}
