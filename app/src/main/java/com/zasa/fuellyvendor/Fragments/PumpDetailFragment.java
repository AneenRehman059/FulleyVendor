package com.zasa.fuellyvendor.Fragments;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.zasa.fuellyvendor.GetPumpListApi;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.models.getOmcListApi;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PumpDetailFragment extends Fragment {

    Dialog dialog;
    ImageButton get_pumpImage;
    View view;
    Button submit;
    TextView omc_list;
    LinearLayout layout;
    EditText username, phone, password, conform_password;
    ArrayList<getOmcListApi.OMC_List> getOmcList = new ArrayList<>();
    private SpinnerDialog vehicleListSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pump_detail, container, false);

        omc_list = view.findViewById(R.id.select_omc);

        getVehicleList();

        omc_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVehicleList();
            }
        });

        init();
        return view;
    }

    private void searchVisitType() {

        ArrayList<String> NameList = new ArrayList<>();
        Call<getOmcListApi> call = ApiClient
                .getApiService()
                        .getOmcDetail(1);
        call.enqueue(new Callback<getOmcListApi>() {
            @Override
            public void onResponse(@NonNull Call<getOmcListApi> call, @NonNull Response<getOmcListApi> response) {

                getOmcListApi visitTypeListApi = response.body();
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().getStatus() == 1) {
                        if (visitTypeListApi != null) {
                            getOmcList = visitTypeListApi.getOMC_List();
                            for (int i = 0; i < getOmcList.size(); i++) {
                                String Name = getOmcList.get(i).getOMC_Title();
                                NameList.add(Name);
                                Toast.makeText(getContext(), "lenth"+NameList, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                } else {
                    Toast.makeText(getContext(), "" + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
                }
//                } else {
//                    AnimatedDialog.dismiss();
//                    Toast.makeText(getContext(), "" + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(@NonNull Call<getOmcListApi> call, @NonNull Throwable t) {

                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        vehicleListSpinner = new SpinnerDialog((Activity) getContext(), NameList,
                "Select or Search Vehicle ", in.galaxyofandroid.spinerdialog.R.style.DialogAnimations_SmileWindow,
                "Close");// With 	Animation

        vehicleListSpinner.setCancellable(true); // for cancellable
        vehicleListSpinner.setShowKeyboard(false);// for open keyboard by default

        vehicleListSpinner.bindOnSpinerListener((item, position) -> {

//            fleetCode = vehicleArrayList.get(position).getFleet_Code();

            omc_list.setText(item);
            omc_list.clearFocus();
            omc_list.setError(null);
        });

//        ArrayList<String> NameList = new ArrayList<>();
//        Call<getOmcListApi> call = ApiClient
//                .getApiService()
//                        .getOmcDetail(1);
//        call.enqueue(new Callback<getOmcListApi>() {
//            @Override
//            public void onResponse(@NonNull Call<getOmcListApi> call, @NonNull Response<getOmcListApi> response) {
//
//                getOmcListApi visitTypeListApi = response.body();
//                if (response.isSuccessful()) {
//                    assert response.body() != null;
//                    if (response.body().getStatus() == 1) {
//                        Toast.makeText(getContext(), "Status" + visitTypeListApi.getStatus(), Toast.LENGTH_SHORT).show();
//                    }
////                    if (visitTypeListApi != null) {
//                    {
//                        assert visitTypeListApi != null;
//                        Toast.makeText(getContext(), "message" + visitTypeListApi.getMessage(), Toast.LENGTH_SHORT).show();
//                        getOmcList = visitTypeListApi.getOMC_List();
//                        Toast.makeText(getContext(), "size" + getOmcList.size(), Toast.LENGTH_SHORT).show();
//                        for (int i = 0; i < getOmcList.size(); i++) {
//                            String Name = getOmcList.get(i).getOMC_Account_Title();
//                            NameList.add(Name);
//                        }
//                    }
//
//                } else {
//
//                    Toast.makeText(getContext(), "" + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
//                }
////                } else {
////                    AnimatedDialog.dismiss();
////                    Toast.makeText(getContext(), "" + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
////                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<getOmcListApi> call, @NonNull Throwable t) {
//                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


//        vehicleListSpinner = new SpinnerDialog(getActivity(), NameList,
//                "Select or Search OMC ", in.galaxyofandroid.spinerdialog.R.style.DialogAnimations_SmileWindow,
//                "Close");// With 	Animation
//
//        vehicleListSpinner.setCancellable(true); // for cancellable
//        vehicleListSpinner.setShowKeyboard(false);// for open keyboard by default
//
//        vehicleListSpinner.bindOnSpinerListener(new OnSpinerItemClick() {
//            @Override
//            public void onClick(String item, int position) {
//                omc_list.setText(item);
//
//                omc_list.clearFocus();
//                omc_list.setError(null);
//
//
//            }
//        });

    }

    private void getVehicleList() {

        ArrayList<String> NameList = new ArrayList<>();
        Call<getOmcListApi> call = ApiClient.getApiService().getOmcDetail(1);
        call.enqueue(new Callback<getOmcListApi>() {
            @Override
            public void onResponse(@NonNull Call<getOmcListApi> call, @NonNull Response<getOmcListApi> response) {

                getOmcListApi visitTypeListApi = response.body();
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().getStatus() == 1) {
                        if (visitTypeListApi != null) {
                          getOmcList   = visitTypeListApi.getOMC_List();
                            for (int i = 0; i < getOmcList.size(); i++) {
                                String Name = getOmcList.get(i).getOMC_Title();
                                NameList.add(Name);
                            }
                            //by default selected first company
                            //binding.tvSelectType.setText(visitTypeListModelArrayList.get(0).getVisit_Type_Name());
                            //st_getClientCode=visitTypeListModelArrayList.get(0).getClient_Code();
//                            searchVisitPurpose();

                        }
                    }
                } else {
                    Toast.makeText(getContext(), "" + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
                }
//                } else {
//                    AnimatedDialog.dismiss();
//                    Toast.makeText(getContext(), "" + response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(@NonNull Call<getOmcListApi> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        vehicleListSpinner = new SpinnerDialog(getActivity(), NameList,
                "Select or Search Vehicle ", in.galaxyofandroid.spinerdialog.R.style.DialogAnimations_SmileWindow,
                "Close");// With 	Animation

        vehicleListSpinner.setCancellable(true); // for cancellable
        vehicleListSpinner.setShowKeyboard(false);// for open keyboard by default

        vehicleListSpinner.bindOnSpinerListener((item, position) -> {
            omc_list.setText(item);
            omc_list.clearFocus();
            omc_list.setError(null);
        });

        omc_list.setOnClickListener(view -> vehicleListSpinner.showSpinerDialog());


    }

    private void init() {
        get_pumpImage = view.findViewById(R.id.pump_img);
        submit = view.findViewById(R.id.button);
        username = view.findViewById(R.id.signupUsername);
        phone = view.findViewById(R.id.signupPhone);
        password = view.findViewById(R.id.signupPin);
        conform_password = view.findViewById(R.id.signupCnfPin);

        if (ContextCompat.checkSelfPermission(getActivity().getApplication(),
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ProductDetailFragment.class);
                startActivity(intent);
            }
        });

        get_pumpImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {

            // Get capture Image

            Bitmap captureImage = (Bitmap) data.getExtras().get("data");

            // Set capture image ti imageView

//            imageView.setImageBitmap(captureImage);
        }

    }
}