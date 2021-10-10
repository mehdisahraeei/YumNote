package com.mahdi.yumnote.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mahdi.yumnote.R;
import com.mahdi.yumnote.databinding.FragmentImageBinding;

public class ImageFragment extends Fragment {

    private FragmentImageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image,null,false);
        return binding.getRoot();
    }
}