package com.qzbc.cpqp.qzbc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.utils.ScreenUtil;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2018/4/28.
 */
public class VideoActivity extends AppCompatActivity {

    @Bind(R.id.video_player)
    StandardGSYVideoPlayer mVideoPlayer;
    private OrientationUtils mOrientationUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mOrientationUtils = new OrientationUtils(this, mVideoPlayer);
        int screenWidth = ScreenUtil.instance(this).getScreenWidth();
        mVideoPlayer.getLayoutParams().height = screenWidth * 9 / 16;
        String url = getIntent().getStringExtra("url");
        mVideoPlayer.setUp(url, true, "1231231223");

        ImageView fullscreenButton = mVideoPlayer.getFullscreenButton();
        int shrinkImageRes = mVideoPlayer.getShrinkImageRes();

        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrientationUtils.resolveByClick();
                mVideoPlayer.startWindowFullscreen(VideoActivity.this, true, true);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            mOrientationUtils.resolveByClick();
            return;
        }
        super.onBackPressed();
    }
}
