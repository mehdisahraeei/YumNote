package com.mahdi.yumnote.di.Modules;


import com.mahdi.yumnote.other.bottomnavigation.BottomNavigation;
import dagger.Module;
import dagger.Provides;


@Module
public class ModuleNavigation {


    @Provides
    public BottomNavigation getNavigation()
    {
        return new BottomNavigation();
    }



}
