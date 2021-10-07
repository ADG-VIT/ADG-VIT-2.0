package com.example.adg_vit_final.NetworkModels;

import com.google.gson.annotations.SerializedName;

public class SignUpCallBack {

    @SerializedName("message")
    public String message;

    @SerializedName("token")
    public String token;

    public SignUpCallBack(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
