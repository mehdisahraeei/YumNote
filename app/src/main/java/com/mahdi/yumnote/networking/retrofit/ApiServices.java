package com.mahdi.yumnote.networking.retrofit;


import com.mahdi.yumnote.model.retrofit.LoginServer;
import com.mahdi.yumnote.model.retrofit.ProfileServer;
import com.mahdi.yumnote.model.retrofit.SignupServer;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;




public interface ApiServices {


    @FormUrlEncoded
    @POST("SignUp.php")
    Observable<SignupServer> SignUpDoing(@Field("user") String user, @Field("email") String email, @Field("pass") String pass);


    @FormUrlEncoded
    @POST("Login.php")
    Observable<LoginServer> LoginDoing(@Field("userLogin") String user, @Field("passLogin") String pass);


    @FormUrlEncoded
    @POST("profile_upload.php")
    Observable<ProfileServer> ProfileUpload(@Field("userProfile") String user, @Field("passProfile") String password);




}
