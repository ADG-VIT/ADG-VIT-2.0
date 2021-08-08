package com.example.adg_vit_final.NetworkModels;

public class Highlight{
    public String _id;
    public String name;
    public String imageURL;
    public String type;
    public int __v;

    public Highlight(String _id, String name, String imageURL, String type, int __v) {
        this._id = _id;
        this.name = name;
        this.imageURL = imageURL;
        this.type = type;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}