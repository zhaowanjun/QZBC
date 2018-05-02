package com.qzbc.cpqp.qzbc.ui.activity;

import android.content.Intent;
import android.widget.Toast;

import com.google.zxing.activity.CaptureActivity;
import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;
import com.qzbc.cpqp.qzbc.utils.ToastUtil;

/**
 * Created by admin on 2018/4/28.
 */
public class ScannerActivity extends BaseActivity{

    private final static int REQ_CODE = 1024;

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
                ToastUtil.showToast(this, result, Toast.LENGTH_LONG);
            } else {
                finish();
            }

        }
    }
}
