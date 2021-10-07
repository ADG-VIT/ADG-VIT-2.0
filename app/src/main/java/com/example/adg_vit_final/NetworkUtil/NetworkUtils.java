package com.example.adg_vit_final.NetworkUtil;

import android.text.format.DateFormat;

import com.example.adg_vit_final.NetworkInterface.NetworkAPI;

import java.util.Calendar;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {

    public static String base_url =  "http://backend-events.herokuapp.com/";

    public static OkHttpClient getClientInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base_url)
            .client(getClientInstance())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static NetworkAPI networkAPI = retrofit.create(NetworkAPI.class);



    public static String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        String date = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }

}
