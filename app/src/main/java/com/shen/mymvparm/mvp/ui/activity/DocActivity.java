package com.shen.mymvparm.mvp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.utils.UiUtils;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shen.mymvparm.R;
import com.shen.mymvparm.app.Constants;
import com.shen.mymvparm.app.EventBusTags;
import com.shen.mymvparm.mvp.model.api.database.DatabaseImpl;
import com.shen.mymvparm.mvp.model.api.database.IDatabase;
import com.shen.mymvparm.mvp.model.entity.Doc;
import com.zhy.autolayout.AutoRelativeLayout;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shenwangqiang on 2017/8/28.
 */
public class DocActivity extends Activity {
    @BindView(R.id.et_title)
    MaterialEditText mEtTitle;
    @BindView(R.id.et_content)
    MaterialEditText mEtContent;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_finish)
    ImageView mIvFinish;
    @BindView(R.id.rl_top)
    AutoRelativeLayout mRlTop;

    private IDatabase mDatabase;
    private Doc mDoc;

    private int mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        ButterKnife.bind(this);

        mDatabase = new DatabaseImpl();
        Bundle bundle = getIntent().getExtras();
        mDoc = (Doc) bundle.getSerializable("doc");
        mType = bundle.getInt("type",Constants.TYPE_ADD);
        mDoc.setUid(Constants.LOCAL_ID);

        mTvTitle.setText(mType==Constants.TYPE_ADD? R.string.new_doc : R.string.edit_doc);
    }

    @OnClick({R.id.iv_back, R.id.iv_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_finish:
                String title  = mEtTitle.getText().toString();
                String content = mEtContent.getText().toString();
                if(TextUtils.isEmpty(content)){
                    UiUtils.snackbarText(getString(R.string.input_content));
                    return;
                }
                if(!title.equals(mDoc.getTitle())||!content.equals(mDoc.getContent())) {
                    mDoc.setTitle(title);
                    mDoc.setContent(content);
                    if (mType==Constants.TYPE_ADD) {
                        mDoc.setCreate(System.currentTimeMillis() + "");
                    }
                    mDoc.setLastModify(System.currentTimeMillis() + "");
                    if (mType==Constants.TYPE_ADD) {
                        mDatabase.insertDoc(mDoc);
                    } else {
                        mDatabase.updateDoc(mDoc);
                    }
                    EventBus.getDefault().post(EventBusTags.REFRESH_DOC);
                }
                finish();
                break;
        }
    }
}
