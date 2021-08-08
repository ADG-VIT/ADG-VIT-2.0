package com.example.adg_vit_final.NetworkModels;

import java.io.Serializable;

public class LoginModelNetwork implements Serializable {
    String email, password, Token, message;
    Error error;

    public LoginModelNetwork(String email, String password, String Token, String message) {
        this.email = email;
        this.password = password;
        this.Token = Token;
        this.message = message;
        this.error = error;
    }

    public LoginModelNetwork()
    {
        this.email = null;
        this.password = null;
        this.Token = null;
        this.message = null;
        this.error = null;
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
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public com.example.adg_vit_final.NetworkModels.Error getError() {
        return error;
    }

    public void setError(com.example.adg_vit_final.NetworkModels.Error error) {
        error = error;
    }
}