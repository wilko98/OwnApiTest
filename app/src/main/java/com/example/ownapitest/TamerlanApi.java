package com.example.ownapitest;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TamerlanApi {
    @POST("register.php")
    Call<User> registration(@Body User user);

    @POST("login.php")
    Call<User> login(@Body User user);

}
