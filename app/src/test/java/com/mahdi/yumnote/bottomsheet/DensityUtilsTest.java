package com.mahdi.yumnote.bottomsheet;


import static org.junit.Assert.assertEquals;
import com.mahdi.yumnote.other.bottomsheet.Utils.DensityUtils;
import org.junit.Test;


public class DensityUtilsTest {


    private DensityUtils utils;


    public DensityUtilsTest() {
        utils = new DensityUtils();
    }


    @Test
    public void dip2pxTest() {
        assertEquals(utils.dip2Next(10), 100, 0.5);
    }


}
