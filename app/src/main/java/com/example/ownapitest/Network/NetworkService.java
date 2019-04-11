package com.example.ownapitest.Network;

import com.example.ownapitest.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private TamerlanApi api;
    private Gson gson;
    private Retrofit mRetrofit;
    private static NetworkService mInstance;



    private NetworkService(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit =  new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static NetworkService getInstance(){
        if (mInstance == null){
            mInstance = new NetworkService();
        }
        return mInstance;
    }
    public TamerlanApi getNetworkApi(){
        return mRetrofit.create(TamerlanApi.class);
    }

}
