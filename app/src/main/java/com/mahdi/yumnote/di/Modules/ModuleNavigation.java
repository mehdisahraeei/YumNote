package com.mahdi.yumnote.di.Modules;

import com.mahdi.yumnote.di.other.DefaultFragment;
import com.mahdi.yumnote.other.bottomnavigation.BottomNavigation;

import dagger.Module;
import dagger.Provides;


@Module
public class ModuleNavigation {


    @Provides
    public BottomNavigation getFragments()
    {
        return new BottomNavigation();
    }



}
