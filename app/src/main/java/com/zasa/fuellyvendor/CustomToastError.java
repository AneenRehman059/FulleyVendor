package com.zasa.fuellyvendor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToastError {


    // Custom Toast Method
    public void Show_Toast(Context context, View view, String exceptionMessage) {

        if (context != null) {
            if (!((Activity) context).isFinishing()) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.flag_dialog);
                ImageButton dialogButton = dialog.findViewById(R.id.btn_dialog);
                dialogButton.setOnClickListener(v -> dialog.dismiss());
                dialog.show();
                Window window = dialog.getWindow();
                if (window != null) {
                    window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    window.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent)));
                }
            } else {

            }
        }
    }

}
