package com.gxx.textlayoutapplication.weiget;

import android.content.Context;
import android.content.res.Resources;

/**
 * 创建时间: 2018/7/13
 * 创建人: GaoXiaoXiong
 * 功能描述:像素相关，获取Android屏幕宽度，dp跟px互转
 */
public class DensityUtil {
    public  float density;
    private static DensityUtil densityUtil;

    public static DensityUtil getInstance(){
        if (densityUtil==null){
            densityUtil = new DensityUtil();
        }
        return densityUtil;
    }

    public DensityUtil() {
        density = Resources.getSystem().getDisplayMetrics().density;
    }



    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * @param dpValue 虚拟像素
     * @return 像素
     * 你传入的是DP
     */
    public  int dip2px(float dpValue) {
        return (int) (0.5f + dpValue * density);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     * @param pxValue 像素
     * @return 虚拟像素
     */
    public  float px2dip(int pxValue) {
        return (pxValue / density + 0.5f);
    }


    /**
     * 将sp值转换为px值，保证文字大小不变
     * @param spValue
     * 你传入的是SP
     */
    public  int sp2px(float spValue) {
        return (int) (spValue * density + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public  int px2sp(float pxValue) {
        return (int) (pxValue / density + 0.5f);
    }


    /**
     * @date :2019/11/27 0027
     * @author : gaoxiaoxiong
     * @description:返回类型为float，
     **/
    public float getDimension(Context context, int id){
        return context.getResources().getDimension(id);
    }

    /**
     * @date :2019/11/27 0027
     * @author : gaoxiaoxiong
     * @description:由浮点型转成整型时，采用四舍五入原则。
     **/
    public int getDimensionPixelSize(Context context,int id){
        return context.getResources().getDimensionPixelSize(id);
    }

    /**
     * @date :2019/11/27 0027
     * @author : gaoxiaoxiong
     * @description:由浮点型转成整型时，原则是忽略小数点部分。
     **/
    public int getDimensionPixelOffset(Context context,int id){
        return context.getResources().getDimensionPixelOffset(id);
    }

}