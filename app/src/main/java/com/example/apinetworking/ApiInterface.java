package com.example.apinetworking;

import com.example.apinetworking.models.UserData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users/2")
    Call<UserData> getUserData();
}
