package com.example.adg_vit_final.NetworkInterface;

import com.example.adg_vit_final.NetworkModels.AboutModelNetwork;
import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.NetworkModels.ProjectModelNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkAPI {
    @GET("{param}")
    Call<List<EventModelNetwork>> getEvents(@Path("param") String param);

    @GET("projects/1")
    Call<List<ProjectModelNetwork>> getProjects();

    @GET("board")
    Call<List<AboutModelNetwork>> getAbout();



}
