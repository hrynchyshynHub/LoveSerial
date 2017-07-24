package com.example.vania.loveserials.api;

import com.example.vania.loveserials.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ivan.hrynchyshyn on 19.07.2017.
 */

public interface LoveSerialsApi {
    @GET("get/{id}")
    Call<List<UserModel>> getUser(@Path("id")int userId);
}
