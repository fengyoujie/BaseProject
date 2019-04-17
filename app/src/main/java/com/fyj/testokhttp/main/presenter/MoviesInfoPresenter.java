package com.fyj.testokhttp.main.presenter;

import android.util.Log;

import com.fyj.testokhttp.BaseSubscriber;
import com.fyj.testokhttp.LoadingSubscriber;
import com.fyj.testokhttp.main.contract.MainContract;
import com.google.gson.JsonObject;

import org.reactivestreams.Subscription;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MoviesInfoPresenter extends MainContract.Presenter {
    @Override
    public void requestMoviesInfo(HashMap<String, String> params) {
       Flowable<JsonObject> flowable = mModel.getMoviesInfo(params);
       flowable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new LoadingSubscriber<JsonObject>(true){
                        @Override
                        public void onSubscribe(Subscription s) {
                            super.onSubscribe(s);
                            s.request(2);
                        }

                        @Override
                        public void onINext(JsonObject responseBody) {
                            //super.onINext(responseBody);
                            mView.movieInfoResponse(responseBody);
                        }

                        @Override
                        public void onError(Throwable t) {
                            super.onError(t);
                            Log.i("fyj", t.getMessage());
                            mView.onLoadFailed(t.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            mView.onLoaded();
                            super.onComplete();
                        }
                });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }
}
