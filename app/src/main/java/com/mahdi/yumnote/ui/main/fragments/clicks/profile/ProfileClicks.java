package com.mahdi.yumnote.ui.main.fragments.clicks.profile;



import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.Toast;
import com.mahdi.yumnote.model.retrofit.api1.ProfileServer;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices1;
import com.mahdi.yumnote.networking.retrofit.client.RetrofitClient;
import com.mahdi.yumnote.other.dialog.PassCustomDialog;
import com.mahdi.yumnote.other.dialog.PhoneCustomDialog;
import com.mahdi.yumnote.other.sharedpreferences.SharedPrefer;
import com.mahdi.yumnote.ui.login.LoginActivity;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class ProfileClicks {


    private String user, pass;
    private Context context;




    public ProfileClicks(String user, String pass, Context context) {
        this.user = user;
        this.pass = pass;
        this.context = context;
    }



    public void ClickUser() {

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

                        ClipData clip;
                        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        clip = ClipData.newPlainText("username", username);
                        clipboard.setPrimaryClip(clip);

                        Toast.makeText(context, "the text copied in clipboard", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {


                    }
                });
    }






    public void ClickPass() {
        PassCustomDialog dialog = new PassCustomDialog(context, user, pass);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }




    public void ClickEmail() {


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

                        String email = profileModel.getEmailResponse();

                        ClipData clip;
                        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        clip = ClipData.newPlainText("email", email);
                        clipboard.setPrimaryClip(clip);

                        Toast.makeText(context, "the text copied in clipboard", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {


                    }
                });
    }





    public void ClickPhone() {
        PhoneCustomDialog dialog = new PhoneCustomDialog(context, user, pass);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }




    public void ClickLogout()
    {
        new SharedPrefer(context).UpdateUser(false);
        context.startActivity(new Intent(context, LoginActivity.class));
    }



}




