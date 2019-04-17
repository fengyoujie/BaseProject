package com.fyj.testokhttp.base;

public interface BaseView {
    void onLoaded();
    void onLoading(String title);
    void onLoadFailed(String error);
}
