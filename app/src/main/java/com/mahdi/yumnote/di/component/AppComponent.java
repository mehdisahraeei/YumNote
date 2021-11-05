package com.mahdi.yumnote.di.component;


import com.mahdi.yumnote.di.Modules.ModuleFragment;
import com.mahdi.yumnote.di.Modules.ModuleNavigation;
import com.mahdi.yumnote.di.other.DefaultFragment;
import com.mahdi.yumnote.other.bottomnavigation.BottomNavigation;
import dagger.Component;



@Component(modules = {ModuleFragment.class, ModuleNavigation.class})
public interface AppComponent {


    DefaultFragment getInject();

    BottomNavigation getNavigation();

}
