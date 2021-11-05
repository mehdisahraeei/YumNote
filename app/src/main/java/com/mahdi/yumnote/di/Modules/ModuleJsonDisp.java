package com.mahdi.yumnote.di.Modules;


import com.mahdi.yumnote.rx.main.fragments.note.JsonDisplayRx;
import dagger.Module;
import dagger.Provides;


@Module
public class ModuleJsonDisp {


    @Provides
    public JsonDisplayRx getJsonDisp()
    {
        return new JsonDisplayRx();
    }



}
