package com.mahdi.yumnote.model.retrofit;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class ProfileServer {


    @SerializedName("IdResponse")
    @Expose
    private int IdResponse;


    @SerializedName("UserResponse")
    @Expose
    private String UserResponse;


    @SerializedName("PasswordResponse")
    @Expose
    private String PasswordResponse;


    @SerializedName("EmailResponse")
    @Expose
    private String EmailResponse;


    @SerializedName("PhoneResponse")
    @Expose
    private int PhoneResponse;


//--------------------------------------------------------------------------


    @SerializedName("userProfile")
    @Expose
    private String user;

    @SerializedName("passProfile")
    @Expose
    private String pass;


    public ProfileServer(int idResponse, String userResponse, String passwordResponse, String emailResponse, int phoneResponse, String user, String pass) {
        IdResponse = idResponse;
        UserResponse = userResponse;
        PasswordResponse = passwordResponse;
        EmailResponse = emailResponse;
        PhoneResponse = phoneResponse;
        this.user = user;
        this.pass = pass;
    }

    public int getIdResponse() {
        return IdResponse;
    }

    public void setIdResponse(int idResponse) {
        IdResponse = idResponse;
    }

    public String getUserResponse() {
        return UserResponse;
    }

    public void setUserResponse(String userResponse) {
        UserResponse = userResponse;
    }

    public String getPasswordResponse() {
        return PasswordResponse;
    }

    public void setPasswordResponse(String passwordResponse) {
        PasswordResponse = passwordResponse;
    }

    public String getEmailResponse() {
        return EmailResponse;
    }

    public void setEmailResponse(String emailResponse) {
        EmailResponse = emailResponse;
    }

    public int getPhoneResponse() {
        return PhoneResponse;
    }

    public void setPhoneResponse(int phoneResponse) {
        PhoneResponse = phoneResponse;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
