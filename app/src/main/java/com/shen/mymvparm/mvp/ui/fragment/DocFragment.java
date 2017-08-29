package com.shen.mymvparm.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.shen.mymvparm.R;
import com.shen.mymvparm.app.Constants;
import com.shen.mymvparm.app.EventBusTags;
import com.shen.mymvparm.app.RefreshEvent;
import com.shen.mymvparm.mvp.model.api.database.DatabaseImpl;
import com.shen.mymvparm.mvp.model.api.database.IDatabase;
import com.shen.mymvparm.mvp.model.entity.Doc;
import com.shen.mymvparm.mvp.ui.activity.DocActivity;
import com.shen.mymvparm.mvp.ui.adapter.DocAdapter;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import java.util.ArrayList;



/**
 * 云笔记
 */
public class DocFragment extends BaseFragment implements View.OnClickListener{


    private ImageView mIvHead;
    private ImageView mIvOption;
    private ImageView mIvSync;
    private RecyclerView mRvContainer;
    private TextView mTvAdd;

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
        view.findViewById(R.id.tv_add).setOnClickListener(this);
        mIvSync.setOnClickListener(this);

        mDatabase = new DatabaseImpl();
        mDocs = mDatabase.queryDocs(Constants.LOCAL_ID);
//        mDocs.add(new Doc(0L,"标题1","内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容1内容" +
//                "1内容1内容1内容1","1111111","",-100));
//        mDocs.add(new Doc(0L,"标题2","内容2","1111111","",-100));
//        mDocs.add(new Doc(0L,"标题3","内容3","1111111","",-100));
//        mDocs.add(new Doc(0L,"标题4","内容4","1111111","",-100));
//        mDocs.add(new Doc(0L,"标题5","内容5","1111111","",-100));
        mRvContainer.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        mAdapter = new DocAdapter(mDocs);
        mRvContainer.setAdapter(mAdapter);

        EventBus.getDefault().register(this);
        return view;
    }

    @Subscriber
    private void refreshDoc(int  action) {
        mDocs.clear();
        ArrayList<Doc> list = mDatabase.queryDocs(Constants.LOCAL_ID);
        mDocs.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.tv_add:
                Intent intent = new Intent(getActivity(), DocActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("doc",new Doc());
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.iv_sync:
                break;
        }
    }
}
