package com.mahdi.yumnote.networking.retrofit.api;

import com.mahdi.yumnote.model.recyclerview.PosterModel;


import java.util.List;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;


public interface ApiServices2 {


    @GET("tickets.json")
    Observable<List<PosterModel>> getListAll();


}
