package com.example.ownapitest.Network;


import com.example.ownapitest.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TamerlanApi {
    @POST("register.php")
    Call<User> registration(@Body User user);

    @POST("login.php")
    Call<User> login(@Body User user);

}
