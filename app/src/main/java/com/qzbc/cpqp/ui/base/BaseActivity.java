package com.qzbc.cpqp.ui.base;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by admin on 2018/4/27.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化界面
     */
    protected abstract void initView();

    /**
     * @return  返回布局layout的id
     */
    public abstract int getContentViewId();
}
