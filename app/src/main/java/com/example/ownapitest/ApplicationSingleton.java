package com.example.ownapitest;

import android.app.Application;

import com.example.ownapitest.Model.User;

public class ApplicationSingleton extends Application {
    public User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
