package com.fyj.testokhttp;

import android.os.Bundle;
import android.widget.TextView;

import com.fyj.testokhttp.base.BaseActivity;
import com.fyj.testokhttp.main.contract.MainContract;
import com.fyj.testokhttp.main.model.MovieInfoModel;
import com.fyj.testokhttp.main.presenter.MoviesInfoPresenter;
import com.google.gson.JsonObject;


import java.util.HashMap;

public class MainActivity extends BaseActivity<MoviesInfoPresenter, MovieInfoModel> implements MainContract.IView {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
        HashMap<String, String> map = new HashMap();
        map.put("languag", "en");
        map.put("sort_by", "popularity.desc");
        map.put("api_key", "a11374c112e5664e16542416ccd00988");
        mPresenter.requestMoviesInfo(map);
    }

    @Override
    public void initView() {
        mTextView = findViewById(R.id.tv);
    }

    @Override
    public void movieInfoResponse(JsonObject jsonObject) {
        mTextView.setText(jsonObject.toString());
    }

    @Override
    public void onLoaded() {

    }

    @Override
    public void onLoading(String title) {

    }

    @Override
    public void onLoadFailed(String error) {

    }
}
