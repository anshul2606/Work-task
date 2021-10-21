package com.empire.mylibrary;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Connect {

    public String resp = "";

    public void toast(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void showAlertDialog(Context mContext, String title, String msg, String positive_btn_nm) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(positive_btn_nm, (dialog, which) -> {
            dialog.cancel();
        });
        builder.show();
    }

    public String getDashboardData_R(Context mContext, String user_id, String route, String version_code, String token) {

        Api api = ApiClient.getClient().create(Api.class);
        Map<String, String> params = new HashMap<>();

        params.put("user_id", user_id);
        params.put("route", route);
        params.put("ER_app_version", version_code);

        api.getDashboardData(params, "Bearer " + token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    try {
                        String res = response.body().string();

                        resp = res;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                resp = "";
            }
        });
        return resp;
    }

}
