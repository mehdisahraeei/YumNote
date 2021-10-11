package com.mahdi.yumnote.ui.main.fragments;



import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.FragmentProfileBinding;
import com.mahdi.yumnote.other.sharedpreferences.SharedPrefer;
import com.mahdi.yumnote.rx.main.fragments.profile.ShowValueRx;




public class ProfileFragment extends Fragment {

    private Handler handler = new Handler();
    private int apiDelayed = 1000; //every 1 second = 1000 milisecond
    private Runnable runnable;
    private String user, pass;
    private SharedPrefer preferences;
    private FragmentProfileBinding binding;
    private View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//--------------------------------------------------------------------------------------
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, null, false);
        view = binding.getRoot();



        preferences = new SharedPrefer(view.getContext());

        user = preferences.ValueUser();
        pass = preferences.ValuePass();
//--------------------------------------------------------------------------------------


        new ShowValueRx().Showing(view,user,pass);

        return view;

    }







    @Override
    public void onResume() {
        super.onResume();

        handler.postDelayed(runnable = new Runnable() {
            public void run() {

                new ShowValueRx().Showing(view,user,pass);

            handler.postDelayed(runnable, apiDelayed);
            }
        }, apiDelayed);
    }




    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable); //stop handler when activity not visible
    }


}