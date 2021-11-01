package com.adgvit.externals.NetworkInterface;

import com.adgvit.externals.NetworkModels.Domain;
import com.adgvit.externals.NetworkModels.AboutModelNetwork;
import com.adgvit.externals.NetworkModels.EventModelNetwork;
import com.adgvit.externals.NetworkModels.HomeModelNetwork;
import com.adgvit.externals.NetworkModels.LoginModelNetwork;
import com.adgvit.externals.NetworkModels.SignUpCallBack;
import com.adgvit.externals.NetworkModels.SpecificProject;
import com.adgvit.externals.NetworkModels.User;
import com.adgvit.externals.NetworkModels.ProjectModelNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkAPI {
    @GET("events")
    Call<List<EventModelNetwork>> getEvents(@Query("q") int q);

    @GET("events/{id}")
    Call<EventModelNetwork> getSpecificEvent(@Path("id") String id);

    @POST("users/register")
    Call<SignUpCallBack> registerUser(@Body User user);

    @POST("users/signin")
    Call<SignUpCallBack> loginUser(@Body LoginModelNetwork login);

    @GET("projects")
    Call<List<ProjectModelNetwork>> getProjects(@Query("q") int q);

    @GET("projects/{id}")
    Call<SpecificProject> getSpecificProject(@Path("id") String id);

    @GET("home")
    Call<HomeModelNetwork> getHomeDetails();

    @GET("board")
    Call<List<AboutModelNetwork>> getBoard();

    @GET("users")
    Call<User> getUserInfo(@Header("auth-token") String token);

    @GET("domain")
    Call<List<Domain>> getDomains();
}
