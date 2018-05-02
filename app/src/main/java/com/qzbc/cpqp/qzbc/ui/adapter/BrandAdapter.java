package com.qzbc.cpqp.qzbc.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qzbc.cpqp.qzbc.R;

/**
 * Created by admin on 2018/4/28.
 */
public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> implements View.OnClickListener {

    private final Context mContext;
    private final int[] mBrandImg;
    private String[] mBrandName;

    public BrandAdapter(Context context, int[] brandImg, String[] brandName) {

        mContext = context;
        mBrandImg = brandImg;
        mBrandName = brandName;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_brand, null);
        inflate.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mIvBrand.setImageResource(mBrandImg[position]);
        holder.mTv_brand.setText(mBrandName[position]);
        holder.itemView.setTag("http://192.168.1.86/sdvrdistfile/6813ddf5-114a-48c8-ba55-e6ce82309ee2.mp4");
    }

    @Override
    public int getItemCount() {
        return mBrandImg.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mIvBrand;
        private final TextView mTv_brand;

        public ViewHolder(View itemView) {
            super(itemView);
            mIvBrand = itemView.findViewById(R.id.iv_brand);
            mTv_brand = itemView.findViewById(R.id.tv_brand);
        }
    }

    private OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(String url);
    }

    @Override
    public void onClick(View view) {
        if(mItemClickListener != null) {
            mItemClickListener.onItemClick((String) view.getTag());
        }
    }
}
