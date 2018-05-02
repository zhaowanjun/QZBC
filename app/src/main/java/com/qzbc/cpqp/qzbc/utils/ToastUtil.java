package com.qzbc.cpqp.qzbc.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by admin on 2018/5/2.
 */
public class ToastUtil {
    private static Toast mToast = null;
    public static void showToast(Context context, String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
}
