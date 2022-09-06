package com.zasa.fuellyvendor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }

    FragmentHomeBinding binding;
    LinearLayoutCompat layout_super, layout_hi_oct, layout_diesel;

    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;
    Context context;

    private ViewPager2 viewPager2;
    LinearLayout indicatorLay, tab0, tab1, tab2, tab3;
    SliderAdapter sliderAdapter;

    ImageView imageView, imageView2,notification_btn,logout_btn;

    ImageSlider imageSlider;
    List<SlideModel> list = new ArrayList<>();//default list
    List<SliderApiModel> sliderApiModelList = new ArrayList<>();  //custom list

Button btnScanQr;
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
        indicatorLay = view.findViewById(R.id.indicatorLay);
        viewPager2 = view.findViewById(R.id.viewPagerImageSlider);

        layout_super = view.findViewById(R.id.super_layout);
        layout_hi_oct = view.findViewById(R.id.hi_oct_layout);
        layout_diesel = view.findViewById(R.id.layout_diesel);

        imageView = view.findViewById(R.id.imageView);
        imageView2 = view.findViewById(R.id.imageView2);
        logout_btn = view.findViewById(R.id.btnLogout);
        notification_btn = view.findViewById(R.id.btn_notification);

        tab0 = view.findViewById(R.id.tab0);
        tab1 = view.findViewById(R.id.tab1);
        tab2 = view.findViewById(R.id.tab2);
        tab3 = view.findViewById(R.id.tab3);

        layout_hi_oct.setOnClickListener(this);
        layout_super.setOnClickListener(this);
        layout_diesel.setOnClickListener(this);
        notification_btn.setOnClickListener(this);
        logout_btn.setOnClickListener(this);

        List<SliderItems> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItems("Fuelly \nTotal liters", " PKR. 1000"));
        sliderItems.add(new SliderItems("Wallet Services", "Coming soon"));
        sliderItems.add(new SliderItems("Other Services", "Coming soon"));
        sliderItems.add(new SliderItems("Other Services", "Coming soon"));


        //sliderItems.add(new SliderItems(R.drawable.c4));

        sliderAdapter = new SliderAdapter(sliderItems, viewPager2);
        // viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
        viewPager2.setAdapter(sliderAdapter);


        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(20));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);


            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);


        setupIndicators();
        setCurrentonboardingindicator(0);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentonboardingindicator(position);

                if (position == 0) {
                    tab0.setVisibility(View.VISIBLE);
                    tab1.setVisibility(View.GONE);
                    tab2.setVisibility(View.GONE);
                    tab3.setVisibility(View.GONE);

                }

                if (position == 1) {

                    tab0.setVisibility(View.GONE);
                    tab1.setVisibility(View.VISIBLE);
                    tab2.setVisibility(View.GONE);
                    tab3.setVisibility(View.GONE);

                }
                if (position == 2) {
                    tab0.setVisibility(View.GONE);
                    tab1.setVisibility(View.GONE);
                    tab2.setVisibility(View.VISIBLE);
                    tab3.setVisibility(View.GONE);

                }
                if (position == 3) {
                    tab0.setVisibility(View.GONE);
                    tab1.setVisibility(View.GONE);
                    tab2.setVisibility(View.GONE);
                    tab3.setVisibility(View.VISIBLE);

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);

                if (state == RecyclerView.SCROLL_STATE_DRAGGING) {
                    // Toast.makeText(ViewPagerActivity.this, "", Toast.LENGTH_SHORT).show();

                } else if (state == RecyclerView.SCROLL_STATE_IDLE) {

                }


            }
        });


        Picasso.get().load("https://bestrated.co.nz/wp-content/uploads/2021/06/Waitomo-Johnsonville-1024x768.jpg").fit()
                //.placeholder(R.drawable.noimg)
                //.error(R.drawable.noimg)
                .into(imageView);


        Picasso.get().load("https://www.hascol.com/wp-content/uploads/2017/01/HD-Banner.jpg").fit()
                //.placeholder(R.drawable.noimg)
                //.error(R.drawable.noimg)
                .into(imageView2);


//        btnScanQr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(context, ScannerViewActivity.class));
//            }
//        });


        // sliderApi();

        //  return binding.getRoot();
        return view;

    }

