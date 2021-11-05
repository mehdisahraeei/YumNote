package com.mahdi.yumnote.model.retrofit.api2;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class PasswordServer {



    @SerializedName("ReturnPass")
    @Expose
    private String returnpass;


    @SerializedName("PasswordProfile")
    @Expose
    private String newpass;


    @SerializedName("UserProfile")
    @Expose
    private String _user;



    @SerializedName("PassProfile")
    @Expose
    private String _pass;


    public PasswordServer(String returnpass, String newpass, String _user, String _pass) {
        this.returnpass = returnpass;
        this.newpass = newpass;
        this._user = _user;
        this._pass = _pass;
    }


    public String getReturnpass() {
        return returnpass;
    }

    public void setReturnpass(String returnpass) {
        this.returnpass = returnpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String get_user() {
        return _user;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    public String get_pass() {
        return _pass;
    }

    public void set_pass(String _pass) {
        this._pass = _pass;
    }
}
