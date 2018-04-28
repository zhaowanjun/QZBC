package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2018/4/27.
 */
public class LoginActivity extends BaseActivity {
    @Bind(R.id.edit_phone)
    EditText mEditPhone;
    @Bind(R.id.edit_pwd)
    EditText mEditPwd;
    @Bind(R.id.btn_login)
    Button mBtnLogin;

    @Override
    protected void initView() {

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
