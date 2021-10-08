package com.mahdi.yumnote.ui.signup;


import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.ActivitySignupBinding;
import com.mahdi.yumnote.model.viewmodel.SignUpModel;
import com.mahdi.yumnote.rx.signup.SignupRx;
import com.mahdi.yumnote.ui.signup.clicks.SignUpClicks;
import com.mahdi.yumnote.ui.signup.clicks.SignUpHelper;



public class SignupActivity extends AppCompatActivity {


    private SignUpViewmodel logupViewmodel;
    private ActivitySignupBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//--------------------------------------------------------------------------------------------
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        logupViewmodel = new ViewModelProvider(this).get(SignUpViewmodel.class);
//--------------------------------------------------------------------------------------------



        binding.setSignUp(new SignUpViewmodel(new SignUpModel("username", "email",
                "password", "confirm password", R.drawable.unhide)));
        binding.setSignUpClick(new SignUpClicks(this));


        binding.setSignUpClickHelper(new SignUpHelper() {
            @Override
            public void ClickSignup(View view) {
                String[] arr = logupViewmodel.getValue();
                new SignupRx().Submit(arr[0], arr[1], arr[2], arr[3]);
            }
        });


    }


    @Override
    public void onBackPressed() {
    }


}