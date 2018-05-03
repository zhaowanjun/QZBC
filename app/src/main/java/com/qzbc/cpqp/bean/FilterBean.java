package com.qzbc.cpqp.bean;

import java.util.List;

/**
 * Created by admin on 2018/5/3.
 */
public class FilterBean {

    private boolean Result;
    private String Notice;
    private List<VtrainBusinessVideoListBean> VtrainBusinessVideoList;

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String Notice) {
        this.Notice = Notice;
    }

    public List<VtrainBusinessVideoListBean> getVtrainBusinessVideoList() {
        return VtrainBusinessVideoList;
    }

    public void setVtrainBusinessVideoList(List<VtrainBusinessVideoListBean> VtrainBusinessVideoList) {
        this.VtrainBusinessVideoList = VtrainBusinessVideoList;
    }

}
