package com.mahdi.yumnote.model.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupServer {



    @SerializedName("user")
    @Expose
    private String user;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("pass")
    @Expose
    private String password;


    public SignupServer(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
