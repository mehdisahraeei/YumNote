package com.mahdi.yumnote.ui.main.fragments;



import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.FragmentNoteBinding;
import com.mahdi.yumnote.di.component.AppComponent;
import com.mahdi.yumnote.di.component.DaggerAppComponent;
import com.mahdi.yumnote.ui.main.fragments.clicks.note.NoteClicks;




public class NoteFragment extends Fragment {


    private View view;
    private FragmentNoteBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//--------------------------------------------------------------------------------------
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_note,null,false);
        view = binding.getRoot();
        binding.setNoteClick(new NoteClicks(view.getContext()));
//--------------------------------------------------------------------------------------


        AppComponent component = DaggerAppComponent.create();

        component.getSlider().Run(view);
        component.getJsonRx().jsoning(view);

        return view;
    }



}