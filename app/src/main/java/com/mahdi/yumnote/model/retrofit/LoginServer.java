package com.mahdi.yumnote.model.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginServer {

    @SerializedName("isSuccess")
    @Expose
    private int isSuccess;

    @SerializedName("userLogin")
    @Expose
    private String user;

    @SerializedName("passLogin")
    @Expose
    private String password;




    public LoginServer(int isSuccess, String user, String password) {
        this.isSuccess = isSuccess;
        this.user = user;
        this.password = password;
    }



    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
