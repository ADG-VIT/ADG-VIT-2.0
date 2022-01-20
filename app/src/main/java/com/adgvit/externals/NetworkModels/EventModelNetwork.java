package com.adgvit.externals.NetworkModels;

import java.util.List;

public class EventModelNetwork{
    public List<String> regUsers;
    public Boolean onlyVIT;
    public String _id;
    public String name;
    public String info;
    public long date;
    public Boolean visibility;
    public String posterURL;
    public String eventURL;
    public String assetsURL;
    public Integer duration;
    public Integer __v;
    private String message;

    public EventModelNetwork(List<String> regUsers, Boolean onlyVIT, String _id, String name, String info, long date, Boolean visibility, String posterURL, String eventURL, String assetsURL, Integer duration, Integer __v,String message) {
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
        this.message = message;
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

    public void setOnlyVIT(Boolean onlyVIT) {
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
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

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

