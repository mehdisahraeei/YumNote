package com.mahdi.yumnote.other.SliderView;



import android.os.Bundle;
import android.view.View;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.mahdi.yumnote.R;
import java.util.HashMap;



public class Slider implements ViewPagerEx.OnPageChangeListener, BaseSliderView.OnSliderClickListener {


    private SliderLayout mDemoSlider;



    public void Run(View view)
    {

        mDemoSlider = view.findViewById(R.id.slider);

        HashMap<String, String> file_maps = new HashMap<>();

        file_maps.put("1", "http://10.0.2.2/yumnote/photos/slide1.png");
        file_maps.put("2", "http://10.0.2.2/yumnote/photos/slide2.png");
        file_maps.put("3", "http://10.0.2.2/yumnote/photos/slide3.png");
        file_maps.put("4", "http://10.0.2.2/yumnote/photos/slide4.png");
        file_maps.put("5", "http://10.0.2.2/yumnote/photos/slide5.png");



        for (String name : file_maps.keySet()) {
            CustomSliderView SliderView = new CustomSliderView(view.getContext());

            SliderView
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this)
                    .setOnSliderClickListener(this);


            SliderView.bundle(new Bundle());
            SliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(SliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(3000);
        mDemoSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }


}
