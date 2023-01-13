package com.zasa.fuellyvendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.zasa.fuellyvendor.Adapters.MainSliderImageAdapter;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.Request.Product_Wise_Request;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.FragmentHomeBinding;
import com.zasa.fuellyvendor.models.App_Detail_Request;
import com.zasa.fuellyvendor.models.App_Detail_Respone_Model;
import com.zasa.fuellyvendor.models.Product_Wise_Request_Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //    FragmentHomeBinding binding;
    LinearLayoutCompat layout_super, layout_hi_oct, layout_diesel;
    LinearLayoutCompat homeLayout;
    LinearLayout layoutInner;
    SliderView sliderView;
    MainSliderImageAdapter slider_adapter;
    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;
    Context context;
    TextView tv_super, tv_super_price, tv_hi_oct, tv_hi_oct_price, tv_diesel, tv_diesel_price, tv_cng, tv_cng_price, tv_welome, tv_today_sale, tvLtrs, tv_ltrsAmount,
            tv_settled_payment, tv_totalSettle_amount;
    ArrayList<App_Detail_Respone_Model.SliderApiModel> sliderApiModelArrayList = new ArrayList<>();
    ArrayList<Product_Wise_Request_Model> getApiList;

    FragmentHomeBinding binding;

    ImageView imageView, imageView2, notification_btn, logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        context = MainActivity.this;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        sharedPrefManager = new SharedPrefManager(context);

        getApiList = new ArrayList<Product_Wise_Request_Model>();
        layoutInner = findViewById(R.id.innerlayout);
        tv_super_price = findViewById(R.id.super_total_price);
        tv_hi_oct_price = findViewById(R.id.high_oct_total_price);
        tv_diesel_price = findViewById(R.id.diesel_total_price);
        tv_cng_price = findViewById(R.id.cng_total_price);
        tv_totalSettle_amount = findViewById(R.id.tv_settle_amount);
        tv_settled_payment = findViewById(R.id.tvSettled_payment);
        tv_ltrsAmount = findViewById(R.id.tv_ltrs_amount);
        tvLtrs = findViewById(R.id.tv_ltrs);
        tv_today_sale = findViewById(R.id.tvToday_sale);
        tv_welome = findViewById(R.id.tvHome);
        homeLayout = findViewById(R.id.layout_home);
        sliderView = findViewById(R.id.imageSlider);
        layout_super = findViewById(R.id.super_layout);
        layout_hi_oct = findViewById(R.id.hi_oct_layout);
        layout_diesel = findViewById(R.id.layout_diesel);

        imageView = findViewById(R.id.imageView);
        tv_super = findViewById(R.id.tvsuper_title);
        tv_hi_oct = findViewById(R.id.tvhiOct_title);
        tv_diesel = findViewById(R.id.tvdiesel_title);
        tv_cng = findViewById(R.id.tvcng_title);
//        imageView2 = view.findViewById(R.id.imageView2);
        logout_btn = findViewById(R.id.btnLogout);
        notification_btn = findViewById(R.id.btn_notification);

        layout_hi_oct.setOnClickListener(this);
        layout_super.setOnClickListener(this);
        layout_diesel.setOnClickListener(this);
        notification_btn.setOnClickListener(this);
        logout_btn.setOnClickListener(this);

        getProductDetail();
        ImageSliderAdapter();

        if (PrefsManager.IsDarkModeOn()) {
            setDarkMode();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hi_oct_layout) {
            Intent intent = new Intent(MainActivity.this, Hi_Oct_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.super_layout) {
            Intent intent = new Intent(MainActivity.this, Super_Sale_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_notification) {
            Intent intent = new Intent(MainActivity.this, NotificationHere.class);
            startActivity(intent);
        } else if (v.getId() == R.id.layout_diesel) {
            Intent intent = new Intent(MainActivity.this, Diesel_Sale_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnLogout) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            MainActivity.this.onBackPressed();
        }

    }

    private void getProductDetail() {
        Call<Product_Wise_Request> call = ApiClient.getApiService().getProductTypeWise("1");
        call.enqueue(new Callback<Product_Wise_Request>() {
            @Override
            public void onResponse(Call<Product_Wise_Request> call, Response<Product_Wise_Request> response) {
                Product_Wise_Request call_api = response.body();

                if (response.isSuccessful()) {
                    getApiList = response.body().getProduct_List();
                    for (int i = 0; i < getApiList.size(); i++) {

                        if (getApiList.get(i).getPro_code() == 1) {
                            tv_super.setText(getApiList.get(i).getPro_title());
                        } else if (getApiList.get(i).getPro_code() == 2) {
                            tv_hi_oct.setText(getApiList.get(i).getPro_title());
                        } else if (getApiList.get(i).getPro_code() == 3) {
                            tv_diesel.setText(getApiList.get(i).getPro_title());
                        } else if (getApiList.get(i).getPro_code() == 4) {
                            tv_cng.setText(getApiList.get(i).getPro_title());
                        }
//                        Toast.makeText(context, ""+getApiList.get(i).getPro_title(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<Product_Wise_Request> call, Throwable t) {
                Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void ImageSliderAdapter() {
        // replace FU with FV
        Call<App_Detail_Request> call = ApiClient.getApiService().appDetails("FU");
        call.enqueue(new Callback<App_Detail_Request>() {
            @Override
            public void onResponse(@NonNull Call<App_Detail_Request> call, @NonNull Response<App_Detail_Request> response) {
                App_Detail_Request requestApi = response.body();
                if (response.isSuccessful()) {
//                    AnimatedDialog.dismiss();
                    assert requestApi != null;
                    sliderApiModelArrayList = requestApi.getApp_Slider();
                    slider_adapter = new MainSliderImageAdapter(MainActivity.this, sliderApiModelArrayList);
                    sliderView.setSliderAdapter(slider_adapter);
                    sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                    sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
                    sliderView.setIndicatorSelectedColor(Color.BLUE);
                    sliderView.setIndicatorUnselectedColor(Color.YELLOW);
                    sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
                    sliderView.startAutoCycle();
                }
            }

            @Override
            public void onFailure(@NonNull Call<App_Detail_Request> call, @NonNull Throwable t) {
//                AnimatedDialog.dismiss();
                Toast.makeText(context, "Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setDarkMode() {
        Helper.setDarkModeOnOff(MainActivity.this, homeLayout);

        if (PrefsManager.IsDarkModeOn()) {
            tv_welome.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_today_sale.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_ltrsAmount.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_settled_payment.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_totalSettle_amount.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tvLtrs.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_super_price.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_hi_oct_price.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_diesel_price.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_cng_price.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_super.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_hi_oct.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_diesel.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_cng.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
        } else {
            tv_welome.setTextColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            layoutInner.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.white, MainActivity.this.getTheme()));
            tv_today_sale.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_ltrsAmount.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_settled_payment.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_totalSettle_amount.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tvLtrs.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_super_price.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_hi_oct_price.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_diesel_price.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_cng_price.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_super.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_hi_oct.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_diesel.setTextColor(MainActivity.this.getResources().getColor(R.color.primary, MainActivity.this.getTheme()));
            tv_cng.setTextColor(MainActivity.this.getResources().getColor(R.color.black, MainActivity.this.getTheme()));
        }
    }
}