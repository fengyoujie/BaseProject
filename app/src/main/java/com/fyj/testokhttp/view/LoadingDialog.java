package com.fyj.testokhttp.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyj.testokhttp.R;

public class LoadingDialog extends DialogFragment {
    private static LoadingDialog mInstance = null ;

    @SuppressLint("ValidFragment")
    private LoadingDialog(){}

    public static LoadingDialog getInstance(){
        if(mInstance == null){
            synchronized (LoadingDialog.class){
                if(mInstance == null){
                    mInstance = new LoadingDialog();
                }
            }
        }
        return mInstance ;
    }

    @Override
    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        return super.onGetLayoutInflater(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.CustomProgressDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_loading, container,false);
        getDialog().setCanceledOnTouchOutside(false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog() ;
        if(dialog ==null){
            return ;
        }
    }

    public void show(FragmentManager manager){
        show(manager,"loadingDialog");
    }

    @Override
    public void show(FragmentManager manager ,String tag){
        try{
            Fragment fragment = manager.findFragmentByTag(tag);
            if(fragment == null || fragment.isAdded()){
                FragmentTransaction ft = manager.beginTransaction();
                ft.add(this,tag);
                ft.commitAllowingStateLoss();
            }
        }catch (Exception e){

        }
    }
}
