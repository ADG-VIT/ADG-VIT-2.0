package com.example.adg_vit_final.NetworkInterface;

import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.NetworkModels.LoginModelNetwork;
import com.example.adg_vit_final.NetworkModels.ProjectModelNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;

public interface NetworkAPI {
    @GET("{param}")
    Call<List<EventModelNetwork>> getEvents(@Path("param") String param);

    @GET("projects/1")
    Call<List<ProjectModelNetwork>> getProjects();

    @FormUrlEncoded
    @POST("users/signin")
    Call<LoginModelNetwork> loginUser(
        @Body LoginModelNetwork login
    );
}
