package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.bean.WholeBean;
import com.qzbc.cpqp.qzbc.ui.adapter.BrandAdapter;
import com.qzbc.cpqp.qzbc.ui.adapter.VideoAdapter;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;
import com.qzbc.cpqp.qzbc.ui.view.ExStaggeredGridLayoutManager;
import com.qzbc.cpqp.qzbc.utils.SPUtil;
import com.qzbc.cpqp.qzbc.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2018/4/28.
 */
public class SearchActivity extends BaseActivity {
    @Bind(R.id.iv_menu)
    ImageView mIvMenu;
    @Bind(R.id.iv_scan)
    ImageView mIvScan;
    @Bind(R.id.rg_brand)
    RadioGroup mRgBrand;
    @Bind(R.id.rg_tech)
    RadioGroup mRgTech;
    @Bind(R.id.rg_structure)
    RadioGroup mRgStructure;
    @Bind(R.id.rcv_search)
    RecyclerView mRcvSearch;
    private ArrayList<WholeBean.VtrainBusinessVideoListBean> mVtrainBusinessVideoList;
    private ArrayList<WholeBean.VtrainBusinessMenuListBean> mVtrainBusinessMenuList;
    private VideoAdapter mVideoAdapter;

    private String[] techArr = {"全部工艺", "拆卸工艺", "安装工艺"};
    private String[] structureArr = { "全部构造", "车顶", "底盘", "左车身", "右车身", "车头", "车尾" } ;

    @Override
    protected void initView() {
        getIntentData();
        initRadioButton();
        initVideoAdapter();
        initItemClick();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_search;
    }

    private void getIntentData() {
        //获取数据
        Intent intent = getIntent();
        mVtrainBusinessVideoList = intent.getParcelableArrayListExtra("vtrainBusinessVideoList");
        mVtrainBusinessMenuList = intent.getParcelableArrayListExtra("vtrainBusinessMenuList");
    }

    private void initRadioButton() {
        initBrandRadioButton();
        initTechRadioButton();
        initStructureRadioButton();
    }

    private void initBrandRadioButton() {
        RadioButton brandRadioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.myself_radio_button, null);
        brandRadioButton.setText("全部车型");
        brandRadioButton.setId(0);
        mRgBrand.addView(brandRadioButton);

        for (int i = 0; i < mVtrainBusinessMenuList.size(); i++) {
            WholeBean.VtrainBusinessMenuListBean vtrainBusinessMenuListBean = mVtrainBusinessMenuList.get(i);

            if (vtrainBusinessMenuListBean.getMenuLevel() == 1) {
                String menuName = vtrainBusinessMenuListBean.getMenuName();
                brandRadioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.myself_radio_button, null);
                brandRadioButton.setText(menuName);
                mRgBrand.addView(brandRadioButton);

                setMargins(brandRadioButton, 20, 0, 0, 0);
            }
        }

        mRgBrand.check(0);
    }

    private void initTechRadioButton() {
        RadioButton techRadioButton ;
        for (int i = 0; i < techArr.length; i++) {
            techRadioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.myself_radio_button, null);
            techRadioButton.setId(i);
            techRadioButton.setText(techArr[i]);
            mRgTech.addView(techRadioButton);
            if(i != 0) {
                setMargins(techRadioButton, 20, 0, 0, 0);
            }
        }
        mRgTech.check(0);
    }

    private void initStructureRadioButton() {
        RadioButton structureRadioButton ;
        for (int i = 0; i < structureArr.length; i++) {
            structureRadioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.myself_radio_button, null);
            structureRadioButton.setId(i);
            structureRadioButton.setText(structureArr[i]);
            mRgStructure.addView(structureRadioButton);
            if(i != 0) {
                setMargins(structureRadioButton, 20, 0, 0, 0);
            }
        }
        mRgStructure.check(0);
    }

    private void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    private void initVideoAdapter() {
        //创建瀑布流布局管理器
        ExStaggeredGridLayoutManager layoutManager = new ExStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRcvSearch.setLayoutManager(layoutManager);
        mRcvSearch.setHasFixedSize(true);

        if (mVtrainBusinessVideoList != null) {
            mVideoAdapter = new VideoAdapter(R.layout.item_video, mVtrainBusinessVideoList, this);
            mRcvSearch.setAdapter(mVideoAdapter);
        } else {
            ToastUtil.showToast(this, "没有相关视频", Toast.LENGTH_LONG);
        }
    }

    private void initItemClick() {
        mVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(SearchActivity.this, VideoActivity.class);
                WholeBean.VtrainBusinessVideoListBean vtrainBusinessVideoListBean = mVtrainBusinessVideoList.get(position);
                intent.putExtra("vtrainBusinessVideoListBean", (Parcelable) vtrainBusinessVideoListBean);
                startActivity(intent);
            }
        });
    }

}
