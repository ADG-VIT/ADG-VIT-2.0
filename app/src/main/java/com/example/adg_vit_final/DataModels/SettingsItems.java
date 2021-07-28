package com.example.adg_vit_final.DataModels;

public class SettingsItems {
    int img;
    String text;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SettingsItems(int img, String text) {
        this.img = img;
        this.text = text;
    }
}
