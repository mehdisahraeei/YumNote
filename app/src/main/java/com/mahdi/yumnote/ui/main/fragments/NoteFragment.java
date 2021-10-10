package com.mahdi.yumnote.ui.main.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.FragmentNoteBinding;

public class NoteFragment extends Fragment {

    private FragmentNoteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_note,null,false);
        return binding.getRoot();
    }
}