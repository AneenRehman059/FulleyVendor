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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.zasa.fuellyvendor.Adapters.MainSliderImageAdapter;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.Request.App_Detail_Request;
import com.zasa.fuellyvendor.Request.Product_Wise_Request;
import com.zasa.fuellyvendor.Response.App_Detail_Respone_Model;
import com.zasa.fuellyvendor.Response.Product_Wise_Request_Model;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }

    FragmentHomeBinding binding;
    LinearLayoutCompat layout_super, layout_hi_oct, layout_diesel;
    SliderView sliderView;
    MainSliderImageAdapter slider_adapter;
    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;
    Context context;
    int get_super;
    String get_super_title;
    TextView tv_super,tv_hi_oct, tv_diesel,tv_cng;
    ArrayList<App_Detail_Respone_Model.SliderApiModel> sliderApiModelArrayList = new ArrayList<>();
    ArrayList<Product_Wise_Request_Model> getApiList;


    ImageView imageView, imageView2, notification_btn, logout_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //  binding = FragmentHomeBinding.inflate(inflater,container,false);

        context = requireActivity();
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        sharedPrefManager = new SharedPrefManager(context);

//        btnScanQr = view.findViewById(R.id.btnScanQr);

        getApiList = new ArrayList<com.zasa.fuellyvendor.Response.Product_Wise_Request_Model>();
        sliderView = view.findViewById(R.id.imageSlider);
        layout_super = view.findViewById(R.id.super_layout);
        layout_hi_oct = view.findViewById(R.id.hi_oct_layout);
        layout_diesel = view.findViewById(R.id.layout_diesel);

        imageView = view.findViewById(R.id.imageView);
        tv_super = view.findViewById(R.id.super_title);
        tv_hi_oct = view.findViewById(R.id.hiOct_title);
        tv_diesel = view.findViewById(R.id.diesel_title);
        tv_cng = view.findViewById(R.id.cng_title);
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
        return view;
    }

    private void getProductDetail() {
        Call<Product_Wise_Request> call = ApiClient.getApiService().getProductTypeWise("1");
        call.enqueue(new Callback<Product_Wise_Request>() {
            @Override
            public void onResponse(Call<Product_Wise_Request> call, Response<Product_Wise_Request> response) {
                Product_Wise_Request call_api = response.body();
                if (response.isSuccessful()){
                    getApiList =response.body().getProduct_List();
                    for (int i = 0;i<getApiList.size();i++){

                        if (getApiList.get(i).getPro_code()==1){
                            tv_super.setText(getApiList.get(i).getPro_title());
                        }

                     else if (getApiList.get(i).getPro_code()==2){
                            tv_hi_oct.setText(getApiList.get(i).getPro_title());
                        }
                       else if (getApiList.get(i).getPro_code()==3){
                            tv_diesel.setText(getApiList.get(i).getPro_title());
                        }
                        else if (getApiList.get(i).getPro_code()==4){
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
        Call<com.zasa.fuellyvendor.Request.App_Detail_Request> call = ApiClient.getApiService().appDetails("FV");
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
}