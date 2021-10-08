package com.mahdi.yumnote.rx.login;


import android.util.Log;
import com.mahdi.yumnote.model.retrofit.LoginServer;
import com.mahdi.yumnote.networking.retrofit.ApiServices;
import com.mahdi.yumnote.networking.retrofit.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class LoginRx {


    private Observable<LoginServer> observable;




    public void Submit(String user, String pass) {

        ApiServices apiServices = RetrofitClient.getApiServices();

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
                            Log.i("runYum","ok");

                        } else {
                            Log.i("runYum","false");
                        }
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
