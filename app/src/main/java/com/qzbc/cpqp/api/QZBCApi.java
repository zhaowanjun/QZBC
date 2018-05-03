package com.qzbc.cpqp.api;

import com.qzbc.cpqp.bean.Entiry;
import com.qzbc.cpqp.bean.FilterBean;
import com.qzbc.cpqp.bean.SeekEntiry;
import com.qzbc.cpqp.bean.WholeBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by admin on 2018/5/2.
 */
public interface QZBCApi {

    @POST("vapp.VTrain.getDataOfVTrain.hf")
    Call<WholeBean> getWholeData(@Body Entiry entiry);

    @POST("vapp.VTrain.vtrainAPPSearchVideo.hf")
    Call<FilterBean> seekVideoData(@Body SeekEntiry seekEntiry);

    @POST("vapp.VTrain.vtrainAPPSearchVideo.hf")
    Call<FilterBean> searchVideoData(@Body SeekEntiry seekEntiry);

}
