package com.mahdi.yumnote.di.other;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.ui.main.fragments.ImageFragment;
import javax.inject.Inject;




public class DefaultFragment {

    @Inject
    public DefaultFragment() {
    }


    public void RunFragmnt(FragmentManager fragmentManager) {
        //default
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame1, new ImageFragment());
        ft.commit();
    }


}
