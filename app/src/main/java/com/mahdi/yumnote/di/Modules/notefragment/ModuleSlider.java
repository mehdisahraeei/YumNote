package com.mahdi.yumnote.di.Modules.notefragment;


import com.mahdi.yumnote.other.SliderView.Slider;
import dagger.Module;
import dagger.Provides;

@Module
public class ModuleSlider {


    @Provides
    public Slider getSlider()
    {
        return new Slider();
    }



}
