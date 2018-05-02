package com.qzbc.cpqp.qzbc.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2018/5/2.
 */
public class WholeBean implements Serializable{

    private boolean Result;
    private int TrainID;
    private String VtrainModelFile;
    private String Notice;
    private String VtrainName;
    private List<SceneModelListBean> SceneModelList;
    private List<VtrainSceneStepListBean> VtrainSceneStepList;
    private List<EventListBean> EventList;
    private List<VtrainSceneListBean> VtrainSceneList;
    private List<VtrainBusinessMenuListBean> VtrainBusinessMenuList;
    private List<VtrainBusinessVideoListBean> VtrainBusinessVideoList;

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public int getTrainID() {
        return TrainID;
    }

    public void setTrainID(int TrainID) {
        this.TrainID = TrainID;
    }

    public String getVtrainModelFile() {
        return VtrainModelFile;
    }

    public void setVtrainModelFile(String VtrainModelFile) {
        this.VtrainModelFile = VtrainModelFile;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String Notice) {
        this.Notice = Notice;
    }

    public String getVtrainName() {
        return VtrainName;
    }

    public void setVtrainName(String VtrainName) {
        this.VtrainName = VtrainName;
    }

    public List<SceneModelListBean> getSceneModelList() {
        return SceneModelList;
    }

    public void setSceneModelList(List<SceneModelListBean> SceneModelList) {
        this.SceneModelList = SceneModelList;
    }

    public List<VtrainSceneStepListBean> getVtrainSceneStepList() {
        return VtrainSceneStepList;
    }

    public void setVtrainSceneStepList(List<VtrainSceneStepListBean> VtrainSceneStepList) {
        this.VtrainSceneStepList = VtrainSceneStepList;
    }

    public List<EventListBean> getEventList() {
        return EventList;
    }

    public void setEventList(List<EventListBean> EventList) {
        this.EventList = EventList;
    }

    public List<VtrainSceneListBean> getVtrainSceneList() {
        return VtrainSceneList;
    }

    public void setVtrainSceneList(List<VtrainSceneListBean> VtrainSceneList) {
        this.VtrainSceneList = VtrainSceneList;
    }

    public List<VtrainBusinessMenuListBean> getVtrainBusinessMenuList() {
        return VtrainBusinessMenuList;
    }

    public void setVtrainBusinessMenuList(List<VtrainBusinessMenuListBean> VtrainBusinessMenuList) {
        this.VtrainBusinessMenuList = VtrainBusinessMenuList;
    }

    public List<VtrainBusinessVideoListBean> getVtrainBusinessVideoList() {
        return VtrainBusinessVideoList;
    }

    public void setVtrainBusinessVideoList(List<VtrainBusinessVideoListBean> VtrainBusinessVideoList) {
        this.VtrainBusinessVideoList = VtrainBusinessVideoList;
    }

    public static class SceneModelListBean implements Serializable {
        private int Status;
        private String SpecialModelTiptext;
        private String SceneModelAngle;
        private String SpecialModelVoice;
        private int SceneModelScale;
        private int ModelType;
        private String SceneModelFile;
        private int SceneID;
        private int PickupStatus;
        private String SceneModelName;
        private String SceneModelCoordinate;
        private int SceneModelID;
        private String AddTime;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getSpecialModelTiptext() {
            return SpecialModelTiptext;
        }

        public void setSpecialModelTiptext(String SpecialModelTiptext) {
            this.SpecialModelTiptext = SpecialModelTiptext;
        }

        public String getSceneModelAngle() {
            return SceneModelAngle;
        }

        public void setSceneModelAngle(String SceneModelAngle) {
            this.SceneModelAngle = SceneModelAngle;
        }

        public String getSpecialModelVoice() {
            return SpecialModelVoice;
        }

        public void setSpecialModelVoice(String SpecialModelVoice) {
            this.SpecialModelVoice = SpecialModelVoice;
        }

        public int getSceneModelScale() {
            return SceneModelScale;
        }

        public void setSceneModelScale(int SceneModelScale) {
            this.SceneModelScale = SceneModelScale;
        }

        public int getModelType() {
            return ModelType;
        }

        public void setModelType(int ModelType) {
            this.ModelType = ModelType;
        }

        public String getSceneModelFile() {
            return SceneModelFile;
        }

        public void setSceneModelFile(String SceneModelFile) {
            this.SceneModelFile = SceneModelFile;
        }

        public int getSceneID() {
            return SceneID;
        }

        public void setSceneID(int SceneID) {
            this.SceneID = SceneID;
        }

