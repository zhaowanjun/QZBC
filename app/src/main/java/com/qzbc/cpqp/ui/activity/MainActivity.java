package com.qzbc.cpqp.ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qzbc.cpqp.R;
import com.qzbc.cpqp.bean.VtrainBusinessVideoListBean;
import com.qzbc.cpqp.bean.WholeBean;
import com.qzbc.cpqp.ui.adapter.BrandAdapter;
import com.qzbc.cpqp.ui.adapter.VideoAdapter;
import com.qzbc.cpqp.ui.base.BaseActivity;
import com.qzbc.cpqp.ui.view.ExStaggeredGridLayoutManager;
import com.qzbc.cpqp.utils.SPUtil;
import com.qzbc.cpqp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.iv_menu)
    ImageView mIvMenu;
    @Bind(R.id.iv_scan)
    ImageView mIvScan;
    @Bind(R.id.tv_more1)
    TextView mTvMore1;
    @Bind(R.id.rcv_brand)
    RecyclerView mRcvBrand;
    @Bind(R.id.tv_more2)
    TextView mTvMore2;
    @Bind(R.id.rcv_video)
    RecyclerView mRcvVideo;

    private int[] brandImg = {R.mipmap.brand1, R.mipmap.brand2, R.mipmap.brand3, R.mipmap.brand4,
                                R.mipmap.brand5, R.mipmap.brand6, R.mipmap.brand7, R.mipmap.brand8};
    private String[] brandName = {"宝马", "中国一汽", "上海荣威", "比亚迪", "奥迪", "奔驰", "雪佛兰", "雪铁龙"};
    private BrandAdapter mBrandAdapter;
    private VideoAdapter mVideoAdapter;
    private WholeBean mWholeBean;
    private List<VtrainBusinessVideoListBean> mVtrainBusinessVideoList;

    @Override
    protected void initView() {
        initBrandAdapter();
        initVideoAdapter();
        initItemClick();
    }

    private void initItemClick() {
        if(mBrandAdapter != null) {
            mBrandAdapter.setOnItemClickListener(new BrandAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(String url) {
                    openSearchActivity();
                }
            });
        }

        if(mVideoAdapter != null) {
            mVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    VtrainBusinessVideoListBean vtrainBusinessVideoListBean = mVtrainBusinessVideoList.get(position);
                    Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                    intent.putExtra("vtrainBusinessVideoListBean", (Parcelable) vtrainBusinessVideoListBean);
                    startActivity(intent);
                }
            });
        }

    }

    private void initBrandAdapter() {
        //创建瀑布流布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        mRcvBrand.setLayoutManager(layoutManager);
        mRcvVideo.setHasFixedSize(true);
        mBrandAdapter = new BrandAdapter(this, brandImg, brandName);
        mRcvBrand.setAdapter(mBrandAdapter);
    }

    private void initVideoAdapter() {
        //创建瀑布流布局管理器
        ExStaggeredGridLayoutManager layoutManager = new ExStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRcvVideo.setLayoutManager(layoutManager);
        mRcvVideo.setHasFixedSize(true);
        mRcvVideo.setNestedScrollingEnabled(false);
        //获取数据
        mWholeBean = SPUtil.getObject(this, "wholeBean");
        if(mWholeBean != null && mWholeBean.getVtrainBusinessVideoList() != null) {
            mVtrainBusinessVideoList = mWholeBean.getVtrainBusinessVideoList();
            mVideoAdapter = new VideoAdapter(R.layout.item_video, mVtrainBusinessVideoList, this);
            mRcvVideo.setAdapter(mVideoAdapter);
        } else {
            ToastUtil.showToast(this, "暂无视频", Toast.LENGTH_LONG);
        }
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.iv_menu, R.id.iv_scan, R.id.tv_more1, R.id.tv_more2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_menu:
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
                break;
            case R.id.iv_scan:
                startActivity(new Intent(MainActivity.this, ScannerActivity.class));
                break;
            case R.id.tv_more1:
                openSearchActivity();
                break;
            case R.id.tv_more2:
                openSearchActivity();
                break;
        }
    }

    private void openSearchActivity() {
        Intent intent = new Intent(MainActivity.this, SeekActivity.class);
        intent.putParcelableArrayListExtra("vtrainBusinessVideoList", (ArrayList<? extends Parcelable>) mVtrainBusinessVideoList);
        List<WholeBean.VtrainBusinessMenuListBean> vtrainBusinessMenuList = mWholeBean.getVtrainBusinessMenuList();
        intent.putParcelableArrayListExtra("vtrainBusinessMenuList", (ArrayList<? extends Parcelable>) vtrainBusinessMenuList);
        startActivity(intent);
    }

}
