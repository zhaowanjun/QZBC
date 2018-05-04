package com.qzbc.cpqp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qzbc.cpqp.MyApplication;
import com.qzbc.cpqp.R;
import com.qzbc.cpqp.api.QZBCApi;
import com.qzbc.cpqp.bean.FilterBean;
import com.qzbc.cpqp.bean.SeekEntiry;
import com.qzbc.cpqp.bean.VtrainBusinessVideoListBean;
import com.qzbc.cpqp.ui.adapter.VideoAdapter;
import com.qzbc.cpqp.ui.base.BaseActivity;
import com.qzbc.cpqp.ui.view.ExStaggeredGridLayoutManager;
import com.qzbc.cpqp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2018/5/3.
 */
public class SearchActivity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.iv_search)
    ImageView mIvSearch;
    @Bind(R.id.rcv_search)
    RecyclerView mRcvSearch;
    @Bind(R.id.et_search_text)
    EditText mEtSearchText;
    private QZBCApi mQzbcApi;
    private VideoAdapter mVideoAdapter;
    private ArrayList<VtrainBusinessVideoListBean> mVtrainBusinessVideoList = new ArrayList<>();
    SeekEntiry mSeekEntiry = new SeekEntiry();

    @Override
    protected void initView() {
        initVideoAdapter();
        initItemClick();
        mQzbcApi = MyApplication.getQZBCApi();
        mSeekEntiry.setECID(MyApplication.getECID());

        //回车键搜索
        mEtSearchText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    searchVideoData();
                }
                return false;
            }
        });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_search;
    }

    private void initVideoAdapter() {
        //创建瀑布流布局管理器
        ExStaggeredGridLayoutManager layoutManager = new ExStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRcvSearch.setLayoutManager(layoutManager);
        mRcvSearch.setHasFixedSize(true);
        mRcvSearch.setNestedScrollingEnabled(false);

        mVideoAdapter = new VideoAdapter(R.layout.item_video, mVtrainBusinessVideoList, this);
        mRcvSearch.setAdapter(mVideoAdapter);
    }

    private void initItemClick() {
        mVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(SearchActivity.this, VideoActivity.class);
                VtrainBusinessVideoListBean vtrainBusinessVideoListBean = mVtrainBusinessVideoList.get(position);
                intent.putExtra("vtrainBusinessVideoListBean", (Parcelable) vtrainBusinessVideoListBean);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_search:
                searchVideoData();
                break;
        }
    }

    private void searchVideoData() {

        // 先隐藏键盘
        ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(SearchActivity.this.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        String searchText = mEtSearchText.getText().toString().trim();
        if(TextUtils.isEmpty(searchText)) {
            ToastUtil.showToast(this, "搜索内容不能为空", Toast.LENGTH_LONG);
            return;
        }
        mSeekEntiry.setVideoName(searchText);
        Call<FilterBean> filterBeanCall = mQzbcApi.searchVideoData(mSeekEntiry);
        filterBeanCall.enqueue(new Callback<FilterBean>() {
            @Override
            public void onResponse(Call<FilterBean> call, Response<FilterBean> response) {
                FilterBean filterBean = response.body();
                List<VtrainBusinessVideoListBean> vtrainBusinessVideoList = filterBean.getVtrainBusinessVideoList();
                if (vtrainBusinessVideoList != null) {
                    mVideoAdapter.setVideoData(vtrainBusinessVideoList);
                } else {
                    mVideoAdapter.clearData();
                    ToastUtil.showToast(SearchActivity.this, "未找到结果", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<FilterBean> call, Throwable t) {

            }
        });
    }
}
