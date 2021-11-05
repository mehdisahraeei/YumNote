package com.mahdi.yumnote.other.dialog;



import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.retrofit.api2.PasswordServer;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices2;
import com.mahdi.yumnote.networking.retrofit.client.RetrofitClientMore;
import com.mahdi.yumnote.other.sharedpreferences.SharedPrefer;
import com.mahdi.yumnote.ui.login.LoginActivity;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class PassCustomDialog extends Dialog implements View.OnClickListener {



    private String user, pass;
    private String MainValue;
    private Context context;
    private Dialog dialog;
    private ImageView submit;
    private EditText passEdit;



    public PassCustomDialog(Context context, String user, String pass) {
        super(context);
        this.context = context;
        this.user = user;
        this.pass = pass;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_dialog);

//-------------------------------------------------------------------------
        submit = findViewById(R.id.image_pass_dialog);
        passEdit = findViewById(R.id.edit_pass_dialog);


        submit.setOnClickListener(this);
//-------------------------------------------------------------------------


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_pass_dialog:

                MainValue = passEdit.getText().toString();
                ShowDialog();
                PassProfileApi(MainValue);

                dialog.dismiss();
                break;
        }
    }





    private void ShowDialog() {
        dialog = new PassCustomDialog(context, user, pass);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.show();
    }







    private void PassProfileApi(String phone)
    {
        ApiServices2 apiServices = RetrofitClientMore.getApiServices();
        Observable<PasswordServer> observable = apiServices.SendPassProfile(phone, user, pass);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PasswordServer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull PasswordServer passwordServer) {

                        new SharedPrefer(context).UpdateUser(false);
                        context.startActivity(new Intent(context, LoginActivity.class));

                        Toast.makeText(context, "done. Please login again", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(context, "Error: there is a wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }





}
