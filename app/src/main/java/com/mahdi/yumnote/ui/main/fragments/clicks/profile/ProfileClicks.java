package com.mahdi.yumnote.ui.main.fragments.clicks.profile;



import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.mahdi.yumnote.model.retrofit.PhoneServer;
import com.mahdi.yumnote.model.retrofit.ProfileServer;
import com.mahdi.yumnote.networking.retrofit.ApiServices;
import com.mahdi.yumnote.networking.retrofit.RetrofitClient;
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

        ApiServices apiServices = RetrofitClient.getApiServices();

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

        Toast.makeText(context, "soon", Toast.LENGTH_SHORT).show();

        /*
        ApiServices apiServices = RetrofitClient.getApiServices();
        Observable<PasswordServer> observable = apiServices.ProfilePassword("333",user,pass);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PasswordServer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull PasswordServer passwordServer) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        context.startActivity(new Intent(context,LoginActivity.class));
                    }
                });

*/
    }


    public void ClickEmail() {


        ApiServices apiServices = RetrofitClient.getApiServices();

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

        ApiServices apiServices = RetrofitClient.getApiServices();
        Observable<PhoneServer> observable = apiServices.SendPhoneProfile("*******", user, pass);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhoneServer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull PhoneServer phoneServer) {
                        Log.i("ok", "ok");
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
