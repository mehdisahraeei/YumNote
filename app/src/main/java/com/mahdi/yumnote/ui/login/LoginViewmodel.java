package com.mahdi.yumnote.ui.login;

import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.viewmodel.LoginModel;


public class LoginViewmodel extends ViewModel {


//-----------------------------------------------------
    private static boolean state = false;
    private static EditText editUser, editPass;

    public String userHint, passHint;
    public int imageHide;
//-----------------------------------------------------




    public LoginViewmodel() {
    }


    public LoginViewmodel(LoginModel model) {
        this.userHint = model.userHint;
        this.passHint = model.passwordHint;
        this.imageHide = model.imageHide;
    }



    @BindingAdapter({"Res1"})
    public static void setUserHint(EditText editText1, String text) {
        editUser = editText1;
        editText1.setHint(text);
    }


    @BindingAdapter({"Res2"})
    public static void setPassHint(EditText editText2, String text) {
        editPass = editText2;
        editText2.setHint(text);
    }



    @BindingAdapter({"imageResource"})
    public static void setImage(ImageView imageView, int imgUrl) {

        final int[] x = {imgUrl = R.drawable.unhide};
        imageView.setImageResource(imgUrl);
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state) {
                    state = false;
                    x[0] = R.drawable.unhide;
                    imageView.setImageResource(x[0]);
                    editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    state = true;
                    x[0] = R.drawable.hide;
                    imageView.setImageResource(x[0]);
                    editPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }





    public String[] getValue() {

        String user = editUser.getText().toString();
        String pass = editPass.getText().toString();


        return new String[]{user, pass};
    }





}

