package com.mahdi.yumnote.rx.signup;


import com.mahdi.yumnote.model.retrofit.SignupServer;
import com.mahdi.yumnote.networking.retrofit.ApiServices;
import com.mahdi.yumnote.networking.retrofit.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class SignupRx {

    private Observable<SignupServer> observable;




    public void Submit(String user , String email , String pass , String confirm ) {

        ApiServices apiServices = RetrofitClient.getApiServices();

        observable = apiServices.SignUpDoing(user,email,pass);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SignupServer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SignupServer signupServer) {
                        //----ok----
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
