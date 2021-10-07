package com.mahdi.yumnote.ui.login;


import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.ActivityLoginBinding;
import com.mahdi.yumnote.model.viewmodel.LoginModel;
import com.mahdi.yumnote.ui.login.clicks.LoginClicks;
import com.mahdi.yumnote.ui.login.clicks.LoginHelper;


public class LoginActivity extends AppCompatActivity {



    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//--------------------------------------------------------------------------------------------
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
//--------------------------------------------------------------------------------------------

        binding.setLogin(new LoginViewmodel(new
                LoginModel("username", "password", R.drawable.unhide)));

        binding.setLoginClick(new LoginClicks(this));


        binding.setLoginClickHelper(new LoginHelper() {
            @Override
            public void ClickLogin(View view) {

            }
        });


    }




    @Override
    public void onBackPressed() {
    }




}

