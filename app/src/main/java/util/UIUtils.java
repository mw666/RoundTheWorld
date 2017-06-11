package util;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import cn.itcast.wh.p2pmoney14.common.MyApplication;

/**
 * Created by Administrator on 2016/1/17.
 */
public class UIUtils {

    /**
     * 将xml转换成view对象
     * @param resId
     * @return
     */
    public static View getXmlView(int resId){
        return View.inflate(getContext(),resId,null);
    }

    /**
     * 1dp=1px;
     * 1dp=0.5px;
     * 1dp=0.75px;
     * 1dp=1.5px;
     *
     * @param dp
     * @return
     */
    public static int dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }

    public static int px2dp(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }


    /**
     * 获取字符串数组
     *
     * @param arrId
     * @return
     */
    public static String[] getStringArr(int arrId) {
        return getContext().getResources().getStringArray(arrId);
    }


    /**
     * 获取颜色
     *
     * @param colorId
     * @return
     */
    public static int getColor(int colorId) {
        return getContext().getResources().getColor(colorId);
    }

    /**
     * 保证任务是运行在主线程当中的
     *
     * @param runnable
     */
    public void runOnMainThread(Runnable runnable) {
        //当前线程id
        int tid = android.os.Process.myTid();
        if (tid == MyApplication.mainThreadId) {
            runnable.run();
        } else {
            getHandler().post(runnable);
        }
    }

    private static Context getContext() {
        return MyApplication.context;
    }


    private Handler getHandler() {
        return MyApplication.handler;
    }
}
