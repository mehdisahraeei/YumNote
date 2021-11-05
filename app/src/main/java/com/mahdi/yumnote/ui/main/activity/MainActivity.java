package com.mahdi.yumnote.ui.main.activity;




import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.ActivityMainBinding;
import com.mahdi.yumnote.di.component.AppComponent;
import com.mahdi.yumnote.di.component.DaggerAppComponent;




public class MainActivity extends AppCompatActivity {


    private FragmentManager fragmentManager = getSupportFragmentManager();
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//--------------------------------------------------------------------------------------
        View view = getWindow().getDecorView().getRootView();
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//--------------------------------------------------------------------------------------



        AppComponent component = DaggerAppComponent.create();

        component.getInject().RunFragmnt(fragmentManager);
        component.getNavigation().BottomMethod(view,
                this, fragmentManager);


    }



    
    @Override
    public void onBackPressed() {
    }


}
