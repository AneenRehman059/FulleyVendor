package com.zasa.fuellyvendor;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.Nullable;

public class Alerts {

    Context context;

    @Nullable
    Dialog progressDialog;

    public Alerts(Context context) {
        this.context = context;
    }

    public static Dialog showAnimatedLoadingIndicator(Context context) {
        Dialog progressDialog = new Dialog(context);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.custom_dialog_progress);

        /* Custom setting to change TextView text,Color and Text Size according to your Preference*/

        TextView progressTv = progressDialog.findViewById(R.id.progress_tv);
        progressTv.setText("Please wait...");
        progressTv.setTextColor(ContextCompat.getColor(context, R.color.white));
        progressTv.setTextSize(15F);

        if (progressDialog.getWindow() != null)
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));///TRANSPARENT background
        progressDialog.setCancelable(false);
        //progressDialog.show();

        return progressDialog;
    }

    public static void dismissAnimatedLoadingIndicator(Context context) {
        Dialog progressDialog = new Dialog(context);

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

      /*  if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }*/
    }


}
