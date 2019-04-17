package com.fyj.testokhttp;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;

import retrofit2.HttpException;

/***
 * RxJava 请求的基类，对token 不存在和token超时进行分流处理，对返回多个JsonObject进行分类处理
 *
 * @param <T>
 */
public class BaseSubscriber<T> implements Subscriber<T>, ISubscriber<T> {
    private final static long EVENT_COUNT = 2l;
    private boolean mErrorFromNext = false ;
    private Subscription mSubScription = null ;
    @Override
    public void onSubscribe(Subscription s) {
        mSubScription = s ;
        s.request(EVENT_COUNT);
    }

    @Override
    public void onNext(T o) {
        try {
            mErrorFromNext = false ;
            if (o instanceof JsonObject) {
                //int status = ((JsonObject) o).get("state").getAsInt();
                int status = 5 ;
                switch (status) {
                    case ErrorCodeUtil.TOKEN_EXPIRED:
                        onTokenExpire();
                        break;
                    case ErrorCodeUtil.TOKEN_NOT_EXIST:
                    case ErrorCodeUtil.TOKEN_NEEDED:
                        onTokenNotExist();
                        break;
                    default:
                        onINext(o);
                }
                onINext(o);
            } else {
                mErrorFromNext = true ;
                onError(new Throwable("call back not JsonObject"));
            }//后续有其他的数据格式可以添加在此处处理
        }catch (Throwable throwable){
            mErrorFromNext = true ;
            onError(throwable);
        }
    }

    @Override
    public void onError(Throwable t) {
        if(!mErrorFromNext){
            //拦截后的错误处理。如果此处不处理，则由其子类来处理。
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onINext(T t) {

    }

    @Override
    public void onTokenExpire() {

    }

    @Override
    public void onTokenNotExist() {

    }

    public final String getErrorInfo(Throwable e){
        String info = "" ;
        if(e instanceof HttpException){
            return ExceptionReason.BAD_NETWORK;
        }
        if(e instanceof ConnectException ||
           e instanceof UnknownHostException||
           e instanceof SocketException){
            return ExceptionReason.CONNECT_ERROR ;
        }
        if(e instanceof InterruptedIOException){
            return ExceptionReason.CONNECT_TIMEOUT;
        }

        if(e instanceof JsonParseException ||
           e instanceof JSONException ||
           e instanceof ParseException ||
           e instanceof ClassCastException){
            return ExceptionReason.PARSE_ERROR ;
        }

        return ExceptionReason.UNKNOWN_ERROR ;
    }

    static class ExceptionReason{
        static final String PARSE_ERROR = "数据解析失败" ;
        static final String BAD_NETWORK = "网络问题" ;
        static final String CONNECT_ERROR = "连接错误" ;
        static final String CONNECT_TIMEOUT ="连接超时" ;
        static final String UNKNOWN_ERROR="未知错误" ;
    }

    public void cancelSubscrible(){
        if(mSubScription == null){
            return ;
        }
        mSubScription.cancel();
        mSubScription = null ;
    }
}
