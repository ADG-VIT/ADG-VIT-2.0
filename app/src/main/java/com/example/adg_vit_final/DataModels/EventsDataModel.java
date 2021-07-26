package com.example.adg_vit_final.DataModels;

public class EventsDataModel {
    int image;
    String title,date;

    public EventsDataModel()
    {
        image = 0;
        title = "";
        date = "";
    }

    public EventsDataModel(int image, String title, String date) {
        this.image = image;
        this.title = title;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
