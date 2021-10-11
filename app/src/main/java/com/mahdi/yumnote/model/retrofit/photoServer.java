package com.mahdi.yumnote.model.retrofit;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class photoServer {


    @SerializedName("id_img")
    @Expose
    private int id_img;


    @SerializedName("imageimg")
    @Expose
    private String imageimg;



//--------------------------------------------------------------------------

    @SerializedName("userimg")
    @Expose
    private String userimg;


    @SerializedName("passimg")
    @Expose
    private String passimg;


    public photoServer(int id_img, String imageimg, String userimg, String passimg) {
        this.id_img = id_img;
        this.imageimg = imageimg;
        this.userimg = userimg;
        this.passimg = passimg;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    public String getImageimg() {
        return imageimg;
    }

    public void setImageimg(String imageimg) {
        this.imageimg = imageimg;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getPassimg() {
        return passimg;
    }

    public void setPassimg(String passimg) {
        this.passimg = passimg;
    }


}
