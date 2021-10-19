package com.mahdi.yumnote.model.retrofit.api1;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProfileImageServer {


    @SerializedName("id_Res")
    @Expose
    private int id_Res;


    @SerializedName("imageRes")
    @Expose
    private String imageRes;




//--------------------------------------------------------------------------

    @SerializedName("userImageP")
    @Expose
    private String userImageP;


    @SerializedName("passImageP")
    @Expose
    private String passImageP;


    @SerializedName("urlImageP")
    @Expose
    private String urlImageP;


    @SerializedName("imageImageP")
    @Expose
    private String imageImageP;


//--------------------------------------------------------------------------


    public ProfileImageServer(int id_Res, String imageRes, String userImageP, String passImageP, String imageImageP, String urlImageP) {
        this.id_Res = id_Res;
        this.imageRes = imageRes;
        this.userImageP = userImageP;
        this.passImageP = passImageP;
        this.imageImageP = imageImageP;
        this.urlImageP = urlImageP;
    }


    public int getId_Res() {
        return id_Res;
    }

    public void setId_Res(int id_Res) {
        this.id_Res = id_Res;
    }

    public String getImageRes() {
        return imageRes;
    }

    public void setImageRes(String imageRes) {
        this.imageRes = imageRes;
    }

    public String getUserImageP() {
        return userImageP;
    }

    public void setUserImageP(String userImageP) {
        this.userImageP = userImageP;
    }

    public String getPassImageP() {
        return passImageP;
    }

    public void setPassImageP(String passImageP) {
        this.passImageP = passImageP;
    }

    public String getImageImageP() {
        return imageImageP;
    }

    public void setImageImageP(String imageImageP) {
        this.imageImageP = imageImageP;
    }

    public String getUrlImageP() {
        return urlImageP;
    }

    public void setUrlImageP(String urlImageP) {
        this.urlImageP = urlImageP;
    }


}
