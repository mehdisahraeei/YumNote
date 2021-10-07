package com.mahdi.yumnote.networking.retrofit;


import com.mahdi.yumnote.model.retrofit.SignupServer;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



public interface ApiServices {






    @FormUrlEncoded
    @POST("SignUp.php")
    Observable<SignupServer> upload(@Field("user") String user, @Field("email") String email, @Field("pass") String pass);





}
