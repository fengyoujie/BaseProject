package com.fyj.testokhttp.utils;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fyj.testokhttp.R;
import com.fyj.testokhttp.base.BaseApp;

public class ToastUtil {
    private static Toast mToast;
    private static Toast mImgToast;

    private static Toast initToast(CharSequence message, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApp.getAppContext(), message, duration);
        } else {
            mToast.setText(message);
            mToast.setDuration(duration);
        }
        return mToast;
    }

    /**
     * show toast with short time
     */
    public static void showShort(CharSequence message) {
        initToast(message, Toast.LENGTH_SHORT).show();
    }

    /**
     * show toast with short time
     */
    public static void showShort(int strResId) {
        showShort(BaseApp.getAppResource().getString(strResId));
    }

    /**
     * show toast with long time
     */
    public static void showLong(CharSequence message) {
        initToast(message, Toast.LENGTH_LONG).show();
    }

    /**
     * show toast with long time
     */
    public static void showLong(int strResId) {
        showLong(BaseApp.getAppResource().getString(strResId));
    }

    public static void show(CharSequence message, int duration) {
        initToast(message, duration).show();
    }

    /**
     * 显示有image的toast
     * @param message
     * @param imgResId
     * @return
     */
    public static Toast showToastWithImg(CharSequence message, int imgResId) {
        if (mImgToast == null) {
            mImgToast = new Toast(BaseApp.getAppContext());
        }
        View view = LayoutInflater.from(BaseApp.getAppContext()).inflate(R.layout.toast_custom, null);
        TextView tv = view.findViewById(R.id.toast_custom_tv);
        tv.setText(TextUtils.isEmpty(message) ? "" : message);
        ImageView iv = view.findViewById(R.id.toast_custom_iv);

        if (imgResId > 0) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(imgResId);
        } else {
            iv.setVisibility(View.GONE);
        }

        mImgToast.setView(view);
        mImgToast.setGravity(Gravity.CENTER,0,0);
        mImgToast.show();
        return mImgToast;
    }
}
