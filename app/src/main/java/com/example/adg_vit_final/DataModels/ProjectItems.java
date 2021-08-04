package com.example.adg_vit_final.DataModels;

public class ProjectItems {
    String image;
    String name, shortDescp;

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
        shortDescp = shortDescp;
    }
}
