package com.example.adg_vit_final.NetworkModels;

import com.google.gson.annotations.SerializedName;

public class ProjectModelNetwork {
    private String title;
    private String description;
    private String shortDescription;
    private String features;
    private String mockup;
    private String thumbnail;
    private String websiteLink;
    private String iosLink;
    private String androidLink;
    private boolean isItUnderDevelopment;
    private int releaseDate;
    private int __v;
    @SerializedName("_id")
    private String id;

    public ProjectModelNetwork(String title, String description,
                               String shortDescription, String features,
                               String mockup, String thumbnail, String websiteLink,
                               String iosLink, String androidLink, boolean isItUnderDevelopment,
                               int releaseDate, int __v, String id) {
        this.title = title;
        this.description = description;
        this.shortDescription = shortDescription;
        this.features = features;
        this.mockup = mockup;
        this.thumbnail = thumbnail;
        this.websiteLink = websiteLink;
        this.iosLink = iosLink;
        this.androidLink = androidLink;
        this.isItUnderDevelopment = isItUnderDevelopment;
        this.releaseDate = releaseDate;
        this.__v = __v;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getMockup() {
        return mockup;
    }

    public void setMockup(String mockup) {
        this.mockup = mockup;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getIosLink() {
        return iosLink;
    }

    public void setIosLink(String iosLink) {
        this.iosLink = iosLink;
    }

    public String getAndroidLink() {
        return androidLink;
    }

    public void setAndroidLink(String androidLink) {
        this.androidLink = androidLink;
    }

    public boolean isItUnderDevelopment() {
        return isItUnderDevelopment;
    }

    public void setItUnderDevelopment(boolean itUnderDevelopment) {
        isItUnderDevelopment = itUnderDevelopment;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
