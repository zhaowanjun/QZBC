package com.qzbc.cpqp.ui.view;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.AttributeSet;
import android.view.View;

import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by zhaowanjun on 2018/4/29.
 */

public class MyVideoPlayer extends JZVideoPlayerStandard {

    public MyVideoPlayer(Context context) {
        this(context, null);
    }

    public MyVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == cn.jzvd.R.id.fullscreen) {
            if (currentScreen == SCREEN_WINDOW_FULLSCREEN) {
                JZUtils.setRequestedOrientation(getContext(), ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else {
                JZUtils.setRequestedOrientation(getContext(), ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    }

}
