package com.mahdi.yumnote.di.Modules.profilefragment;



import com.mahdi.yumnote.rx.main.fragments.profile.ImageUploadRx;
import dagger.Module;
import dagger.Provides;



@Module
public class ModuleImageUploadRx {


    @Provides
    public ImageUploadRx getShowValueRx()
    {
        return new ImageUploadRx();
    }



}
