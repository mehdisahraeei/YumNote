package com.mahdi.yumnote.other.bottomsheet.Utils;


import android.content.Context;


public class DensityUtils {



    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }




    public float dip2Next(float dpValue) {
        return (dpValue * 10) + 0.5f;
    }


}