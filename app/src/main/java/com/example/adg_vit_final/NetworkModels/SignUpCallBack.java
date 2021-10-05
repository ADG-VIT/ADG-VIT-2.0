package com.example.adg_vit_final.NetworkModels;

public class SignUpCallBack {
    String token;
    String message;

    public SignUpCallBack(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
