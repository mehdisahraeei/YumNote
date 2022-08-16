package com.mahdi.yumnote.di.component;


import com.mahdi.yumnote.other.SliderView.Slider;
import com.mahdi.yumnote.other.bottomnavigation.BottomNavigation;
import com.mahdi.yumnote.rx.main.fragments.note.JsonDisplayRx;
import com.mahdi.yumnote.rx.main.fragments.profile.ImageUploadRx;
import com.mahdi.yumnote.rx.main.fragments.profile.ShowValueRx;
import com.mahdi.yumnote.di.other.DefaultFragment;
import dagger.Component;


@Component
//@Component(modules = {ModuleFragment.class, ModuleNavigation.class , other Classmodules})
public interface AppComponent {


//------------MainActivity---------------
    DefaultFragment getInject();
    BottomNavigation getNavigation();


//------------NoteFragment---------------
    Slider getSlider();
    JsonDisplayRx getJsonRx();


//------------ProfileFragment------------
    ShowValueRx getShowValueRx();
    ImageUploadRx getImageUploadRx();



}
