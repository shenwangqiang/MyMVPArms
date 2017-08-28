package com.shen.mymvparm.mvp.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shen.mymvparm.R;
import com.shen.mymvparm.mvp.model.entity.Doc;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;

public class DocAdapter extends BaseQuickAdapter<Doc, BaseViewHolder> {
    public DocAdapter(ArrayList<Doc> list) {
        super(R.layout.adapter_note, list);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.autoSize(view);
        return super.createBaseViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    protected void convert(BaseViewHolder helper, Doc item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, item.getContent())
                .setText(R.id.tv_modify, item.getLastModify());
    }
}