        public int getPickupStatus() {
            return PickupStatus;
        }

        public void setPickupStatus(int PickupStatus) {
            this.PickupStatus = PickupStatus;
        }

        public String getSceneModelName() {
            return SceneModelName;
        }

        public void setSceneModelName(String SceneModelName) {
            this.SceneModelName = SceneModelName;
        }

        public String getSceneModelCoordinate() {
            return SceneModelCoordinate;
        }

        public void setSceneModelCoordinate(String SceneModelCoordinate) {
            this.SceneModelCoordinate = SceneModelCoordinate;
        }

        public int getSceneModelID() {
            return SceneModelID;
        }

        public void setSceneModelID(int SceneModelID) {
            this.SceneModelID = SceneModelID;
        }

        public String getAddTime() {
            return AddTime;
        }

        public void setAddTime(String AddTime) {
            this.AddTime = AddTime;
        }
    }

    public static class VtrainSceneStepListBean implements Serializable {

        private int NextSceneStepID;
        private int Status;
        private int AutoEventID;
        private int SceneStepModelID;
        private int OrderNum;
        private String SceneStepName;
        private int SceneID;
        private String FrontEventID;
        private String AddTime;
        private int SceneStepID;

        public int getNextSceneStepID() {
            return NextSceneStepID;
        }

        public void setNextSceneStepID(int NextSceneStepID) {
            this.NextSceneStepID = NextSceneStepID;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getAutoEventID() {
            return AutoEventID;
        }

        public void setAutoEventID(int AutoEventID) {
            this.AutoEventID = AutoEventID;
        }

        public int getSceneStepModelID() {
            return SceneStepModelID;
        }

        public void setSceneStepModelID(int SceneStepModelID) {
            this.SceneStepModelID = SceneStepModelID;
        }

        public int getOrderNum() {
            return OrderNum;
        }

        public void setOrderNum(int OrderNum) {
            this.OrderNum = OrderNum;
        }

        public String getSceneStepName() {
            return SceneStepName;
        }

        public void setSceneStepName(String SceneStepName) {
            this.SceneStepName = SceneStepName;
        }

        public int getSceneID() {
            return SceneID;
        }

        public void setSceneID(int SceneID) {
            this.SceneID = SceneID;
        }

        public String getFrontEventID() {
            return FrontEventID;
        }

        public void setFrontEventID(String FrontEventID) {
            this.FrontEventID = FrontEventID;
        }

        public String getAddTime() {
            return AddTime;
        }

        public void setAddTime(String AddTime) {
            this.AddTime = AddTime;
        }

        public int getSceneStepID() {
            return SceneStepID;
        }

        public void setSceneStepID(int SceneStepID) {
            this.SceneStepID = SceneStepID;
        }
    }

    public static class EventListBean  implements Serializable{
        private String EventName;
        private String ShowModelID;
        private String TipVoiceFile;
        private int EventObjectDisplacementSwitch;
        private String HandleBackgroundPic;
        private String VrTipText;
        private String EventObjectZoomRatio;
        private String SpecialModelID;
        private int EventObjectModelID;
        private int EventProcessContinuityTime;
        private int EventType;
        private int EventID;
        private int CorrectModelStatus;
        private String CameraCoordinate;
        private String EventObjectRotateCoordinate;
        private String HideModelID;
        private int Status;
        private int EventProcessHandleVibration;
        private int CorrectSceneModelID;
        private String EventProcessSound;
        private int OrderNum;
        private int EventObjectRotateSwitch;
        private String PanelTipText;
        private int SceneID;
        private int EventObjectZoomSwitch;
        private String EventObjectDisplacementCoordinate;
        private String AddTime;
        private int EventProcessSpecialEffects;

        public String getEventName() {
            return EventName;
        }

        public void setEventName(String EventName) {
            this.EventName = EventName;
        }

        public String getShowModelID() {
            return ShowModelID;
        }

        public void setShowModelID(String ShowModelID) {
            this.ShowModelID = ShowModelID;
        }

        public String getTipVoiceFile() {
            return TipVoiceFile;
        }

        public void setTipVoiceFile(String TipVoiceFile) {
            this.TipVoiceFile = TipVoiceFile;
        }

        public int getEventObjectDisplacementSwitch() {
            return EventObjectDisplacementSwitch;
        }

        public void setEventObjectDisplacementSwitch(int EventObjectDisplacementSwitch) {
            this.EventObjectDisplacementSwitch = EventObjectDisplacementSwitch;
        }

        public String getHandleBackgroundPic() {
            return HandleBackgroundPic;
        }

