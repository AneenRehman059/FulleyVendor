package com.zasa.fuellyvendor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.squareup.picasso.Picasso;
import com.zasa.fuellyvendor.AutoLogout.BaseActivity;
import com.zasa.fuellyvendor.Fragments.LedgerFragment;
import com.zasa.fuellyvendor.Fragments.MoreFragment;
import com.zasa.fuellyvendor.Fragments.SettingsFragment;
import com.zasa.fuellyvendor.models.App_Detail_Request;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.databinding.ActivityHomeBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends BaseActivity  {
    ActivityHomeBinding binding;
    BottomNavigationView bottomNavigationView;
    Context context;
    TextView btn_scan;
    String AdsImageActivity,AdsLinksFromServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context= HomeActivity.this;

//        Call<App_Detail_Request> call =ApiClient.getApiService().appDetails("FV");
//        call.enqueue(new Callback<App_Detail_Request>() {
//            @Override
//            public void onResponse(Call<App_Detail_Request> call, Response<App_Detail_Request> response) {
//                App_Detail_Request app_detail_request = response.body();
//                if (response.isSuccessful()){
//                    assert app_detail_request != null;
//                    if (app_detail_request.getApp_Details().getAddFlag().equals("Y")) {
////                        openDialog();
//
////                        Activity activity = new Activity();
////                        if (activity != null) {
////                            String AdsImage = app_detail_request.getApp_Details().getImageUrl();
////                            String AddLink = app_detail_request.getApp_Details().getAddLink();
////
////                            Intent intent = new Intent(HomeActivity.this, AdsActivity.class);
////                            intent.putExtra("AdImage", AdsImage);
////                            intent.putExtra("AadLink",AddLink);
////                            startActivity(intent);
////                        }
//
//                        ViewGroup viewGroup = findViewById(android.R.id.content);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
//                        View view1 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.flag_dialog,viewGroup,false);
//                        ImageButton close;
//                        ImageView Imgaad;
//                        TextView more_txt;
//
//                        more_txt = view1.findViewById(R.id.more_txt);
//                        Imgaad = view1.findViewById(R.id.Aadimg);
//                        close = view1.findViewById(R.id.btn_dialog);
//                        builder.setCancelable(false);
//                        builder.setView(view1);
//
//                        final AlertDialog alertDialog = builder.create();
//
//                        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                        close.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                alertDialog.dismiss();
//                            }
//                        });
//                        alertDialog.show();
//
//                        String backgroundImage = app_detail_request.getApp_Details().getImageUrl();
//                        Picasso.get().load(backgroundImage).into(Imgaad);
//
//                        more_txt.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                String app_link = app_detail_request.getApp_Details().getAddLink();
//                                gotoUrl(app_link);
//                            }
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<App_Detail_Request> call, Throwable t) {
//                Toast.makeText(HomeActivity.this, "Failure", Toast.LENGTH_SHORT).show();
//            }
//        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkFlag();
        initView();

    }

    public void checkFlag() {
//        AnimatedDialog.show();
        Call<App_Detail_Request> call = ApiClient.getApiService().appDetails("FV");
        call.enqueue(new Callback<App_Detail_Request>() {
            @Override
            public void onResponse(Call<App_Detail_Request> call, Response<App_Detail_Request> response) {
                App_Detail_Request requestApi = response.body();
                if (response.isSuccessful()) {
                    assert requestApi != null;

                    if (requestApi.getApp_Details().getAddFlag().equals("Y")) {
                        AdsImageActivity = requestApi.getApp_Details().getImageUrl();
                        AdsLinksFromServer = requestApi.getApp_Details().getAddLink();
                        openDialog();
//                        Activity activity = getActivity();
//                        if (activity != null) {
//                             = requestApi.getApp_Details().getAdd_Image_Url();
//                            String AdsLink=requestApi.getApp_Details().getAdd_Link();
//                            Intent intent = new Intent(requireActivity(), AdsActivity.class);
//                            intent.putExtra("AdImage", AdsImage);
//                            intent.putExtra("adslink",AdsLink);
//                            startActivity(intent);
//                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<App_Detail_Request> call, Throwable t) {
                Toast.makeText(context, "Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initView() {

        btn_scan = findViewById(R.id.btnFuelly);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ScannerViewActivity.class));
            }
        });
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce_animation);
        btn_scan.startAnimation(animation);

        loadFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        //set home selected
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, new HomeFragment());
        transaction.commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home)
                loadFragment(new HomeFragment());

            else if (item.getItemId() == R.id.ledger) {
                loadFragment(new LedgerFragment());
            }

            else if (item.getItemId() == R.id.more) {
                loadFragment(new MoreFragment());
            }
            else if (item.getItemId() == R.id.settings) {
                loadFragment(new SettingsFragment());
            }
            return true;
        });
    }

    private void openDialog() {
        ImageView imageView;
        ImageView ivCross;
        TextView tvReadMore;
        ViewGroup viewGroup = findViewById(android.R.id.content);
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        View view1 = LayoutInflater.from(this).inflate(R.layout.flag_dialog, viewGroup, false);
        builder.setCancelable(false);
        builder.setView(view1);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setView(view1);
        imageView = view1.findViewById(R.id.Aadimg);
        ivCross = view1.findViewById(R.id.btn_dialog);
        tvReadMore = view1.findViewById(R.id.more_txt);
        Picasso.get().load(AdsImageActivity).into(imageView);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        alertDialog.show();

        ivCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        tvReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AdsLink = AdsLinksFromServer;
                Uri webpage = Uri.parse(AdsLink);
                if (!AdsLink.startsWith("http://") && !AdsLink.startsWith("https://")) {
                    webpage = Uri.parse("http://" + AdsLink);
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);

            }
        });
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    //disable Nav drawer in fragments
//    public void setDrawerLocked() {
//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
//    }
//
//    public void setDrawerUnlocked() {
//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
//    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}