package com.qzbc.cpqp.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qzbc.cpqp.R;
import com.qzbc.cpqp.bean.VtrainBusinessVideoListBean;
import com.qzbc.cpqp.bean.WholeBean;
import com.qzbc.cpqp.utils.ScreenUtil;

import java.util.List;

/**
 * Created by admin on 2018/5/2.
 */
public class VideoAdapter extends BaseQuickAdapter<VtrainBusinessVideoListBean, BaseViewHolder> {

    private final Context mContext;

    public VideoAdapter(int layoutResId, List<VtrainBusinessVideoListBean> data, Context context) {
        super(layoutResId, data);
        mContext = context;
    }

    public void setVideoData(List<VtrainBusinessVideoListBean> data) {
        if (data != null && data.size() > 0) {
            mData.clear();
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, VtrainBusinessVideoListBean item) {
        TextView tvName = helper.getConvertView().findViewById(R.id.tv_videoName);
        ImageView ivPic = helper.getConvertView().findViewById(R.id.iv_videoPic);
        int screenWidth = ScreenUtil.instance(mContext).getScreenWidth();
        ivPic.getLayoutParams().height = screenWidth * 9 / 32;
        tvName.setText(item.getVideoName());
        Glide.with(mContext)
                .load(item.getVideoPic())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(ivPic);
    }

}
