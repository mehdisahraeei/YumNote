package com.mahdi.yumnote.ui.main.fragments;



import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.FragmentProfileBinding;
import com.mahdi.yumnote.model.retrofit.ProfileServer;
import com.mahdi.yumnote.networking.retrofit.ApiServices;
import com.mahdi.yumnote.networking.retrofit.RetrofitClient;
import com.mahdi.yumnote.other.sharedpreferences.SharedPrefer;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;




public class ProfileFragment extends Fragment {

    private Handler handler = new Handler();
    private int apiDelayed = 1000; //every 1 second = 1000 milisecond
    private Runnable runnable;
    private ApiServices apiServices;
    private TextView userDisplay,passDisplay,emailDisplay,phoneDisplay;
    private String user, pass;
    private SharedPrefer preferences;
    private FragmentProfileBinding binding;
    private View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//--------------------------------------------------------------------------------------
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, null, false);
        view = binding.getRoot();

        userDisplay = view.findViewById(R.id.obj1);
        passDisplay = view.findViewById(R.id.obj2);
        emailDisplay = view.findViewById(R.id.obj3);
        phoneDisplay = view.findViewById(R.id.obj4);




        apiServices = RetrofitClient.getApiServices();
        preferences = new SharedPrefer(view.getContext());

        user = preferences.ValueUser();
        pass = preferences.ValuePass();
//--------------------------------------------------------------------------------------


        pulling();

        return view;

    }



    private void pulling() {

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
                        int phone = profileModel.getPhoneResponse();

                        userDisplay.setText(username);
                        passDisplay.setText(password);
                        emailDisplay.setText(email);
                        phoneDisplay.setText(String.valueOf(phone));

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("cas", e.toString());
                    }

                    @Override
                    public void onComplete() {


                    }
                });

    }





    @Override
    public void onResume() {
        super.onResume();

        handler.postDelayed(runnable = new Runnable() {
            public void run() {

                pulling();
            handler.postDelayed(runnable, apiDelayed);
            }
        }, apiDelayed);
    }




    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable); //stop handler when activity not visible
    }


}