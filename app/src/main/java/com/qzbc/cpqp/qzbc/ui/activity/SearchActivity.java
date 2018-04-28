package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.ui.adapter.BrandAdapter;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;

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

    private int[] brandImg = {R.mipmap.brand1, R.mipmap.brand2, R.mipmap.brand3, R.mipmap.brand4,
            R.mipmap.brand5, R.mipmap.brand6, R.mipmap.brand7, R.mipmap.brand8};
    private String[] brandName = {"宝马", "中国一汽", "上海荣威", "比亚迪", "奥迪", "奔驰", "雪佛兰", "雪铁龙"};

    @Override
    protected void initView() {
        initAdapter();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_search;
    }

    private void initAdapter() {
        //创建瀑布流布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRcvSearch.setLayoutManager(layoutManager);
        BrandAdapter mBrandAdapter = new BrandAdapter(this, brandImg, brandName);
        mRcvSearch.setAdapter(mBrandAdapter);
        mBrandAdapter.setOnItemClickListener(new BrandAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String url) {
                Intent intent = new Intent(SearchActivity.this, VideoActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }

}
