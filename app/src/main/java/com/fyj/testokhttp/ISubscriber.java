package com.fyj.testokhttp;

public interface ISubscriber<T> {
    //返回成功
    void onINext(T t);
    //token  过期
    void onTokenExpire();
    //token 不存在
    void onTokenNotExist();
}
