package com.mahdi.yumnote;


import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.mahdi.yumnote.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {



    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//--------------------------------------------------------------------------------------------
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
//--------------------------------------------------------------------------------------------




    }




    @Override
    public void onBackPressed() {
    }




}

