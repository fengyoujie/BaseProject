package com.fyj.testokhttp.main.contract;

import com.fyj.testokhttp.base.BaseModel;
import com.fyj.testokhttp.base.BasePresenter;
import com.fyj.testokhttp.base.BaseView;
import com.google.gson.JsonObject;

import java.util.HashMap;

import io.reactivex.Flowable;

public interface MainContract {
    interface Model extends BaseModel {
        Flowable<JsonObject> getMoviesInfo(HashMap<String,String> params);
    }

    interface IView extends BaseView{
        void movieInfoResponse(JsonObject jsonObject);
    }

    static abstract  class Presenter extends BasePresenter<Model,IView>{
        public abstract void requestMoviesInfo(HashMap<String,String> params);
    }
}
