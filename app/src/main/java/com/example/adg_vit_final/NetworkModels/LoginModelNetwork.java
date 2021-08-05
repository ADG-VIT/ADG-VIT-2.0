package com.example.adg_vit_final.NetworkModels;

public class LoginModelNetwork {
    String email, password, token, message;
    Error error;

    public LoginModelNetwork()
    {
        this.email = null;
        this.password = null;
        this.token = null;
        this.message = null;
    }

    public LoginModelNetwork(String email, String password, String token, String message) {
        this.email = email;
        this.password = password;
        this.token = token;
        this.message = message;
        this.error = error;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}