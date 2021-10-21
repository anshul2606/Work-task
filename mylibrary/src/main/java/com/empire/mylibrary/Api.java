package com.empire.mylibrary;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("get-dashboard-data")
    Call<ResponseBody> getDashboardData(@FieldMap Map<String, String> params, @Header("Authorization") String token);

}