        public void setHandleBackgroundPic(String HandleBackgroundPic) {
            this.HandleBackgroundPic = HandleBackgroundPic;
        }

        public String getVrTipText() {
            return VrTipText;
        }

        public void setVrTipText(String VrTipText) {
            this.VrTipText = VrTipText;
        }

        public String getEventObjectZoomRatio() {
            return EventObjectZoomRatio;
        }

        public void setEventObjectZoomRatio(String EventObjectZoomRatio) {
            this.EventObjectZoomRatio = EventObjectZoomRatio;
        }

        public String getSpecialModelID() {
            return SpecialModelID;
        }

        public void setSpecialModelID(String SpecialModelID) {
            this.SpecialModelID = SpecialModelID;
        }

        public int getEventObjectModelID() {
            return EventObjectModelID;
        }

        public void setEventObjectModelID(int EventObjectModelID) {
            this.EventObjectModelID = EventObjectModelID;
        }

        public int getEventProcessContinuityTime() {
            return EventProcessContinuityTime;
        }

        public void setEventProcessContinuityTime(int EventProcessContinuityTime) {
            this.EventProcessContinuityTime = EventProcessContinuityTime;
        }

        public int getEventType() {
            return EventType;
        }

        public void setEventType(int EventType) {
            this.EventType = EventType;
        }

        public int getEventID() {
            return EventID;
        }

        public void setEventID(int EventID) {
            this.EventID = EventID;
        }

        public int getCorrectModelStatus() {
            return CorrectModelStatus;
        }

        public void setCorrectModelStatus(int CorrectModelStatus) {
            this.CorrectModelStatus = CorrectModelStatus;
        }

        public String getCameraCoordinate() {
            return CameraCoordinate;
        }

        public void setCameraCoordinate(String CameraCoordinate) {
            this.CameraCoordinate = CameraCoordinate;
        }

        public String getEventObjectRotateCoordinate() {
            return EventObjectRotateCoordinate;
        }

        public void setEventObjectRotateCoordinate(String EventObjectRotateCoordinate) {
            this.EventObjectRotateCoordinate = EventObjectRotateCoordinate;
        }

        public String getHideModelID() {
            return HideModelID;
        }

        public void setHideModelID(String HideModelID) {
            this.HideModelID = HideModelID;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getEventProcessHandleVibration() {
            return EventProcessHandleVibration;
        }

        public void setEventProcessHandleVibration(int EventProcessHandleVibration) {
            this.EventProcessHandleVibration = EventProcessHandleVibration;
        }

        public int getCorrectSceneModelID() {
            return CorrectSceneModelID;
        }

        public void setCorrectSceneModelID(int CorrectSceneModelID) {
            this.CorrectSceneModelID = CorrectSceneModelID;
        }

        public String getEventProcessSound() {
            return EventProcessSound;
        }

        public void setEventProcessSound(String EventProcessSound) {
            this.EventProcessSound = EventProcessSound;
        }

        public int getOrderNum() {
            return OrderNum;
        }

        public void setOrderNum(int OrderNum) {
            this.OrderNum = OrderNum;
        }

        public int getEventObjectRotateSwitch() {
            return EventObjectRotateSwitch;
        }

        public void setEventObjectRotateSwitch(int EventObjectRotateSwitch) {
            this.EventObjectRotateSwitch = EventObjectRotateSwitch;
        }

        public String getPanelTipText() {
            return PanelTipText;
        }

        public void setPanelTipText(String PanelTipText) {
            this.PanelTipText = PanelTipText;
        }

        public int getSceneID() {
            return SceneID;
        }

        public void setSceneID(int SceneID) {
            this.SceneID = SceneID;
        }

        public int getEventObjectZoomSwitch() {
            return EventObjectZoomSwitch;
        }

        public void setEventObjectZoomSwitch(int EventObjectZoomSwitch) {
            this.EventObjectZoomSwitch = EventObjectZoomSwitch;
        }

        public String getEventObjectDisplacementCoordinate() {
            return EventObjectDisplacementCoordinate;
        }

        public void setEventObjectDisplacementCoordinate(String EventObjectDisplacementCoordinate) {
            this.EventObjectDisplacementCoordinate = EventObjectDisplacementCoordinate;
        }

        public String getAddTime() {
            return AddTime;
        }

        public void setAddTime(String AddTime) {
            this.AddTime = AddTime;
        }

        public int getEventProcessSpecialEffects() {
            return EventProcessSpecialEffects;
        }

        public void setEventProcessSpecialEffects(int EventProcessSpecialEffects) {
            this.EventProcessSpecialEffects = EventProcessSpecialEffects;
        }
    }

