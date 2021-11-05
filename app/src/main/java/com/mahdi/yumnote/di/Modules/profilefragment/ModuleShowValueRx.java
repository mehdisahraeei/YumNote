package com.mahdi.yumnote.di.Modules.profilefragment;


import com.mahdi.yumnote.rx.main.fragments.profile.ShowValueRx;
import dagger.Module;
import dagger.Provides;


@Module
public class ModuleShowValueRx {


    @Provides
    public ShowValueRx getShowValueRx()
    {
        return new ShowValueRx();
    }



}
