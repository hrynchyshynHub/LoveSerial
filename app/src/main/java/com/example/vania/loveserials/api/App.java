
package com.example.vania.loveserials.api;

import android.app.Application;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class App extends Application {
    private static LoveSerialsApi loveSerialsApi;
    private Retrofit retrofit;
    private static final String BASE_URL = "http://nalivajj09-001-site1.etempurl.com/api/";

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);
        retrofit = new Retrofit.Builder()
                .client(clientBuilder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loveSerialsApi = retrofit.create(LoveSerialsApi.class);
    }
    public static LoveSerialsApi getApi()
    {
        return loveSerialsApi;
    }
}
