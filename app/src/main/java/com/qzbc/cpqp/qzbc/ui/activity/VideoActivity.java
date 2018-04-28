package com.qzbc.cpqp.qzbc.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.ui.base.BaseActivity;
import com.qzbc.cpqp.qzbc.ui.view.MyVideoPlayer;
import com.qzbc.cpqp.qzbc.utils.ScreenUtil;

import butterknife.Bind;
import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by admin on 2018/4/28.
 */
public class VideoActivity extends BaseActivity {

    @Bind(R.id.iv_menu)
    ImageView mIvMenu;
    @Bind(R.id.iv_scan)
    ImageView mIvScan;
    @Bind(R.id.video_player)
    MyVideoPlayer mVideoPlayer;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_describe1)
    TextView mTvDescribe1;
    @Bind(R.id.tv_describe2)
    TextView mTvDescribe2;
    @Bind(R.id.tv_describe3)
    TextView mTvDescribe3;
    @Bind(R.id.tv_introduce)
    TextView mTvIntroduce;
    private String mUrl;

    @Override
    public int getContentViewId() {
        return R.layout.activity_video;
    }

    protected void initView() {
        int screenWidth = ScreenUtil.instance(this).getScreenWidth();
        mVideoPlayer.getLayoutParams().height = screenWidth*9/16 ;
        mUrl = getIntent().getStringExtra("url");
        mVideoPlayer.setUp(mUrl, MyVideoPlayer.SCREEN_WINDOW_NORMAL, "");
        mVideoPlayer.startVideo();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoPlayer.startVideo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JZUtils.clearSavedProgress(this, mUrl);
    }
}
