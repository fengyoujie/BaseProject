package com.fyj.testokhttp.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fyj.testokhttp.utils.GenericsUtil;
import com.fyj.testokhttp.view.LoadingDialog;

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    public P mPresenter ;
    public M mModel ;
    public Context mContext ;
    private LoadingDialog mLoadingDialog = null ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        setContentView(getLayoutId());
        mPresenter = GenericsUtil.getGenericInstance(this,0);
        mModel = GenericsUtil.getGenericInstance(this,1);

        if(mPresenter != null){
            mPresenter.mContext = this;
        }
        initView();
        initPresenter();
    }

    private void doBeforeSetContentView(){
        AppManager.getInstance().addActivity(this);
    }

    public abstract int getLayoutId();
    public abstract void initPresenter();
    public abstract void initView();


    public void startActivity(Class<?> clz,Bundle bundle){
        Intent intent = new Intent(this,clz);
        if(bundle !=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void showLoadingDialog(){
        try{
            if(mLoadingDialog == null){
                mLoadingDialog = LoadingDialog.getInstance();
            }

            mLoadingDialog.show(getSupportFragmentManager());
        }catch (Exception e){

        }
    }

    public void dismissLoadingDialog(){
        if(mLoadingDialog == null){
            return;
        }

        try{
            mLoadingDialog.dismissAllowingStateLoss();
        }catch (Exception e){

        }
    }

    public void startActivityForResult(Class<?> clz,Bundle bundle,int requestCode){
        Intent intent = new Intent(this,clz);
        if(bundle !=null){
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requestCode);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.onDestroy();
            mPresenter = null ;
        }

        AppManager.getInstance().finishActivity(this);
    }
}
