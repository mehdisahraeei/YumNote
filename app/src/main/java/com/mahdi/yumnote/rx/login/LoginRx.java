package com.mahdi.yumnote.rx.login;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.mahdi.yumnote.model.retrofit.api1.LoginServer;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices1;
import com.mahdi.yumnote.networking.retrofit.client.RetrofitClient;
import com.mahdi.yumnote.other.sharedpreferences.SharedPrefer;
import com.mahdi.yumnote.ui.main.activity.MainActivity;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;




public class LoginRx {



    private SharedPrefer sharedPrefer;
    private Observable<LoginServer> observable;




    public void Submit(Context context, String user, String pass) {


        ApiServices1 apiServices = RetrofitClient.getApiServices();

        observable = apiServices.LoginDoing(user, pass);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginServer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LoginServer loginServer) {
                        //next
                        if (loginServer.getIsSuccess() == 1) {

                            sharedPrefer = new SharedPrefer(context);
                            sharedPrefer.UpdateUser(true);
                            sharedPrefer.UserContents(user, pass);

                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                            ((Activity) context).finish();


                        } else {
                            Toast.makeText(context, "entered Values are wrong. try again", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(context, "entered Values are wrong. try again", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }






}
