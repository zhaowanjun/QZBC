package com.qzbc.cpqp.qzbc.api;

import com.qzbc.cpqp.qzbc.bean.Entiry;
import com.qzbc.cpqp.qzbc.bean.WholeBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by admin on 2018/5/2.
 */
public interface QZBCApi {

    @POST("sdvrpi/vapp.VTrain.getDataOfVTrain.hf")
    Call<WholeBean> getWholeData(@Body Entiry entiry);

}
