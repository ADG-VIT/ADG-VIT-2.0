package com.example.adg_vit_final.NetworkInterface;

import com.example.adg_vit_final.JavaActivities.About;
import com.example.adg_vit_final.NetworkModels.AboutModelNetwork;
import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.NetworkModels.HomeModelNetwork;
import com.example.adg_vit_final.NetworkModels.LoginModelNetwork;
import com.example.adg_vit_final.NetworkModels.SpecificProject;
import com.example.adg_vit_final.NetworkModels.User;
import com.example.adg_vit_final.NetworkModels.ProjectModelNetwork;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkAPI {
    @GET("events")
    Call<List<EventModelNetwork>> getEvents(@Query("q") int q);

    @GET("events/{id}")
    Call<EventModelNetwork> getSpecificEvent(@Path("id") String id);

    @POST("users/register")
    Call<User> registerUser(@Body User user);

    @POST("users/signin")
    Call<LoginModelNetwork> loginUser(@Body LoginModelNetwork login);

    @GET("projects")
    Call<List<ProjectModelNetwork>> getProjects(@Query("q") int q);

    @GET("projects/{id}")
    Call<SpecificProject> getSpecificProject(@Path("id") String id);

    @GET("home")
    Call<HomeModelNetwork> getHomeDetails();

    @GET("board")
    Call<List<AboutModelNetwork>> getBoard();
}
