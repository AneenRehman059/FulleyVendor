package com.zasa.fuellyvendor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.zasa.fuellyvendor.Adapters.MainSliderImageAdapter;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.databinding.FragmentHomeBinding;
import com.zasa.fuellyvendor.models.App_Detail_Request;
import com.zasa.fuellyvendor.Request.Product_Wise_Request;
import com.zasa.fuellyvendor.models.App_Detail_Respone_Model;
import com.zasa.fuellyvendor.models.Product_Wise_Request_Model;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
//import com.zasa.fuellyvendor.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }

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
    RelativeLayout main_layout;

    FragmentHomeBinding binding;

    ImageView imageView, imageView2, notification_btn,contact_us_btn, logout_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        binding= FragmentHomeBinding.inflate(inflater,container,false);

        context = requireActivity();
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        sharedPrefManager = new SharedPrefManager(context);

//        btnScanQr = view.findViewById(R.id.btnScanQr);

        getApiList = new ArrayList<Product_Wise_Request_Model>();
        contact_us_btn = view.findViewById(R.id.btn_contact);
        main_layout = view.findViewById(R.id.main_lay);
        layoutInner = view.findViewById(R.id.innerlayout);
        tv_super_price = view.findViewById(R.id.super_total_price);
        tv_hi_oct_price = view.findViewById(R.id.high_oct_total_price);
        tv_diesel_price = view.findViewById(R.id.diesel_total_price);
        tv_cng_price = view.findViewById(R.id.cng_total_price);
        tv_totalSettle_amount = view.findViewById(R.id.tv_settle_amount);
        tv_settled_payment = view.findViewById(R.id.tvSettled_payment);
        tv_ltrsAmount = view.findViewById(R.id.tv_ltrs_amount);
        tvLtrs = view.findViewById(R.id.tv_ltrs);
        tv_today_sale = view.findViewById(R.id.tvToday_sale);
        tv_welome = view.findViewById(R.id.tvHome);
        homeLayout = view.findViewById(R.id.layout_home);
        sliderView = view.findViewById(R.id.imageSlider);
        layout_super = view.findViewById(R.id.super_layout);
        layout_hi_oct = view.findViewById(R.id.hi_oct_layout);
        layout_diesel = view.findViewById(R.id.layout_diesel);

        imageView = view.findViewById(R.id.imageView);
        tv_super = view.findViewById(R.id.tvsuper_title);
        tv_hi_oct = view.findViewById(R.id.tvhiOct_title);
        tv_diesel = view.findViewById(R.id.tvdiesel_title);
        tv_cng = view.findViewById(R.id.tvcng_title);
//        imageView2 = view.findViewById(R.id.imageView2);
        logout_btn = view.findViewById(R.id.btnLogout);
        notification_btn = view.findViewById(R.id.btn_notification);

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
        return view;
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
                    slider_adapter = new MainSliderImageAdapter(getContext(), sliderApiModelArrayList);
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hi_oct_layout) {
            Intent intent = new Intent(requireActivity(), Hi_Oct_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.super_layout) {
            Intent intent = new Intent(getActivity().getApplication(), Super_Sale_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_notification) {
            Intent intent = new Intent(getActivity().getApplication(), NotificationHere.class);
            startActivity(intent);
        } else if (v.getId() == R.id.layout_diesel) {
            Intent intent = new Intent(getActivity().getApplication(), Diesel_Sale_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnLogout) {
            startActivity(new Intent(getActivity().getApplication(), LoginActivity.class));
            getActivity().onBackPressed();
        }
    }

    private void setDarkMode() {
        Helper.setDarkModeOnOff(getContext(), homeLayout);

        if (PrefsManager.IsDarkModeOn()) {
            logout_btn.setColorFilter(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            contact_us_btn.setColorFilter(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            notification_btn.setColorFilter(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            main_layout.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tv_welome.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_today_sale.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_ltrsAmount.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_settled_payment.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_totalSettle_amount.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tvLtrs.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_super_price.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_hi_oct_price.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_diesel_price.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_cng_price.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_super.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_hi_oct.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_diesel.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_cng.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
        } else {
            tv_welome.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            contact_us_btn.setColorFilter(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            notification_btn.setColorFilter(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            layoutInner.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tv_today_sale.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_ltrsAmount.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_settled_payment.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_totalSettle_amount.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tvLtrs.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_super_price.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_hi_oct_price.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_diesel_price.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_cng_price.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_super.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_hi_oct.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_diesel.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            tv_cng.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
        }
    }
}