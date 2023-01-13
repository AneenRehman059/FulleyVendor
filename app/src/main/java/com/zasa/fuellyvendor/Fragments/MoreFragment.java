package com.zasa.fuellyvendor.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.zasa.fuellyvendor.ComplaintActivity;
import com.zasa.fuellyvendor.Edit_Profile_tpin;
import com.zasa.fuellyvendor.Helper;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.PrefsManager;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.RoundedCornersTransformation;
import com.zasa.fuellyvendor.models.App_Detail_Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoreFragment extends Fragment implements View.OnClickListener {

    TextView tv_hello, tv_vendor_name, tv_about, tv_sub_about, tv_call_center, tv_sub_call_center,
            tv_complain, tv_sub_complain, tv_share, tv_sub_share, tv_more;
    ShapeableImageView pumpImage;
    final int radius = 20, margin = 0;
    LinearLayout share, about_us, call_us, complain_us, prof_layout;
    LinearLayout ly1 , ly2 , ly3 , ly4;
    Button shareBtn, viewProf;
    ImageView back;
    LinearLayoutCompat layout;
    View view;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more, container, false);

        getid();

        setDarkMode();

        back.setOnClickListener(this);
        complain_us.setOnClickListener(this);
        call_us.setOnClickListener(this);
        about_us.setOnClickListener(this);
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

        return view;
    }

    private void getid() {

        ly1 = view.findViewById(R.id.ly1);
        ly2 = view.findViewById(R.id.ly2);
        ly3 = view.findViewById(R.id.ly3);
        ly4 = view.findViewById(R.id.ly4);
//        prof_layout = view.findViewById(R.id.profLayout);
        tv_more = view.findViewById(R.id.tvMore);
        layout = view.findViewById(R.id.moreLayout);
        tv_share = view.findViewById(R.id.tvShare);
        tv_sub_share = view.findViewById(R.id.tvSub_share);
        tv_complain = view.findViewById(R.id.tvComplain);
        tv_sub_complain = view.findViewById(R.id.tvSub_complain);
        tv_call_center = view.findViewById(R.id.tvCall_center);
        tv_sub_call_center = view.findViewById(R.id.tvSub_call_center);
        tv_about = view.findViewById(R.id.tvAbout);
        tv_sub_about = view.findViewById(R.id.tvsubAbout);
//        tv_hello = view.findViewById(R.id.tvHello);
//        tv_vendor_name = view.findViewById(R.id.tvVerdor_name);
//        pumpImage = view.findViewById(R.id.pumpPic);
//        viewProf = view.findViewById(R.id.btn_view_prof);
        about_us = view.findViewById(R.id.about);
        call_us = view.findViewById(R.id.call_center);
        complain_us = view.findViewById(R.id.complain);
        share = view.findViewById(R.id.shareApp);
        back = view.findViewById(R.id.btns_back);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ((HomeActivity)requireActivity()).setDrawerUnlocked();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_img) {
            getActivity().onBackPressed();
        } else if (v.getId() == R.id.complain) {
            Intent intent = new Intent(getContext(), ComplaintActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.call_center) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+923341999555"));
            startActivity(callIntent);
        } else if (v.getId() == R.id.about) {
            gotoUrl("http://zasasolutions.com/");
        }
//        else if (v.getId() == R.id.btn_view_prof) {
//            Intent intent = new Intent(getActivity().getApplication(), Edit_Profile_tpin.class);
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
        else  if (v.getId() == R.id.btns_back){
            Intent intent = new Intent(getContext(), HomeActivity.class);
            startActivity(intent);
        }
    }

    private void setDarkMode() {
        Helper.setDarkModeOnOff(getContext(), layout);

        if (PrefsManager.IsDarkModeOn()) {
            back.setColorFilter(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            about_us.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            call_us.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            complain_us.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            share.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_more.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_about.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_sub_about.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_complain.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_sub_complain.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_call_center.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_sub_call_center.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_share.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_sub_share.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
        } else {
            tv_more.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_about.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_sub_about.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_complain.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_sub_complain.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_call_center.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_sub_call_center.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_share.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_sub_share.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
        }
    }

}