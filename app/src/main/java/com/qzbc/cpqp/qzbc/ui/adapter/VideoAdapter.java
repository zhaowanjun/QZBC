package com.qzbc.cpqp.qzbc.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qzbc.cpqp.qzbc.R;
import com.qzbc.cpqp.qzbc.bean.WholeBean;

import java.util.List;

/**
 * Created by admin on 2018/5/2.
 */
public class VideoAdapter extends BaseQuickAdapter<WholeBean.VtrainBusinessVideoListBean, BaseViewHolder> {

    private final Context mContext;

    public VideoAdapter(int layoutResId, List<WholeBean.VtrainBusinessVideoListBean> data, Context context) {
        super(layoutResId, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, WholeBean.VtrainBusinessVideoListBean item) {
        TextView tvName = helper.getConvertView().findViewById(R.id.tv_videoName);
        ImageView ivPic = helper.getConvertView().findViewById(R.id.iv_videoPic);
        tvName.setText(item.getVideoName());
        Glide.with(mContext)
                .load(item.getVideoPic())
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(ivPic);
    }

}
