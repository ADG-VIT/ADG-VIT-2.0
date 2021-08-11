package com.example.adg_vit_final.NetworkModels;

public class AboutModelNetwork {
    private String Name,Email,Github,LinkedIn,Pic,Designation;

    public AboutModelNetwork(String name, String email, String github, String linkedIn, String pic, String designation) {
        Name = name;
        Email = email;
        Github = github;
        LinkedIn = linkedIn;
        Pic = pic;
        Designation = designation;
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
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
