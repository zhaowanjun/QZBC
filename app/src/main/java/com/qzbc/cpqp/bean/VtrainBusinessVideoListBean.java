package com.qzbc.cpqp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/3.
 */
public class VtrainBusinessVideoListBean implements Serializable, Parcelable{
    private int Status;
    private String Description;
    private int BelongPart;
    private int VideoSize;
    private String VideoFileID;
    private int TrainID;
    private String VideoPic;
    private int BVID;
    private String BusinessName;
    private String LastUpdateTime;
    private int BelongTech;
    private String VideoName;
    private String AddTime;

    protected VtrainBusinessVideoListBean(Parcel in) {
        Status = in.readInt();
        Description = in.readString();
        BelongPart = in.readInt();
        VideoSize = in.readInt();
        VideoFileID = in.readString();
        TrainID = in.readInt();
        VideoPic = in.readString();
        BVID = in.readInt();
        BusinessName = in.readString();
        LastUpdateTime = in.readString();
        BelongTech = in.readInt();
        VideoName = in.readString();
        AddTime = in.readString();
    }

    public static final Creator<VtrainBusinessVideoListBean> CREATOR = new Creator<VtrainBusinessVideoListBean>() {
        @Override
        public VtrainBusinessVideoListBean createFromParcel(Parcel in) {
            return new VtrainBusinessVideoListBean(in);
        }

        @Override
        public VtrainBusinessVideoListBean[] newArray(int size) {
            return new VtrainBusinessVideoListBean[size];
        }
    };

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getBelongPart() {
        return BelongPart;
    }

    public void setBelongPart(int BelongPart) {
        this.BelongPart = BelongPart;
    }

    public int getVideoSize() {
        return VideoSize;
    }

    public void setVideoSize(int VideoSize) {
        this.VideoSize = VideoSize;
    }

    public String getVideoFileID() {
        return VideoFileID;
    }

    public void setVideoFileID(String VideoFileID) {
        this.VideoFileID = VideoFileID;
    }

    public int getTrainID() {
        return TrainID;
    }

    public void setTrainID(int TrainID) {
        this.TrainID = TrainID;
    }

    public String getVideoPic() {
        return VideoPic;
    }

    public void setVideoPic(String VideoPic) {
        this.VideoPic = VideoPic;
    }

    public int getBVID() {
        return BVID;
    }

    public void setBVID(int BVID) {
        this.BVID = BVID;
    }

    public String getBusinessName() {
        return BusinessName;
    }

    public void setBusinessName(String BusinessName) {
        this.BusinessName = BusinessName;
    }

    public String getLastUpdateTime() {
        return LastUpdateTime;
    }

    public void setLastUpdateTime(String LastUpdateTime) {
        this.LastUpdateTime = LastUpdateTime;
    }

    public int getBelongTech() {
        return BelongTech;
    }

    public void setBelongTech(int BelongTech) {
        this.BelongTech = BelongTech;
    }

    public String getVideoName() {
        return VideoName;
    }

    public void setVideoName(String VideoName) {
        this.VideoName = VideoName;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String AddTime) {
        this.AddTime = AddTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Status);
        parcel.writeString(Description);
        parcel.writeInt(BelongPart);
        parcel.writeInt(VideoSize);
        parcel.writeString(VideoFileID);
        parcel.writeInt(TrainID);
        parcel.writeString(VideoPic);
        parcel.writeInt(BVID);
        parcel.writeString(BusinessName);
        parcel.writeString(LastUpdateTime);
        parcel.writeInt(BelongTech);
        parcel.writeString(VideoName);
        parcel.writeString(AddTime);
    }
}
