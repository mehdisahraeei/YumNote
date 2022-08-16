package com.mahdi.yumnote.other.SliderView;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;



public class CustomSliderView extends BaseSliderView {

    public CustomSliderView(Context context) {
        super(context);
    }


    public View getView() {

        View view = LayoutInflater.from(this.getContext()).inflate(com.daimajia.slider.library.R.layout.render_type_text, null);
        ImageView target = view.findViewById(com.daimajia.slider.library.R.id.daimajia_slider_image);
        LinearLayout frame = view.findViewById(com.daimajia.slider.library.R.id.description_layout);
        frame.setBackgroundColor(Color.TRANSPARENT);

        this.bindEventAndShow(view, target);

        return view;
    }



}