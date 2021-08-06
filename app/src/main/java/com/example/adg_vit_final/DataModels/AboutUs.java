package com.example.adg_vit_final.DataModels;

public class AboutUs {
    int pic;
    String name, designation;
    String email;
    String github;
    String linkedin;

    public AboutUs(int pic, String name, String designation){
        this.pic = pic;
        this.name = name;
        this.designation = designation;

    }
   public AboutUs(String email,String github,String linkedin){
        this.github=github;
        this.email=email;
        this.linkedin=linkedin;
}
public AboutUs(){

}


    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }


    public void setDesignation(String designation) {
        this.designation=designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.name = linkedin;
    }


}
