package com.example.vania.loveserials.api;

import android.app.Application;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ivan.hrynchyshyn on 19.07.2017.
 */

public class App extends Application {
    private static LoveSerialsApi loveSerialsApi;
    private Retrofit retrofit;
    private static final String BASE_URL = "http://www.loveserials.com/api/";

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        loveSerialsApi = retrofit.create(LoveSerialsApi.class);
    }
    public static LoveSerialsApi getApi(){
        return loveSerialsApi;
    }
}