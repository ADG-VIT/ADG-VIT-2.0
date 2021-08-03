package com.example.adg_vit_final.NetworkInterface;

import com.example.adg_vit_final.NetworkModels.EventModelNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkAPI {
    @GET("{param}")
    Call<List<EventModelNetwork>> getEvents(@Path("param") String param);
}
