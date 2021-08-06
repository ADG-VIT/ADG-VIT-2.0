package com.example.adg_vit_final.DataModels;

public class ProjectItems {
    String image;
    String name, shortDescp,id;

    public ProjectItems(String image, String name, String shortDescp) {
        this.image = image;
        this.name = name;
        this.shortDescp = shortDescp;
    }

    public ProjectItems() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescp() {
        return shortDescp;
    }

    public void setShortDescp(String shortDescp) {
        this.shortDescp = shortDescp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {return id;}
}
