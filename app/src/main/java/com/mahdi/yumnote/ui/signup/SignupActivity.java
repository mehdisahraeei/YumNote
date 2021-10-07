package com.mahdi.yumnote.ui.signup;


import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.ActivitySignupBinding;
import com.mahdi.yumnote.model.viewmodel.SignUpModel;
import com.mahdi.yumnote.ui.signup.clicks.SignUpClicks;
import com.mahdi.yumnote.ui.signup.clicks.SignUpHelper;


public class SignupActivity extends AppCompatActivity {


    ActivitySignupBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//--------------------------------------------------------------------------------------------
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
//--------------------------------------------------------------------------------------------

        binding.setSignUp(new SignUpViewmodel(new SignUpModel("username", "email",
                "password", "confirm password", R.drawable.unhide)));
        binding.setSignUpClick(new SignUpClicks(this));


        binding.setSignUpClickHelper(new SignUpHelper() {
            @Override
            public void ClickSignup(View view) {
            }
        });





    }


    @Override
    public void onBackPressed() {
    }


}