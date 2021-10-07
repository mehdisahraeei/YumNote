package com.mahdi.yumnote.model.viewmodel;

public class SignUpModel {

    public String userHint;
    public String emailHint;
    public String passHint;
    public String confirmHint;
    public int imageHide;


    public SignUpModel(String userHint, String emailHint, String passHint, String confirmHint, int imageHide) {
        this.userHint = userHint;
        this.emailHint = emailHint;
        this.passHint = passHint;
        this.confirmHint = confirmHint;
        this.imageHide = imageHide;
    }
}
