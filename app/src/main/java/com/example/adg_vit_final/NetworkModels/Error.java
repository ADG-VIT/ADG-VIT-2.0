package com.example.adg_vit_final.NetworkModels;

public class Error {
    String _message,message,name;

    public Error(String _message, String message, String name) {
        this._message = _message;
        this.message = message;
        this.name = name;
    }

    public Error() {
        this._message =null ;
        this.message = null;
        this.name = null;
    }

    public String get_message() {
        return _message;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
