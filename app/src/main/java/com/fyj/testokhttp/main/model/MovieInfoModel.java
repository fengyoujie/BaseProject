package com.fyj.testokhttp.main.model;
import com.fyj.testokhttp.ApiServices;
import com.fyj.testokhttp.RetrofitProvider;
import com.fyj.testokhttp.main.contract.MainContract;
import com.google.gson.JsonObject;
import java.util.HashMap;
import io.reactivex.Flowable;

public class MovieInfoModel implements MainContract.Model {
    @Override
    public Flowable<JsonObject> getMoviesInfo(HashMap<String, String> params) {
        ApiServices services = RetrofitProvider.getInstance().getApiServices();
        Flowable<JsonObject> flowable = services.getMoviesInfo(params);
        return flowable ;
    }

    @Override
    public void onFailed(String error) {

    }
}
