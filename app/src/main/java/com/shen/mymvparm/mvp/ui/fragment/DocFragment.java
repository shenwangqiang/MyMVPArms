package com.shen.mymvparm.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.shen.mymvparm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 云笔记
 */
public class DocFragment extends BaseFragment {

    @BindView(R.id.iv_head)
    ImageView mIvHead;
    @BindView(R.id.iv_option)
    ImageView mIvOption;
    @BindView(R.id.iv_sync)
    ImageView mIvSync;
    @BindView(R.id.rv_container)
    RecyclerView mRvContainer;
    Unbinder unbinder;

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doc, null);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_head, R.id.iv_option, R.id.iv_sync})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                break;
            case R.id.iv_option:
                break;
            case R.id.iv_sync:
                break;
        }
    }
}
