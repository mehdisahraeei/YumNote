package com.mahdi.yumnote.rx.signup;



import android.view.View;
import android.widget.Toast;
import com.mahdi.yumnote.model.retrofit.api1.SignupServer;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices1;
import com.mahdi.yumnote.networking.retrofit.client.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class SignupRx {


    private Observable<SignupServer> observable;
    private View view;


    public SignupRx(View view) {
        this.view = view;
    }

    public void Submit(String user , String email , String pass , String confirm ) {

        ApiServices1 apiServices = RetrofitClient.getApiServices();
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
                        Toast.makeText(view.getContext(), "Data was saved. Thank you", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        if (pass!=confirm)
                        {
                            Toast.makeText(view.getContext(), "Passwrod Confirmation is fault", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



}
