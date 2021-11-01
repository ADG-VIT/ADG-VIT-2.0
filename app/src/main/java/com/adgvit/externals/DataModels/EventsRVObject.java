package com.adgvit.externals.DataModels;

public class EventsRVObject{
    int ImageView;
    String heading;
    String date;

    public EventsRVObject(int imageView, String heading, String date) {
        ImageView = imageView;
        this.heading = heading;
        this.date = date;
    }

    public int getImageView() {
        return ImageView;
    }

    public void setImageView(int imageView) {
        ImageView = imageView;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}