//    private void sliderApi() {
//
//        progressDialog.show();
//        Call<SliderApi> call = RetrofitInstance
//                .getInstance()
//                .getApiInterface()
//                .mSliderApi("LBR");
//
//        call.enqueue(new Callback<SliderApi>() {
//            @Override
//            public void onResponse(@NonNull Call<SliderApi> call, @NonNull Response<SliderApi> response) {
//                SliderApi sliderApi = response.body();
//                if (response.isSuccessful()) {
//
//                    if (sliderApi != null) {
//
//                        if (sliderApi.getStatus() == 1) {
//
//                            // progressDialog.dismiss();
//                            if (sliderApi.getSliderList().equals(sliderApiModelList)) {
//                                Toast.makeText(context, "same data", Toast.LENGTH_SHORT).show();
//                                return;
//                            } else {
//                                if (sliderApi.getSliderList().size() > 0) {
//                                    sliderApiModelList.clear();
//                                }
//
//                            }
//
//                            sliderApiModelList = sliderApi.getSliderList();
//                            for (int i = 0; i < sliderApiModelList.size(); i++) {
//                                String Slider_Image = sliderApiModelList.get(i).getSlider_Image();
//                                String Slider_Title = sliderApiModelList.get(i).getSlider_Title();
//                                //list.add(new SlideModel(Slider_Image,Slider_Title, ScaleTypes.FIT));
//                                list.add(new SlideModel(Slider_Image, ScaleTypes.CENTER_INSIDE));
//                            }
//                            progressDialog.dismiss();
//
//                            binding.imageSlider.setImageList(list, ScaleTypes.CENTER_INSIDE);
//                            binding.imageSlider.setItemClickListener(new ItemClickListener() {
//                                @Override
//                                public void onItemSelected(int i) {
//                                    String Slider_Link = sliderApiModelList.get(i).getSlider_Link();
//
////                                    Intent intent = new Intent(context, WebViewActivity.class);
////                                    intent.putExtra("URL", Slider_Link);
////                                    startActivity(intent);
//
//                                    /* Uri uri = Uri.parse(lin);
//                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//
//                                if (intent.resolveActivity(getPackageManager()) != null) {
//                                    startActivity(intent);
//                                } else {
//                                    Toast.makeText(HomeActivity.this, "Sorry... Browser App is not available.", Toast.LENGTH_LONG).show();
//                                }*/
//
//                                }
//                            });
//
//                          //  companyTypeListApi();
//
//                        } else {
//                            //swipe.setRefreshing(false);
//                            progressDialog.dismiss();
//                            Toast.makeText(context, " " + sliderApi.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        //swipe.setRefreshing(false);
//                        progressDialog.dismiss();
//                        Toast.makeText(context, response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
//                    }
//
//                } else {
//                    // swipe.setRefreshing(false);
//                    progressDialog.dismiss();
//                    Toast.makeText(context, "" + response.code() + " " + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<SliderApi> call, @NonNull Throwable t) {
//                //swipe.setRefreshing(false);
//                progressDialog.dismiss();
//                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }


    private void setupIndicators() {
        ImageView[] indicators = new ImageView[sliderAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(requireActivity());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(requireActivity(),
                    R.drawable.indicator_inavtive));
            indicators[i].setLayoutParams(layoutParams);
            indicatorLay.addView(indicators[i]);
        }

    }

    private void setCurrentonboardingindicator(int index) {


        int childcount = indicatorLay.getChildCount();
        for (int i = 0; i < childcount; i++) {


            ImageView imageView = (ImageView) indicatorLay.getChildAt(i);
            if (i == index)
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(requireActivity(), R.drawable.indicator_avtive));
            else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(requireActivity(), R.drawable.indicator_inavtive));

            }


        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hi_oct_layout){
            Intent intent = new Intent(requireActivity(),Hi_Oct_Activity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.super_layout){
            Intent intent = new Intent(getActivity().getApplication(),Super_Sale_Activity.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.btn_notification){
            Intent intent = new Intent(getActivity().getApplication(),NotificationHere.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.layout_diesel){
            Intent intent = new Intent(getActivity().getApplication(),Diesel_Sale_Activity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btnLogout){
            startActivity(new Intent(getActivity().getApplication(), LoginActivity.class));
            getActivity().onBackPressed();
        }

    }
}