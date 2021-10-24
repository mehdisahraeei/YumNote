package com.mahdi.yumnote.other.bottomnavigation;


import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.felix.bottomnavygation.BottomNav;
import com.felix.bottomnavygation.ItemNav;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.ui.main.fragments.NoteFragment;
import com.mahdi.yumnote.ui.main.fragments.ProfileFragment;



public class BottomNavigation {



    private BottomNav bottomNav;
    private static BottomNavigation object = null;



    private BottomNavigation() {
    }




    public static BottomNavigation getInstance() {
        if (object == null) {
            object = new BottomNavigation();
        }
        return object;
    }






    public void BottomMethod(View view, Context context, FragmentManager fragmentManager) {

        bottomNav = view.findViewById(R.id.bottomNav);

        bottomNav.addItemNav(new ItemNav(context, R.drawable.note).addColorAtive(R.color.blue));
        bottomNav.addItemNav(new ItemNav(context, R.drawable.setting).addColorAtive(R.color.blue));
        bottomNav.build();


        bottomNav.setTabSelectedListener(new BottomNav.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int i) {
                if (i == 0) {
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.frame1, new NoteFragment());
                    ft.commit();
                } else if (i == 1) {
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.frame1, new ProfileFragment());
                    ft.commit();
                }
            }

            @Override
            public void onTabLongSelected(int i) {

            }
        });

    }






}
