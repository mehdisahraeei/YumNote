package com.mahdi.yumnote.networking.retrofit;


import com.mahdi.yumnote.model.retrofit.LoginServer;
import com.mahdi.yumnote.model.retrofit.PhoneServer;
import com.mahdi.yumnote.model.retrofit.ProfileImageServer;
import com.mahdi.yumnote.model.retrofit.ProfileServer;
import com.mahdi.yumnote.model.retrofit.SignupServer;
import com.mahdi.yumnote.model.retrofit.photoServer;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;




public interface ApiServices {


    //about sign up
    @FormUrlEncoded
    @POST("SignUp.php")
    Observable<SignupServer> SignUpDoing(@Field("userSignUp") String user, @Field("emailSignUp") String email, @Field("passSignUp") String pass);


    //about Log in
    @FormUrlEncoded
    @POST("Login.php")
    Observable<LoginServer> LoginDoing(@Field("userLogin") String user, @Field("passLogin") String pass);


    //about sent , received profile values
    @FormUrlEncoded
    @POST("profile_upload.php")
    Observable<ProfileServer> ProfileUpload(@Field("userProfile") String user, @Field("passProfile") String password);


    //about sent of image
    @FormUrlEncoded
    @POST("SendImageProfile.php")
    Observable<ProfileImageServer> SendImageProfile(@Field("urlImageP") String url, @Field("imageImageP") String image , @Field("userImageP") String user, @Field("passImageP") String password);


    //about received of image
    @FormUrlEncoded
    @POST("ReceivedProfilephoto.php")
    Observable<photoServer> ReceivedProfilephoto(@Field("userimg") String user, @Field("passimg") String password);


    //about sent , received of phone
    @FormUrlEncoded
    @POST("SendPhoneProfile.php")
    Observable<PhoneServer> SendPhoneProfile(@Field("phoneP") String phone , @Field("userPhone") String user, @Field("passPhone") String password);



//    @FormUrlEncoded
//    @POST("")
//    Observable<PasswordServer> ProfilePassword(@Field("Passnew") String email , @Field("userPa") String user, @Field("passPa") String password);



}
