package com.qzbc.cpqp.ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.common.StringUtils;
import com.qzbc.cpqp.MyApplication;
import com.qzbc.cpqp.R;
import com.qzbc.cpqp.api.QZBCApi;
import com.qzbc.cpqp.bean.FilterBean;
import com.qzbc.cpqp.bean.SeekEntiry;
import com.qzbc.cpqp.bean.VtrainBusinessVideoListBean;
import com.qzbc.cpqp.ui.base.BaseActivity;
import com.qzbc.cpqp.utils.ToastUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2018/4/28.
 */
public class ScannerActivity extends BaseActivity{

    private final int REQ_CODE = 1024;
    private final int MINUS_NUM = 1000000;

    @Override
    protected void initView() {
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_scanner;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE) {
            if(data != null) {
                String result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT);
                if(!TextUtils.isDigitsOnly(result)) {
                    ToastUtil.showToast(ScannerActivity.this, "请扫描正确的二维码", Toast.LENGTH_LONG);
                    finish();
                    return;
                }
                goToVideo(result);
            } else {
                finish();
            }

        }
    }

    private void goToVideo(String result) {
        QZBCApi qzbcApi = MyApplication.getQZBCApi();

        int id = Integer.parseInt(result)-MINUS_NUM;
        SeekEntiry seekEntiry = new SeekEntiry();
        seekEntiry.setECID(MyApplication.getECID());
        seekEntiry.setBVID(id);
        Call<FilterBean> filterBeanCall = qzbcApi.scanQRCode(seekEntiry);
        filterBeanCall.enqueue(new Callback<FilterBean>() {
            @Override
            public void onResponse(Call<FilterBean> call, Response<FilterBean> response) {
                FilterBean filterBean = response.body();
                List<VtrainBusinessVideoListBean> vtrainBusinessVideoList = filterBean.getVtrainBusinessVideoList();

                if(vtrainBusinessVideoList != null && vtrainBusinessVideoList.size() > 0) {
                    VtrainBusinessVideoListBean vtrainBusinessVideoListBean = vtrainBusinessVideoList.get(0);
                    Intent intent = new Intent(ScannerActivity.this, VideoActivity.class);
                    intent.putExtra("vtrainBusinessVideoListBean", (Parcelable) vtrainBusinessVideoListBean);
                    startActivity(intent);
                    finish();
                } else {
                    ToastUtil.showToast(ScannerActivity.this, "无内容", Toast.LENGTH_LONG);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<FilterBean> call, Throwable t) {
                ToastUtil.showToast(ScannerActivity.this, "无内容", Toast.LENGTH_LONG);
                finish();
            }
        });
    }

}
