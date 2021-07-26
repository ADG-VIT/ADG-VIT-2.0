package com.example.adg_vit_final.DataModels;

public class ProjectItems {
    int image;
    String name, shortDescp;

    public ProjectItems(int image, String name, String shortDescp) {
        this.image = image;
        this.name = name;
        this.shortDescp = shortDescp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
