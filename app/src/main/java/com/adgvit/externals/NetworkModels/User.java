package com.adgvit.externals.NetworkModels;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    String name;
    String email;
    String phone;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<String> getRegEvents() {
        return regEvents;
    }

    public void setRegEvents(List<String> regEvents) {
        this.regEvents = regEvents;
    }

    String password;

    public User(String name, String email, String phone, String password, String regno, String university, String message, String _id, List<String> regEvents, com.adgvit.externals.NetworkModels.Error error) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.regno = regno;
        this.university = university;
        this.message = message;
        this._id = _id;
        this.regEvents = regEvents;
        Error = error;
    }

    String regno;
    String university;
    String message;
    String _id;
    List<String> regEvents;
    Error Error;

    public User(String name, String email, String phone, String password, String regno, String university,String message,Error Error) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.regno = regno;
        this.university = university;
        this.message = message;
        this.Error = Error;
    }

    public User(String name, String email, String phone, String password, String university,String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.university = university;
        this.message = message;
        this.Error = Error;
    }

    public User() {
        this.name = null;
        this.email = null;
        this.phone = null;
        this.password = null;
        this.regno = null;
        this.university = null;
        this.message = null;
        this.Error = null;
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

    public com.adgvit.externals.NetworkModels.Error getError() {
        return Error;
    }

    public void setError(com.adgvit.externals.NetworkModels.Error error) {
        Error = error;
    }
}
