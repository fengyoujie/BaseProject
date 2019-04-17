package com.fyj.testokhttp;

import com.fyj.testokhttp.base.AppManager;
import com.fyj.testokhttp.base.BaseActivity;

import org.reactivestreams.Subscription;

//请求时确定是否显示Loading
public class LoadingSubscriber<T> extends BaseSubscriber<T> {
    private boolean mIsShowLoading = false;

    public LoadingSubscriber() {
    }

    public LoadingSubscriber(boolean showLoading) {
        this.mIsShowLoading = showLoading;
    }

    @Override
    public void onSubscribe(Subscription s) {
        super.onSubscribe(s);
        showLoading();
    }

    @Override
    public void onError(Throwable t) {
        super.onError(t);
        dismissLoading();
    }

    @Override
    public void onComplete() {
        super.onComplete();
        dismissLoading();
    }

    @Override
    public void onINext(T t) {
        super.onINext(t);
    }

    @Override
    public void onTokenExpire() {
        super.onTokenExpire();
        dismissLoading();
    }

    @Override
    public void onTokenNotExist() {
        super.onTokenNotExist();
        dismissLoading();
    }

    @Override
    public void cancelSubscrible() {
        super.cancelSubscrible();
        dismissLoading();
    }

    protected void dismissLoading() {
        //dismiss loading
        BaseActivity activity = AppManager.getInstance().getCurrentActivity();
        if (activity != null) {
            activity.dismissLoadingDialog();
        }
    }

    protected void showLoading() {
        if (mIsShowLoading) {
            BaseActivity activity = AppManager.getInstance().getCurrentActivity();
            if (activity != null) {
                activity.showLoadingDialog();
            }
        }
    }
}
