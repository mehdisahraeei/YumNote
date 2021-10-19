package com.mahdi.yumnote.rx.main.fragments.note;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.recyclerview.PosterModel;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices2;
import com.mahdi.yumnote.networking.retrofit.client.JsonClient;
import com.mahdi.yumnote.other.recyclerview.adapters.CustomAdabter;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class JsonDisplayRx {


    private List<PosterModel> modelList;
    private RecyclerView recyclerView;



    public void jsoning(View view) {
        ApiServices2 api = JsonClient.getApiServices();
        Observable<List<PosterModel>> observable = api.getListAll();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<PosterModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<PosterModel> list) {
                        modelList = new ArrayList<>(list);
                        recyclerView = view.findViewById(R.id.recyclerview1);
                        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                        recyclerView.setAdapter(new CustomAdabter(view.getContext(), modelList));

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
