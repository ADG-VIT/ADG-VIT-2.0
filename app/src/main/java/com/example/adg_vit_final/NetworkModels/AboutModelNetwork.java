package com.example.adg_vit_final.NetworkModels;

public class AboutModelNetwork {
    private String Name;
    private String Email;
    private String Github;
    private String LinkedIn;
    private String pic;
    private String Designation;

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public AboutModelNetwork(String name, String email, String github, String linkedin, String pic, String designation){
        this.Name=name;
        this.Email=email;
        this.Github=github;
        this.LinkedIn=linkedin;
        this.pic=pic;
        this.Designation=designation;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGithub() {
        return Github;
    }

    public void setGithub(String github) {
        Github = github;
    }

    public String getLinkedIn() {
        return LinkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        LinkedIn = linkedIn;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
