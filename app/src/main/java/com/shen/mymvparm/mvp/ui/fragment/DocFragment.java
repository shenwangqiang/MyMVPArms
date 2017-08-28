package com.shen.mymvparm.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.shen.mymvparm.R;
import com.shen.mymvparm.app.Constants;
import com.shen.mymvparm.mvp.model.api.database.DatabaseImpl;
import com.shen.mymvparm.mvp.model.api.database.IDatabase;
import com.shen.mymvparm.mvp.model.entity.Doc;
import com.shen.mymvparm.mvp.ui.adapter.DocAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 云笔记
 */
public class DocFragment extends BaseFragment {

    ImageView mIvHead;
    ImageView mIvOption;
    ImageView mIvSync;
    RecyclerView mRvContainer;

    private IDatabase mDatabase;
    private ArrayList<Doc> mDocs;
    private DocAdapter mAdapter;

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doc, null);

        mIvHead = (ImageView) view.findViewById(R.id.iv_head);
        mIvOption = (ImageView) view.findViewById(R.id.iv_option);
        mIvSync = (ImageView) view.findViewById(R.id.iv_sync);
        mRvContainer = (RecyclerView) view.findViewById(R.id.rv_container);

        mDatabase = new DatabaseImpl();
        mDocs = mDatabase.queryDocs(Constants.LOCAL_ID);
        mDocs.add(new Doc(0L,"标题1","内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容" +
                "1内容1内容1内容1","1111111","",-100));
        mDocs.add(new Doc(0L,"标题2","内容2","1111111","",-100));
        mDocs.add(new Doc(0L,"标题3","内容3","1111111","",-100));
        mDocs.add(new Doc(0L,"标题4","内容4","1111111","",-100));
        mDocs.add(new Doc(0L,"标题5","内容5","1111111","",-100));
        mRvContainer.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        mAdapter = new DocAdapter(mDocs);
        mRvContainer.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

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
