package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.os.Handler;

import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;

/**
 * Created by admin on 2018/4/27.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void initView() {
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
}
