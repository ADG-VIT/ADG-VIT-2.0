package com.example.adg_vit_final.NetworkModels;

import java.io.Serializable;

public class LoginModelNetwork implements Serializable {

    String email;
    String password;

    public LoginModelNetwork(String email, String password) {
        this.email = email;
        this.password = password;
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
}