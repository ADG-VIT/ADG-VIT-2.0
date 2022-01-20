package com.adgvit.externals.DataModels;

public class EventsDataModel {
    String id;
    String imageURL;
    String title;
    long date;
    String info;

    public EventsDataModel() { }

    public EventsDataModel(String id, String imageURL, String title, long date, String info) {
        this.id = id;
        this.imageURL = imageURL;
        this.title = title;
        this.date = date;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id ;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImage(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info ;
    }
}
