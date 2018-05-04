package com.qzbc.cpqp.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.qzbc.cpqp.MyApplication;
import com.qzbc.cpqp.R;
import com.qzbc.cpqp.api.QZBCApi;
import com.qzbc.cpqp.bean.Entiry;
import com.qzbc.cpqp.bean.WholeBean;
import com.qzbc.cpqp.ui.base.BaseActivity;
import com.qzbc.cpqp.utils.SPUtil;
import com.qzbc.cpqp.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2018/4/27.
 */
public class SplashActivity extends BaseActivity {

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
        entiry.setECID(MyApplication.getECID());
        entiry.setDeviceID(42);

        QZBCApi qzbcApi = MyApplication.getQZBCApi();
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
