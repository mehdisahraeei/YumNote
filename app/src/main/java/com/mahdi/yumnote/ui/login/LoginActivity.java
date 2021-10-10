package com.mahdi.yumnote.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.ActivityLoginBinding;
import com.mahdi.yumnote.model.viewmodel.LoginModel;
import com.mahdi.yumnote.other.sharedpreferences.SharedPrefer;
import com.mahdi.yumnote.rx.login.LoginRx;
import com.mahdi.yumnote.ui.login.clicks.LoginClicks;
import com.mahdi.yumnote.ui.login.clicks.LoginHelper;
import com.mahdi.yumnote.ui.main.activity.MainActivity;




public class LoginActivity extends AppCompatActivity {


    private SharedPrefer sharedPrefer;
    private LoginViewmodel loginViewmodel;
    private ActivityLoginBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//--------------------------------------------------------------------------------------------
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewmodel = new ViewModelProvider(this).get(LoginViewmodel.class);
        sharedPrefer = new SharedPrefer(this);
//--------------------------------------------------------------------------------------------


        if (sharedPrefer.isUserLogin())
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }




        binding.setLogin(new LoginViewmodel(new
                LoginModel("username", "password", R.drawable.unhide)));

        binding.setLoginClick(new LoginClicks(this));


        binding.setLoginClickHelper(new LoginHelper() {
            @Override
            public void ClickLogin(View view) {
                String[] arr = loginViewmodel.getValue();
                new LoginRx().Submit(view.getContext(),arr[0], arr[1]);
            }
        });


    }







    @Override
    public void onBackPressed() {
    }




}

