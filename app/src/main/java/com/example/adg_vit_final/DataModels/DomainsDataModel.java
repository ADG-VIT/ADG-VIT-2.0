package com.example.adg_vit_final.DataModels;

public class DomainsDataModel {

    private String title,desc,image;

    public DomainsDataModel()
    {
        image = "";
        title = "";
        desc = "";
    }

    public DomainsDataModel(String image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public String  getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
