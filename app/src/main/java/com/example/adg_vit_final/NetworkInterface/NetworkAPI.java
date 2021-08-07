package com.example.adg_vit_final.NetworkInterface;

import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.NetworkModels.HomeModelNetwork;
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

public interface NetworkAPI {
    @GET("{param}")
    Call<List<EventModelNetwork>> getEvents(@Path("param") String param);

    @GET("events/{id}")
    Call<EventModelNetwork> getEvent(@Path("id") String id);

    @POST("users/register")
    Call<User> registerUser(@Body User user);

    @GET("projects")
    Call<List<ProjectModelNetwork>> getProjects();

    @GET("projects/{id}")
    Call<SpecificProject> getSpecificProject(@Path("id") String id);

    @GET("home")
    Call<HomeModelNetwork> getHomeDetails();
}
