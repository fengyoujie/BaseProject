package com.fyj.testokhttp.base;

import java.util.Stack;

public class AppManager {
    private Stack<BaseActivity> mActivityStack;
    private static volatile AppManager mInstance;

    private AppManager() { }

    public static AppManager getInstance() {
        if (mInstance == null) {
            synchronized (AppManager.class) {
                if (mInstance == null) {
                    mInstance = new AppManager();
                }
            }
        }
        return mInstance;
    }

    public void addActivity(BaseActivity baseActivity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<BaseActivity>();
        }
        mActivityStack.push(baseActivity);
    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    public BaseActivity getCurrentActivity() {
        try {
            return mActivityStack.lastElement();
        } catch (Exception e) {
            return null;
        }
    }


    public void removeActivity(BaseActivity activity) {
        removeItem(activity);
    }

    public void finishActivity(BaseActivity activity) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
            removeItem(activity);
        }
    }

    private void removeItem(BaseActivity activity) {
        if (mActivityStack != null && !mActivityStack.isEmpty()) {
            mActivityStack.remove(activity);
        }
    }

    public void finishAllActivity() {
        if (mActivityStack != null && !mActivityStack.isEmpty()) {
            for (BaseActivity activity : mActivityStack) {
                activity.finish();
            }
            mActivityStack.clear();
        }
    }

    /**
     * 退出app
     */
    public void appExit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {

        }
    }
}
