package com.mahdi.yumnote.rx.main.fragments.note;



import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.recyclerview.PosterModel;
import com.mahdi.yumnote.networking.retrofit.api.ApiServices2;
import com.mahdi.yumnote.networking.retrofit.client.JsonClient;
import com.mahdi.yumnote.other.recyclerview.adapters.CustomAdabter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class JsonDisplayRx {



    private CustomAdabter adabter;
    private View view;
    private List<PosterModel> modelList;
    private RecyclerView recyclerView;


    @Inject
    public JsonDisplayRx() {
    }


    public JsonDisplayRx(View view) {
        this.view = view;
    }


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
                        adabter = new CustomAdabter(view.getContext(), modelList);
                        recyclerView = view.findViewById(R.id.recyclerview1);
                        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                        recyclerView.setAdapter(adabter);


                        Clicking();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(view.getContext(), "there is not connection. please connect to a network", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }





    public void Clicking()
    {
        adabter.setOnItemClickListener(new CustomAdabter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                switch (position)
                {
                    case 0:
                        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://login.wordpress.org")));
                        break;
                    case 1:
                        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.codechef.com")));
                        break;
                    case 2:
                        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.base64encode.org")));
                        break;

                    case 3:
                        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://developer.android.com")));
                        break;

                    case 4:
                        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://stackoverflow.com")));
                        break;

                }


            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }





}
