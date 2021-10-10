package com.mahdi.yumnote.di.component;


import com.mahdi.yumnote.di.Modules.ModuleFragment;
import com.mahdi.yumnote.di.other.DefaultFragment;
import dagger.Component;



@Component(modules = ModuleFragment.class)
public interface AppComponent {


    DefaultFragment getInject();


}
