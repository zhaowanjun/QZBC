package com.qzbc.cpqp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.qzbc.cpqp.R;
import com.qzbc.cpqp.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2018/4/28.
 */
public class MenuActivity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.btn_exit)
    Button mBtnExit;

    @Override
    protected void initView() {

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_menu;
    }


    @OnClick({R.id.iv_back, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_exit:
                startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }


}
