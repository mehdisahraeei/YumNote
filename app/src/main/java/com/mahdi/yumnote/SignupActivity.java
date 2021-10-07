package com.mahdi.yumnote;


import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.mahdi.yumnote.databinding.ActivitySignupBinding;




public class SignupActivity extends AppCompatActivity {


    ActivitySignupBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//--------------------------------------------------------------------------------------------
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
//--------------------------------------------------------------------------------------------



    }


    @Override
    public void onBackPressed() {
    }


}