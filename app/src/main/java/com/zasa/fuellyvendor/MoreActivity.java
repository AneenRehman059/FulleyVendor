package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.models.App_Detail_Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_hello, tv_vendor_name, tv_about, tv_sub_about, tv_call_center, tv_sub_call_center,
            tv_complain, tv_sub_complain, tv_share, tv_sub_share, tv_more;
    ShapeableImageView pumpImage;
    final int radius = 20, margin = 0;
    RelativeLayout more_layout;
    LinearLayout share, about_us, call_us, complain_us, prof_layout;
    LinearLayout ly1, ly2, ly3, ly4;
    Button shareBtn, viewProf;
    ImageView back;
    LinearLayoutCompat layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


        getid();

        setDarkMode();

        back.setOnClickListener(this);
        complain_us.setOnClickListener(this);
        call_us.setOnClickListener(this);
        about_us.setOnClickListener(this);
//        viewProf.setOnClickListener(this);
        share.setOnClickListener(this);

//        Call<App_Detail_Request> call = ApiClient.getApiService().appDetails("FV");
//        call.enqueue(new Callback<App_Detail_Request>() {
//            @Override
//            public void onResponse(Call<App_Detail_Request> call, Response<App_Detail_Request> response) {
//                App_Detail_Request requestApi = response.body();
//                if (response.isSuccessful()) {
//                    Transformation transformation = new RoundedCornersTransformation(radius, margin);
//                    Picasso.get().load(requestApi.getApp_Details().getImageUrl())
//                            .memoryPolicy(MemoryPolicy.NO_CACHE)
//                            .networkPolicy(NetworkPolicy.NO_CACHE)
//                            .transform(transformation)
//                            .error(R.drawable.no_image)
//                            .into(pumpImage);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<App_Detail_Request> call, Throwable t) {
//
//            }
//        });

    }

    private void getid() {
        more_layout = findViewById(R.id.lay_more);
        ly1 = findViewById(R.id.ly1);
        ly2 = findViewById(R.id.ly2);
        ly3 = findViewById(R.id.ly3);
        ly4 = findViewById(R.id.ly4);
//        prof_layout = findViewById(R.id.profLayout);
        tv_more = findViewById(R.id.tvMore);
        layout = findViewById(R.id.moreLayout);
        tv_share = findViewById(R.id.tvShare);
        tv_sub_share = findViewById(R.id.tvSub_share);
        tv_complain = findViewById(R.id.tvComplain);
        tv_sub_complain = findViewById(R.id.tvSub_complain);
        tv_call_center = findViewById(R.id.tvCall_center);
        tv_sub_call_center = findViewById(R.id.tvSub_call_center);
        tv_about = findViewById(R.id.tvAbout);
        tv_sub_about = findViewById(R.id.tvsubAbout);
//        tv_hello = findViewById(R.id.tvHello);
//        tv_vendor_name = findViewById(R.id.tvVerdor_name);
//        pumpImage = findViewById(R.id.pumpPic);
//        viewProf = findViewById(R.id.btn_view_prof);
        about_us = findViewById(R.id.about);
        call_us = findViewById(R.id.call_center);
        complain_us = findViewById(R.id.complain);
        share = findViewById(R.id.shareApp);
        back = findViewById(R.id.backimg);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_img) {
            MoreActivity.this.onBackPressed();
        } else if (v.getId() == R.id.complain) {
            Intent intent = new Intent(MoreActivity.this, ComplaintActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.call_center) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+923341999555"));
            startActivity(callIntent);
        } else if (v.getId() == R.id.about) {
            gotoUrl("http://zasasolutions.com/");
        }
//        else if (v.getId() == R.id.btn_view_prof) {
//            Intent intent = new Intent(MoreActivity.this.getApplication(), Edit_Profile_tpin.class);
//            startActivity(intent);
//        }
        else if (v.getId() == R.id.shareApp) {
            String shareBody = "Share app via";
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(intent, "Share App"));
        }
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void setDarkMode() {
        Helper.setDarkModeOnOff(MoreActivity.this, layout);

        if (PrefsManager.IsDarkModeOn()) {
            back.setColorFilter(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            more_layout.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
//            prof_layout.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_more.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            ly1.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.primary, MoreActivity.this.getTheme()));
            ly2.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.primary, MoreActivity.this.getTheme()));
            ly3.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.primary, MoreActivity.this.getTheme()));
            ly4.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.primary, MoreActivity.this.getTheme()));
            about_us.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            complain_us.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            call_us.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            share.setBackgroundColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
//            tv_hello.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
//            tv_vendor_name.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
//            viewProf.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_about.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_sub_about.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_complain.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_sub_complain.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_call_center.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_sub_call_center.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_share.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_sub_share.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
        } else {
            tv_more.setTextColor(MoreActivity.this.getResources().getColor(R.color.white, MoreActivity.this.getTheme()));
            tv_hello.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_vendor_name.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            viewProf.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_about.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_sub_about.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_complain.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_sub_complain.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_call_center.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_sub_call_center.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_share.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
            tv_sub_share.setTextColor(MoreActivity.this.getResources().getColor(R.color.black, MoreActivity.this.getTheme()));
        }
    }
}