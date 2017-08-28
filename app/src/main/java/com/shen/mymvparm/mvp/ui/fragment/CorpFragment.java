 package com.shen.mymvparm.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.shen.mymvparm.R;

 /**
 * 云协作
 */
public class CorpFragment extends BaseFragment {

     @Override
     public void setupFragmentComponent(AppComponent appComponent) {

     }

     @Override
     public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_corp,null);
         return view;
     }

     @Override
     public void initData(Bundle savedInstanceState) {

     }

     @Override
     public void setData(Object data) {

     }
 }