    public static class VtrainSceneListBean implements Serializable {

        private int Status;
        private int TrainID;
        private int SceneEntranceStepID;
        private String ScenePic;
        private int SceneID;
        private String SceneName;
        private String AddTime;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getTrainID() {
            return TrainID;
        }

        public void setTrainID(int TrainID) {
            this.TrainID = TrainID;
        }

        public int getSceneEntranceStepID() {
            return SceneEntranceStepID;
        }

        public void setSceneEntranceStepID(int SceneEntranceStepID) {
            this.SceneEntranceStepID = SceneEntranceStepID;
        }

        public String getScenePic() {
            return ScenePic;
        }

        public void setScenePic(String ScenePic) {
            this.ScenePic = ScenePic;
        }

        public int getSceneID() {
            return SceneID;
        }

        public void setSceneID(int SceneID) {
            this.SceneID = SceneID;
        }

        public String getSceneName() {
            return SceneName;
        }

        public void setSceneName(String SceneName) {
            this.SceneName = SceneName;
        }

        public String getAddTime() {
            return AddTime;
        }

        public void setAddTime(String AddTime) {
            this.AddTime = AddTime;
        }
    }

    public static class VtrainBusinessMenuListBean  implements Serializable, Parcelable{

        private int Status;
        private int MenuType;
        private int TrainID;
        private String MenuName;
        private String ExtraCompanyName;
        private int BMID;
        private int SceneID;
        private int MenuLevel;
        private int ParentBMID;
        private String ExtraCompanyInfo;
        private String AddTime;

        protected VtrainBusinessMenuListBean(Parcel in) {
            Status = in.readInt();
            MenuType = in.readInt();
            TrainID = in.readInt();
            MenuName = in.readString();
            ExtraCompanyName = in.readString();
            BMID = in.readInt();
            SceneID = in.readInt();
            MenuLevel = in.readInt();
            ParentBMID = in.readInt();
            ExtraCompanyInfo = in.readString();
            AddTime = in.readString();
        }

        public static final Creator<VtrainBusinessMenuListBean> CREATOR = new Creator<VtrainBusinessMenuListBean>() {
            @Override
            public VtrainBusinessMenuListBean createFromParcel(Parcel in) {
                return new VtrainBusinessMenuListBean(in);
            }

            @Override
            public VtrainBusinessMenuListBean[] newArray(int size) {
                return new VtrainBusinessMenuListBean[size];
            }
        };

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getMenuType() {
            return MenuType;
        }

        public void setMenuType(int MenuType) {
            this.MenuType = MenuType;
        }

        public int getTrainID() {
            return TrainID;
        }

        public void setTrainID(int TrainID) {
            this.TrainID = TrainID;
        }

        public String getMenuName() {
            return MenuName;
        }

        public void setMenuName(String MenuName) {
            this.MenuName = MenuName;
        }

        public String getExtraCompanyName() {
            return ExtraCompanyName;
        }

        public void setExtraCompanyName(String ExtraCompanyName) {
            this.ExtraCompanyName = ExtraCompanyName;
        }

        public int getBMID() {
            return BMID;
        }

        public void setBMID(int BMID) {
            this.BMID = BMID;
        }

        public int getSceneID() {
            return SceneID;
        }

        public void setSceneID(int SceneID) {
            this.SceneID = SceneID;
        }

        public int getMenuLevel() {
            return MenuLevel;
        }

        public void setMenuLevel(int MenuLevel) {
            this.MenuLevel = MenuLevel;
        }

        public int getParentBMID() {
            return ParentBMID;
        }

        public void setParentBMID(int ParentBMID) {
            this.ParentBMID = ParentBMID;
        }

        public String getExtraCompanyInfo() {
            return ExtraCompanyInfo;
        }

        public void setExtraCompanyInfo(String ExtraCompanyInfo) {
            this.ExtraCompanyInfo = ExtraCompanyInfo;
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
            parcel.writeInt(MenuType);
            parcel.writeInt(TrainID);
            parcel.writeString(MenuName);
            parcel.writeString(ExtraCompanyName);
            parcel.writeInt(BMID);
            parcel.writeInt(SceneID);
            parcel.writeInt(MenuLevel);
            parcel.writeInt(ParentBMID);
            parcel.writeString(ExtraCompanyInfo);
            parcel.writeString(AddTime);
        }
    }

    public static class VtrainBusinessVideoListBean  implements Serializable, Parcelable {

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
}
