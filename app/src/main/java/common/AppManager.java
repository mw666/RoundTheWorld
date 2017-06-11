package common;

import android.app.Activity;

import java.util.Stack;

/**
 * /**
 * Created by Administrator on 2016/1/18.
 * <p>
 * 统一activity的栈管理
 * <p>
 * 单例模式
 * <p>
 * 添加、删除、删除指定、清空栈、求栈的大小
 */
public class AppManager {

    public static AppManager appManager = null;

    private AppManager() {

    }

    public static AppManager getInstance() {
        if (appManager == null) {
            appManager = new AppManager();
        }
        return appManager;
    }

    private Stack<Activity> activityStack = new Stack<>();


    /**
     * 添加
     *
     * @param activity
     */
    public void addActivty(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 关闭指定activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        for (int i = activityStack.size() - 1; i >= 0; i--) {
            Activity activity1 = activityStack.get(i);
            if (activity1.getClass().equals(activity.getClass())) {
                activity.finish();
                activityStack.remove(activity1);
                break;
            }
        }
    }

    /**
     * 关闭当前activity
     */
    public void removeCurrent() {
        Activity activity = activityStack.lastElement();
        activity.finish();
        activityStack.remove(activity);
    }


    public void clear() {
        for (int i = activityStack.size() - 1; i >= 0; i--) {
            Activity activity1 = activityStack.get(i);
            activity1.finish();
        }
        activityStack.clear();
    }


    public int getSize() {
        return activityStack.size();
    }

}
