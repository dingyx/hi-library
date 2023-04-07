package com.link.hi.library.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * @author dingyx
 * @description: 屏幕相关 util
 * @date: 2023/4/7
 */
public class HiDisplayUtil {

    /**
     * dp转px
     *
     * @param dp        dp
     * @param resources resource
     * @return px
     */
    public static int dp2px(float dp, Resources resources) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }


    /**
     * 获取屏幕宽度
     *
     * @param context context
     * @return 屏幕宽度
     */
    public static int getDisplayWithInPx(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            return size.x;
        }
        return 0;
    }


    /**
     * 获取屏幕高度
     *
     * @param context context
     * @return 屏幕高度
     */
    public static int getDisplayHeightInPx(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            return size.y;
        }
        return 0;
    }

}
