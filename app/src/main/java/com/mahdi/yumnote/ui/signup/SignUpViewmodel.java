package com.mahdi.yumnote.ui.signup;


import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.viewmodel.SignUpModel;




public class SignUpViewmodel extends ViewModel {


    //-----------------------------------------------------
    private static boolean state = false;
    private static EditText editUser, editEmail, editPass, editConfirm;

    public String userHint, emailHint, passHint, confirmHint;
    public int imageHide;
//-----------------------------------------------------


    public SignUpViewmodel() {
    }



    public SignUpViewmodel(SignUpModel model) {
        this.userHint = model.userHint;
        this.emailHint = model.emailHint;
        this.passHint = model.passHint;
        this.confirmHint = model.confirmHint;
        this.imageHide = model.imageHide;
    }




    @BindingAdapter({"hintRes1"})
    public static void setUserHint(EditText editText1, String text) {
        editUser = editText1;
        editText1.setHint(text);
    }




    @BindingAdapter({"hintRes2"})
    public static void setEmailHint(EditText editText2, String text) {
        editEmail = editText2;
        editText2.setHint(text);
    }



    @BindingAdapter({"hintRes3"})
    public static void setPassHint(EditText editText3, String text) {
        editPass = editText3;
        editText3.setHint(text);
    }



    @BindingAdapter({"hintRes4"})
    public static void setConfirmHint(EditText editText4, String text) {
        editConfirm = editText4;
        editText4.setHint(text);
    }




    @BindingAdapter({"imageRes1"})
    public static void setImage1(ImageView imageView, int imgUrl) {

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




    @BindingAdapter({"imageRes2"})
    public static void setImage2(ImageView imageView, int imgUrl) {

        final int[] x = {imgUrl = R.drawable.unhide};
        imageView.setImageResource(imgUrl);
        editConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state) {
                    state = false;
                    x[0] = R.drawable.unhide;
                    imageView.setImageResource(x[0]);
                    editConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    state = true;
                    x[0] = R.drawable.hide;
                    imageView.setImageResource(x[0]);
                    editConfirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }



    public String[] getValue() {

        String user = editUser.getText().toString();
        String email = editEmail.getText().toString();
        String pass = editPass.getText().toString();
        String confirm = editConfirm.getText().toString();


        return new String[]{user, email, pass, confirm};
    }




}
