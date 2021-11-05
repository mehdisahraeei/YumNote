package com.mahdi.yumnote.networking.retrofit.api;



import com.mahdi.yumnote.model.recyclerview.PosterModel;
import com.mahdi.yumnote.model.retrofit.api2.PasswordServer;
import java.util.List;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface ApiServices2 {


    @GET("tickets.json")
    Observable<List<PosterModel>> getListAll();


    //about sent , received of phone
    @FormUrlEncoded
    @POST("SendPasswordProfile.php")
    Observable<PasswordServer> SendPassProfile(@Field("PasswordProfile") String phone , @Field("UserProfile") String user, @Field("PassProfile") String password);



}
