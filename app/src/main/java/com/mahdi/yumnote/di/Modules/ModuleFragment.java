package com.mahdi.yumnote.di.Modules;

import com.mahdi.yumnote.di.other.DefaultFragment;
import dagger.Module;
import dagger.Provides;



@Module
public class ModuleFragment {


    @Provides
    public DefaultFragment getFragments()
    {
        return new DefaultFragment();
    }



}
