package com.example.ownapitest;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("fullname")
    private String mName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("password")
    private String mPassword;

    public User(String email, @Nullable String name, String password) {
        mEmail = email;
        mName = name;
        mPassword = password;
    }

    public User(String email, String password) {
        mEmail = email;
        mPassword = password;
    }




    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "mName='" + mName + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}