package com.mahdi.yumnote.ui.main.fragments;




import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.FragmentProfileBinding;
import com.mahdi.yumnote.other.dialog.PhoneCustomDialog;
import com.mahdi.yumnote.other.sharedpreferences.SharedPrefer;
import com.mahdi.yumnote.rx.main.fragments.profile.ImageUploadRx;
import com.mahdi.yumnote.rx.main.fragments.profile.ShowValueRx;
import com.mahdi.yumnote.ui.main.fragments.clicks.profile.ProfileClicks;
import com.mahdi.yumnote.ui.main.fragments.clicks.profile.ProfileHelper;
import java.io.IOException;





public class ProfileFragment extends Fragment {


    private Bitmap bitmap;
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


        binding.setProfileClick(new ProfileClicks(user, pass, view.getContext()));


        binding.setProfileClickHelper(new ProfileHelper() {
            @Override
            public void ClickProfileImage(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                resultLauncher.launch(intent);


                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("are you sure to change it?");

                builder.setNegativeButton("Nope",null);
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new ImageUploadRx().Uploading(bitmap, user, pass);
                    }
                });

                builder.show();

            }
        });




        new ShowValueRx().Showing(view, user, pass);
        new ImageUploadRx().Fetching(view, user, pass);

        new PhoneCustomDialog(view.getContext(),user,pass);

        return view;
    }





    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent intent = result.getData();
                Uri uri = intent.getData();

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    });






    @Override
    public void onResume() {
        super.onResume();

        handler.postDelayed(runnable = new Runnable() {
            public void run() {


                new ImageUploadRx().Fetching(view, user, pass);
                new ShowValueRx().Showing(view, user, pass);

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