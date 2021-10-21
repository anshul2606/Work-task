package com.empire.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class Connect {

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

}
