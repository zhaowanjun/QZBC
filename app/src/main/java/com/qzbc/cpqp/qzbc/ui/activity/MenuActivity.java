package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2018/4/28.
 */
public class MenuActivity extends BaseActivity {
    @Bind(R.id.btn_exit)
    Button mBtnExit;

    @Override
    protected void initView() {

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_menu;
    }

    @OnClick(R.id.btn_exit)
    public void onViewClicked() {
        startActivity(new Intent(MenuActivity.this, LoginActivity.class));
        finish();
    }
}
