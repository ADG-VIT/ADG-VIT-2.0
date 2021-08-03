package com.example.adg_vit_final.Interfaces;

import com.example.adg_vit_final.Objects.User;
import com.example.adg_vit_final.Objects.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterUserApi {
    @POST("users/register")
    Call<User> registerUser(@Body User user);
}
