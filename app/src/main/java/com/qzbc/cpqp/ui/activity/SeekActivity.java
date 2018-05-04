package com.qzbc.cpqp.ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qzbc.cpqp.MyApplication;
import com.qzbc.cpqp.R;
import com.qzbc.cpqp.api.QZBCApi;
import com.qzbc.cpqp.bean.FilterBean;
import com.qzbc.cpqp.bean.SeekEntiry;
import com.qzbc.cpqp.bean.VtrainBusinessVideoListBean;
import com.qzbc.cpqp.bean.WholeBean;
import com.qzbc.cpqp.ui.adapter.VideoAdapter;
import com.qzbc.cpqp.ui.base.BaseActivity;
import com.qzbc.cpqp.ui.view.ExStaggeredGridLayoutManager;
import com.qzbc.cpqp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2018/4/28.
 */
public class SeekActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.rg_brand)
    RadioGroup mRgBrand;
    @Bind(R.id.rg_tech)
    RadioGroup mRgTech;
    @Bind(R.id.rg_structure)
    RadioGroup mRgStructure;
    @Bind(R.id.rcv_search)
    RecyclerView mRcvSearch;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.iv_search)
    ImageView mIvSearch;
    private ArrayList<VtrainBusinessVideoListBean> mVtrainBusinessVideoList;
    private ArrayList<WholeBean.VtrainBusinessMenuListBean> mVtrainBusinessMenuList;
    private VideoAdapter mVideoAdapter;

    SeekEntiry mSeekEntiry = new SeekEntiry();
    private List<String> brandList = new ArrayList<>();
    private String[] techArr = {"全部工艺", "拆卸工艺", "安装工艺"};
    private String[] structureArr = {"全部构造", "车顶", "底盘", "左车身", "右车身", "车头", "车尾"};
    private QZBCApi mQzbcApi;

    @Override
    protected void initView() {
        getIntentData();
        initRadioButton();
        initVideoAdapter();
        initItemClick();
        mQzbcApi = MyApplication.getQZBCApi();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_seek;
    }

    private void getIntentData() {
        //获取数据
        Intent intent = getIntent();
        mVtrainBusinessVideoList = intent.getParcelableArrayListExtra("vtrainBusinessVideoList");
        mVtrainBusinessMenuList = intent.getParcelableArrayListExtra("vtrainBusinessMenuList");

        //将参数存入集合方便实用
        brandList.add("全部车型");
        for (WholeBean.VtrainBusinessMenuListBean vtrainBusinessMenuListBean : mVtrainBusinessMenuList) {
            if (vtrainBusinessMenuListBean.getMenuLevel() == 1) {
                String menuName = vtrainBusinessMenuListBean.getMenuName();
                brandList.add(menuName);
            }
        }

        mSeekEntiry.setECID(MyApplication.getECID());
    }

    private void initRadioButton() {
        initBrandRadioButton();
        initTechRadioButton();
        initStructureRadioButton();
        initCheckListener();
    }

    private void initCheckListener() {
        mRgBrand.setOnCheckedChangeListener(this);
        mRgTech.setOnCheckedChangeListener(this);
        mRgStructure.setOnCheckedChangeListener(this);
    }

    private void initBrandRadioButton() {
        RadioButton brandRadioButton;
        for (int i = 0; i < brandList.size(); i++) {
            brandRadioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.myself_radio_button, null);
            brandRadioButton.setId(i);
            brandRadioButton.setText(brandList.get(i));
            brandRadioButton.setTextSize(12);

            mRgBrand.addView(brandRadioButton);
            if (i != 0) {
                setMargins(brandRadioButton, 20, 0, 0, 0);
            }
        }
        mRgBrand.check(0);
    }

    private void initTechRadioButton() {
        RadioButton techRadioButton;
        for (int i = 0; i < techArr.length; i++) {
            techRadioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.myself_radio_button, null);
            techRadioButton.setId(i);
            techRadioButton.setText(techArr[i]);
            techRadioButton.setTextSize(12);
            mRgTech.addView(techRadioButton);
            if (i != 0) {
                setMargins(techRadioButton, 20, 0, 0, 0);
            }
        }
        mRgTech.check(0);
    }

    private void initStructureRadioButton() {
        RadioButton structureRadioButton;
        for (int i = 0; i < structureArr.length; i++) {
            structureRadioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.myself_radio_button, null);
            structureRadioButton.setId(i);
            structureRadioButton.setText(structureArr[i]);
            structureRadioButton.setTextSize(12);
            mRgStructure.addView(structureRadioButton);
            if (i != 0) {
                setMargins(structureRadioButton, 20, 0, 0, 0);
            }
        }
        mRgStructure.check(0);
    }

    private void setMargins(View v, int l, int t, int r, int b) {
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
        mRcvSearch.setNestedScrollingEnabled(false);

        if (mVtrainBusinessVideoList != null) {
            mVideoAdapter = new VideoAdapter(R.layout.item_video, mVtrainBusinessVideoList, this);
            mRcvSearch.setAdapter(mVideoAdapter);
        } else {
            ToastUtil.showToast(this, "未找到相关视频", Toast.LENGTH_LONG);
        }
    }

    private void initItemClick() {
        mVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(SeekActivity.this, VideoActivity.class);
                VtrainBusinessVideoListBean vtrainBusinessVideoListBean = mVtrainBusinessVideoList.get(position);
                intent.putExtra("vtrainBusinessVideoListBean", (Parcelable) vtrainBusinessVideoListBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup == mRgBrand) {
            if (i == 0) {
                mSeekEntiry.setBusinessName("");
            } else {
                String brand = brandList.get(i);
                mSeekEntiry.setBusinessName(brand);
            }
        } else if (radioGroup == mRgTech) {
            if (i == 0) {
                mSeekEntiry.setBelongTech("");
            } else {
                mSeekEntiry.setBelongTech(i + "");
            }
        } else {
            if (i == 0) {
                mSeekEntiry.setBelongPart("");
            } else {
                mSeekEntiry.setBelongPart(i + "");
            }
        }

        seskVideoData();
    }

    private void seskVideoData() {
        Call<FilterBean> filterBeanCall = mQzbcApi.seekVideoData(mSeekEntiry);
        filterBeanCall.enqueue(new Callback<FilterBean>() {
            @Override
            public void onResponse(Call<FilterBean> call, Response<FilterBean> response) {
                FilterBean filterBean = response.body();
                List<VtrainBusinessVideoListBean> vtrainBusinessVideoList = filterBean.getVtrainBusinessVideoList();
                if (vtrainBusinessVideoList != null) {
                    mVideoAdapter.setVideoData(vtrainBusinessVideoList);
                } else {
                    mVideoAdapter.clearData();
                }
            }

            @Override
            public void onFailure(Call<FilterBean> call, Throwable t) {
                ToastUtil.showToast(SeekActivity.this, "未找到结果", Toast.LENGTH_LONG);
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
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
    }
}
