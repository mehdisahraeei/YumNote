package com.mahdi.yumnote.model.viewmodel;

public class LoginModel {

    public String userHint;
    public String passwordHint;
    public int imageHide;


    public LoginModel(String userHint, String passwordHint, int imageHide) {
        this.userHint = userHint;
        this.passwordHint = passwordHint;
        this.imageHide = imageHide;
    }

}
