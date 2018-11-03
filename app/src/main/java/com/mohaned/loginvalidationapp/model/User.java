package com.mohaned.loginvalidationapp.model;

import android.databinding.BaseObservable;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User extends BaseObservable {
    private String mail,password;

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid(){
        return !TextUtils.isEmpty(getMail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getMail()).matches() &&
                getPassword().length() >= 8;
    }

}
