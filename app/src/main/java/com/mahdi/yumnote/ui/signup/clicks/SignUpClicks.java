package com.mahdi.yumnote.ui.signup.clicks;

import android.content.Context;
import android.content.Intent;
import com.mahdi.yumnote.ui.login.LoginActivity;


public class SignUpClicks {


    private Context context;


    public SignUpClicks(Context context) {
        this.context = context;
    }


    public void ClickLogin()
    {
        context.startActivity(new Intent(context, LoginActivity.class));
    }



}
