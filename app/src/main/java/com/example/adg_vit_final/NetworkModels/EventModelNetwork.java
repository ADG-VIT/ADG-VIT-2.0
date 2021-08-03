package com.example.adg_vit_final.NetworkModels;

import java.util.List;

public class EventModelNetwork{
    public List<String> regUsers;
    public boolean onlyVIT;
    public String _id;
    public String name;
    public String info;
    public int date;
    public boolean visibility;
    public String posterURL;
    public String eventURL;
    public String assetsURL;
    public int duration;
    public int __v;

    public EventModelNetwork(List<String> regUsers, boolean onlyVIT, String _id, String name, String info, int date, boolean visibility, String posterURL, String eventURL, String assetsURL, int duration, int __v) {
        this.regUsers = regUsers;
        this.onlyVIT = onlyVIT;
        this._id = _id;
        this.name = name;
        this.info = info;
        this.date = date;
        this.visibility = visibility;
        this.posterURL = posterURL;
        this.eventURL = eventURL;
        this.assetsURL = assetsURL;
        this.duration = duration;
        this.__v = __v;
    }

    public List<String> getRegUsers() {
        return regUsers;
    }

    public void setRegUsers(List<String> regUsers) {
        this.regUsers = regUsers;
    }

    public boolean isOnlyVIT() {
        return onlyVIT;
    }

    public void setOnlyVIT(boolean onlyVIT) {
        this.onlyVIT = onlyVIT;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getEventURL() {
        return eventURL;
    }

    public void setEventURL(String eventURL) {
        this.eventURL = eventURL;
    }

    public String getAssetsURL() {
        return assetsURL;
    }

    public void setAssetsURL(String assetsURL) {
        this.assetsURL = assetsURL;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}

