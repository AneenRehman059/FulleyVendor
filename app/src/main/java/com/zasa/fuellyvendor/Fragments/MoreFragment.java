package com.zasa.fuellyvendor.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.zasa.fuellyvendor.ComplaintActivity;
import com.zasa.fuellyvendor.Edit_Profile_tpin;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.RoundedCornersTransformation;
import com.zasa.fuellyvendor.ViewProfile;
import com.zasa.fuellyvendor.models.App_Detail_Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoreFragment extends Fragment implements View.OnClickListener {

    ShapeableImageView pumpImage;
    final int radius = 20, margin = 0;
    LinearLayout share,about_us,call_us,complain_us;
    Button shareBtn,viewProf;
    ImageButton back;
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

        back.setOnClickListener(this);
        complain_us.setOnClickListener(this);
        call_us.setOnClickListener(this);
        about_us.setOnClickListener(this);
        viewProf.setOnClickListener(this);
        share.setOnClickListener(this);

        Call<App_Detail_Request> call = ApiClient.getApiService().appDetails("FV");
        call.enqueue(new Callback<App_Detail_Request>() {
            @Override
            public void onResponse(Call<App_Detail_Request> call, Response<App_Detail_Request> response) {
                App_Detail_Request requestApi = response.body();
                if (response.isSuccessful()){
                    Transformation transformation = new RoundedCornersTransformation(radius, margin);
                    Picasso.get().load(requestApi.getApp_Details().getImageUrl())
                            .memoryPolicy(MemoryPolicy.NO_CACHE)
                            .networkPolicy(NetworkPolicy.NO_CACHE)
                            .transform(transformation)
                            .error(R.drawable.no_image)
                            .into(pumpImage);
                }
            }

            @Override
            public void onFailure(Call<App_Detail_Request> call, Throwable t) {

            }
        });

        return view;
    }

    private void getid() {
        pumpImage = view.findViewById(R.id.pumpPic);
        viewProf = view.findViewById(R.id.btn_view_prof);
        about_us = view.findViewById(R.id.about);
        call_us = view.findViewById(R.id.call_center);
        complain_us = view.findViewById(R.id.complain);
        share = view.findViewById(R.id.shareApp);
        back = view.findViewById(R.id.back_img);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ((HomeActivity)requireActivity()).setDrawerUnlocked();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_img){
            getActivity().onBackPressed();
        }

        else if (v.getId() == R.id.complain){
            Intent intent = new Intent(getContext(), ComplaintActivity.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.call_center){
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+923341999555"));
            startActivity(callIntent);
        }

        else if (v.getId() == R.id.about){
            gotoUrl("http://zasasolutions.com/");
        }

        else if (v.getId() == R.id.btn_view_prof){
            Intent intent = new Intent(getActivity().getApplication(), Edit_Profile_tpin.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.shareApp){
            String shareBody = "Share app via";
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(intent,"Share App"));
        }
    }
}