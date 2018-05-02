package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.qzbc.cpqp.qzbc.MyApplication;
import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.api.QZBCApi;
import com.qzbc.cpqp.qzbc.bean.Entiry;
import com.qzbc.cpqp.qzbc.bean.WholeBean;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;
import com.qzbc.cpqp.qzbc.utils.SPUtil;
import com.qzbc.cpqp.qzbc.utils.ToastUtil;

import java.sql.SQLOutput;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by admin on 2018/4/27.
 */
public class SplashActivity extends BaseActivity {

    private Retrofit mRetrofit;

    @Override
    protected void initView() {
        loadData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, 3500);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }

    private void loadData() {
        Entiry entiry = new Entiry();
        entiry.setECID(100211);
        entiry.setDeviceID(42);

        mRetrofit = MyApplication.getRetrofit();
        QZBCApi qzbcApi = mRetrofit.create(QZBCApi.class);
        Call<WholeBean> wholeData = qzbcApi.getWholeData(entiry);
        wholeData.enqueue(new Callback<WholeBean>() {
            @Override
            public void onResponse(Call<WholeBean> call, Response<WholeBean> response) {
                WholeBean wholeBean = response.body();
                SPUtil.putObject(SplashActivity.this, "wholeBean", wholeBean);
            }

            @Override
            public void onFailure(Call<WholeBean> call, Throwable t) {
                ToastUtil.showToast(SplashActivity.this, "网络连接错误", Toast.LENGTH_LONG);
            }
        });
    }

}
