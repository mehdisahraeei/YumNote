package com.mahdi.yumnote.other.dialog;



import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.retrofit.api1.PhoneServer;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices1;
import com.mahdi.yumnote.networking.retrofit.client.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class PhoneCustomDialog extends Dialog implements View.OnClickListener {


    private String user, pass;
    private String MainValue;
    private Context context;
    private Dialog dialog;
    private ImageView submit;
    private EditText phoneEdit;



    public PhoneCustomDialog(@androidx.annotation.NonNull Context context, String user, String pass) {
        super(context);
        this.user = user;
        this.pass = pass;
    }



    public PhoneCustomDialog(Context context) {
        super(context);
        this.context = context;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_dialog);

//-------------------------------------------------------------------------
        submit = findViewById(R.id.image_phone_dialog);
        phoneEdit = findViewById(R.id.edit_phone_dialog);


        submit.setOnClickListener(this);
//-------------------------------------------------------------------------


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_phone_dialog:

                MainValue =phoneEdit.getText().toString();

                ShowDialog();
                SendPhoneProfile(MainValue);
                dialog.dismiss();
                break;
        }
    }




    private void ShowDialog() {

        dialog = new PhoneCustomDialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.show();
    }



    private void SendPhoneProfile(String s)
    {

        ApiServices1 apiServices = RetrofitClient.getApiServices();
        Observable<PhoneServer> observable = apiServices.SendPhoneProfile(s, user, pass);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhoneServer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }


                    @Override
                    public void onNext(PhoneServer phoneServer) {
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }




}
