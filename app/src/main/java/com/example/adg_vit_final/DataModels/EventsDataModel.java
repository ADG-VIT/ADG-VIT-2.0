package com.example.adg_vit_final.DataModels;

public class EventsDataModel {
    String imageURL;
    String title,date;

    public EventsDataModel() { }

    public EventsDataModel(String imageURL, String title, String date) {
        this.imageURL = imageURL;
        this.title = title;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
