package com.mahdi.yumnote.rx.main.fragments.profile;



import android.view.View;
import android.widget.TextView;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.retrofit.api1.ProfileServer;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices1;
import com.mahdi.yumnote.networking.retrofit.client.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;




public class ShowValueRx {



    private TextView userDisplay,passDisplay,emailDisplay,phoneDisplay;




    public void Showing(View view, String user, String pass) {


//--------------------casting-------------------------------
        userDisplay = view.findViewById(R.id.obj1);
        passDisplay = view.findViewById(R.id.obj2);
        emailDisplay = view.findViewById(R.id.obj3);
        phoneDisplay = view.findViewById(R.id.obj4);
//----------------------------------------------------------


        ApiServices1 apiServices = RetrofitClient.getApiServices();

        Observable<ProfileServer> observable = apiServices.ProfileUpload(user, pass);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProfileServer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ProfileServer profileModel) {

                        String username = profileModel.getUserResponse();
                        String password = profileModel.getPasswordResponse();
                        String email = profileModel.getEmailResponse();
                        String phone = profileModel.getPhoneResponse();



                        try {

                            userDisplay.setText(username);
                            passDisplay.setText(password);
                            emailDisplay.setText(email);
                            phoneDisplay.setText(phone);


                        }catch (Exception e){}


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
