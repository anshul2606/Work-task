package com.empire.mylibrary;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class Connect {


    public Connect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

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

        String resp = "";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Api api = ApiClient.getClient().create(Api.class);
        Map<String, String> params = new HashMap<>();

        params.put("user_id", user_id);
        params.put("route", route);
        params.put("ER_app_version", version_code);

        try {
            Response<ResponseBody> response = api.getDashboardData(params, "Bearer " + token).execute();

            if (response.isSuccessful()) {
                resp = response.body().string();
            }
        } catch (Exception e) {
            resp = e.getMessage();
        }

        return resp;
    }

}
