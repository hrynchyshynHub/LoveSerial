
package com.example.vania.loveserials.api;


import com.example.vania.loveserials.models.LoginModel;
import com.example.vania.loveserials.models.Post;
import com.example.vania.loveserials.models.Review;
import com.example.vania.loveserials.models.Serial;
import com.example.vania.loveserials.models.SubscribeToSerial;
import com.example.vania.loveserials.models.SubscribeToUser;
import com.example.vania.loveserials.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoveSerialsApi {
    @POST("Account")
    Call<String> isUserInDatabase(@Body LoginModel loginModel);

    @POST("Account/register")
    Call<String> isUserCreateSuccessful(@Body User user);

    @GET("User/{id}")
    Call<User> getMainUserInfo(@Path("id") String userId);
    // Я передаю id юзера, ти повертаєш самого юзера

    @POST("/getUserWatchedSerials")
    Call<List<Serial>> getUserWatchedSerials(@Body String userId);
    // Я передаю id юзера, ти повертаєш лист переглянутих ним серіалів

    @POST("/addPostFromUser")
    Call<Boolean> addPost(@Body Post post, @Body String userId);
    // Я передаю пост і юзера який запостив, ти повертаєш чи добавилось чи не

    @POST("/addReviewFromUser")
    Call<Boolean> addReview(@Body Review review, @Body String userId, @Body int serialId);
    // Я передаю ревю, id юзера і серіалу, ти повертаєш чи успішно додано

    @POST("/getUserFollowUsers")
    Call<List<User>> getListFollowUsers(@Body String userId);
    // Я передаю id юзера, ти повертаєш юзерів на яких він підписаний

    @POST("/getListFollowSerials")
    Call<List<Serial>> getListFollowSerials(@Body String userId);

    @POST("/addFollowToUser")
    Call<Boolean> isAddFollowToUserSuccessful(@Body SubscribeToUser subscribeToUser);
    // Я передаю id userFrom, id userTo, ти повертаєш чи підписка відбулась успішно

    @POST("/addFollowToSerial")
    Call<Boolean> isAddFollowToSerialSuccessful(@Body SubscribeToSerial subscribeToSerial);
    // Я передаю id юзера і id серіалу, ти повертаєш чи успішно була додана підписка на серіал

    @GET("/getAllSerials")
    Call<List<Serial>> getAllSerials();
    // Ти повертаєш лист всіх серіалів

    @GET("/getAllUsers")
    Call<List<User>> getAllUsers();
    // Ти повертаєш лист всіх юзерів

    @GET("serials/")
    Call<List<Serial>> getSerials();

    @PUT("/changeUserData")
    Call<Boolean> changeUser(@Body User user);
    // Я передаю юзера зміненого, ти по ід апдейтиш його інфу і повертаєш чи успішно був змінений

    @POST("/getSerialByName")
    Call<Serial> getSerialByName(@Body String name);
    // Я передаю імя серіалу, ти повертаєш сам серіал
}

