package com.zasa.fuellyvendor.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zasa.fuellyvendor.OTPVerification;
import com.zasa.fuellyvendor.R;

public class ExtraServicesFragment extends Fragment {
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extra_services, container, false);
        btn = view.findViewById(R.id.button_submit);

//        Intent intent = new Intent(requireActivity(), OTPVerification.class);
//        startActivity(intent);
        return view;
    }
}