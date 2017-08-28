package com.shen.mymvparm.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.shen.mymvparm.R;
import com.shen.mymvparm.di.component.DaggerMainComponent;
import com.shen.mymvparm.di.module.MainModule;
import com.shen.mymvparm.mvp.contract.MainContract;
import com.shen.mymvparm.mvp.presenter.MainPresenter;
import com.shen.mymvparm.mvp.ui.fragment.CorpFragment;
import com.shen.mymvparm.mvp.ui.fragment.DocFragment;
import com.shen.mymvparm.mvp.ui.fragment.MyFragment;
import com.shen.mymvparm.mvp.ui.widget.GradientIconView;
import com.shen.mymvparm.mvp.ui.widget.GradientTextView;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, ViewPager.OnPageChangeListener  {

    @BindView(R.id.vp_container)
    ViewPager mVpContainer;
    @BindView(R.id.ll_doc)
    AutoLinearLayout mLlDoc;
    @BindView(R.id.ll_corp)
    AutoLinearLayout mLlCorp;
    @BindView(R.id.ll_my)
    AutoLinearLayout mLlMy;
    @BindView(R.id.giv_doc)
    GradientIconView mGivDoc;
    @BindView(R.id.gtv_doc)
    GradientTextView mGtvDoc;
    @BindView(R.id.giv_corp)
    GradientIconView mGivCorp;
    @BindView(R.id.gtv_corp)
    GradientTextView mGtvCorp;
    @BindView(R.id.giv_my)
    GradientIconView mGivMy;
    @BindView(R.id.gtv_my)
    GradientTextView mGtvMy;
    private FragmentPagerAdapter mAdapter;
    private List<GradientIconView> mTabIconIndicator = new ArrayList<GradientIconView>();
    private List<GradientTextView> mTabTextIndicator = new ArrayList<GradientTextView>();

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mFragments.clear();
        mFragments.add(new DocFragment());
        mFragments.add(new CorpFragment());
        mFragments.add(new MyFragment());
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

        };
        initTabIndicator();

        mVpContainer.setOffscreenPageLimit(3);
        mVpContainer.setAdapter(mAdapter);
        mVpContainer.setOnPageChangeListener(this);
    }

    /*初始化tab相关项*/
    private void initTabIndicator() {
        mTabIconIndicator.add(mGivDoc);
        mTabIconIndicator.add(mGivCorp);
        mTabIconIndicator.add(mGivMy);

        mTabTextIndicator.add(mGtvDoc);
        mTabTextIndicator.add(mGtvCorp);
        mTabTextIndicator.add(mGtvMy);

        mGivDoc.setIconAlpha(1.0f);
        mGtvDoc.setTextViewAlpha(1.0f);
    }

    /**
     * 重置其他的Tab
     */
    private void resetOtherTabs() {
        for (int i = 0; i < mTabIconIndicator.size(); i++) {
            mTabIconIndicator.get(i).setIconAlpha(0);
        }
        for (int i = 0; i < mTabTextIndicator.size(); i++) {
            mTabTextIndicator.get(i).setTextViewAlpha(0);
        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @OnClick({R.id.ll_doc, R.id.ll_corp, R.id.ll_my})
    public void onViewClicked(View view) {
        resetOtherTabs();
        switch (view.getId()) {
            case R.id.ll_doc:
                mTabIconIndicator.get(0).setIconAlpha(1.0f);
                mTabTextIndicator.get(0).setTextViewAlpha(1.0f);
                mVpContainer.setCurrentItem(0, false);
                break;
            case R.id.ll_corp:
                mTabIconIndicator.get(1).setIconAlpha(1.0f);
                mTabTextIndicator.get(1).setTextViewAlpha(1.0f);
                mVpContainer.setCurrentItem(1, false);
                break;
            case R.id.ll_my:
                mTabIconIndicator.get(2).setIconAlpha(1.0f);
                mTabTextIndicator.get(2).setTextViewAlpha(1.0f);
                mVpContainer.setCurrentItem(2, false);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            GradientIconView iconLeft = mTabIconIndicator.get(position);
            GradientIconView iconRight = mTabIconIndicator.get(position + 1);

            GradientTextView textLeft = mTabTextIndicator.get(position);
            GradientTextView textRight = mTabTextIndicator.get(position + 1);

            iconLeft.setIconAlpha(1 - positionOffset);
            textLeft.setTextViewAlpha(1 - positionOffset);
            iconRight.setIconAlpha(positionOffset);
            textRight.setTextViewAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
