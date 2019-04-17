package com.fyj.testokhttp.base;

import android.content.Context;

public abstract class BasePresenter<M,V> {
    public Context mContext ;
    protected M mModel ;
    protected V mView ;

    public void setVM(V v,M m){
        mModel = m;
        mView = v ;
        onStart();
    }

    abstract public void onStart();
    abstract public void onDestroy();
}
