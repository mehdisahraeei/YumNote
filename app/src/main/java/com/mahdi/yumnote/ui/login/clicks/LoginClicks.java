package com.mahdi.yumnote.ui.login.clicks;

import android.content.Context;
import android.content.Intent;
import com.mahdi.yumnote.ui.signup.SignupActivity;


public class LoginClicks {

    private Context context;


    public LoginClicks(Context context) {
        this.context = context;
    }


    public void ClickSignUp() {
        context.startActivity(new Intent(context, SignupActivity.class));
    }


}
