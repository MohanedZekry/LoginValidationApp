package com.mohaned.loginvalidationapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.mohaned.loginvalidationapp.callbacks.LoginResultCallBacks;
import com.mohaned.loginvalidationapp.model.User;

public class UserViewModel extends ViewModel {
    private User user;
    private LoginResultCallBacks loginResultCallBacks;

    public UserViewModel( LoginResultCallBacks loginResultCallBacks) {
        this.user = new User();
        this.loginResultCallBacks = loginResultCallBacks;
    }

    public TextWatcher getMailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setMail(editable.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setPassword(editable.toString());
            }
        };
    }

    public void onBtnLoginClicked(View view){
        if (user.isValid()){
            loginResultCallBacks.onSuccess("Login Success");
        }
        else{
            loginResultCallBacks.onError("Login Error");
        }
    }
}