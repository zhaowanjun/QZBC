package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.ui.adapter.BrandAdapter;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;

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

    @Override
    protected void initView() {
        initBrandAdapter();
        initVideoAdapter();
        initItemClick();
    }

    private void initItemClick() {
        mBrandAdapter.setOnItemClickListener(new BrandAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String url) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }

    private void initVideoAdapter() {
        //创建瀑布流布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRcvVideo.setLayoutManager(layoutManager);
        mRcvVideo.setAdapter(mBrandAdapter);
    }

    private void initBrandAdapter() {
        //创建瀑布流布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        mRcvBrand.setLayoutManager(layoutManager);
        mBrandAdapter = new BrandAdapter(this, brandImg, brandName);
        mRcvBrand.setAdapter(mBrandAdapter);
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
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;
            case R.id.tv_more2:
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;
        }
    }

}
