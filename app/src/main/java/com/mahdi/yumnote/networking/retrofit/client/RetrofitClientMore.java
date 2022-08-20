package com.mahdi.yumnote.networking.retrofit.client;


import com.mahdi.yumnote.BuildConfig;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices2;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClientMore {

    private static Retrofit retrofit = null;
    private static final String url = BuildConfig.SERVER2;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }




    public static ApiServices2 getApiServices()
    {
        return getInstance().create(ApiServices2.class);
    }


}
