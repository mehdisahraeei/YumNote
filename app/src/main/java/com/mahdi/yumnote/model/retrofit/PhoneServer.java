package com.mahdi.yumnote.model.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class PhoneServer {


    @SerializedName("Phone_res")
    @Expose
    private String Phone_res;


    @SerializedName("phoneP")
    @Expose
    private String phone;


    @SerializedName("userPhone")
    @Expose
    private String user;



    @SerializedName("passPhone")
    @Expose
    private String passPhone;


    public PhoneServer(String phone_res, String phone, String user, String passPhone) {
        Phone_res = phone_res;
        this.phone = phone;
        this.user = user;
        this.passPhone = passPhone;
    }


    public String getPhone_res() {
        return Phone_res;
    }

    public void setPhone_res(String phone_res) {
        Phone_res = phone_res;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassPhone() {
        return passPhone;
    }

    public void setPassPhone(String passPhone) {
        this.passPhone = passPhone;
    }


}
