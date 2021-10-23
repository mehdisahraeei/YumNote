package com.mahdi.yumnote.model.recyclerview;



public class PosterModel {


    private String id;
    public String photojson;



    public PosterModel(String id, String photojson) {
        this.id = id;
        this.photojson = photojson;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPhotojson() {
        return photojson;
    }

    public void setPhotojson(String photojson) {
        this.photojson = photojson;
    }


    @Override
    public String toString() {
        return "PosterModel{" +
                "id='" + id + '\'' +
                ", photojson='" + photojson + '\'' +
                '}';
    }



}
