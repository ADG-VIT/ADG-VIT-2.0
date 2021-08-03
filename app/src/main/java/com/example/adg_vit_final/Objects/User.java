package com.example.adg_vit_final.Objects;

import java.io.Serializable;

public class User implements Serializable {
    String name,email,phone,password,regno,university,message;

    public User(String name, String email, String phone, String password, String regno, String university,String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.regno = regno;
        this.university = university;
        this.message = message;
    }

    public User(String name, String email, String phone, String password, String university,String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.university = university;
        this.message = message;
    }

    public User() {
        this.name = null;
        this.email = null;
        this.phone = null;
        this.password = null;
        this.regno = null;
        this.university = null;
        this.message = null;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getRegno() {
        return regno;
    }

    public String getUniversity() {
        return university;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}
}
