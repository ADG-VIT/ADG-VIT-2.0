package com.example.adg_vit_final.DataModels;

public class HomeDomainsObject {
    int image;
    String domainName;

    public HomeDomainsObject(int image, String domainName) {
        this.image = image;
        this.domainName = domainName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
