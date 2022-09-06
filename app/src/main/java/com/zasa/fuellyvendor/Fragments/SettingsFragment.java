package com.zasa.fuellyvendor.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zasa.fuellyvendor.Change_Tpin_Activity;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.NotificationHere;
import com.zasa.fuellyvendor.R;


public class SettingsFragment extends Fragment implements View.OnClickListener {
    View view;
    LinearLayout change_pass,check_notification,logout;
    SwitchCompat is_biometric;
    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_settings, container, false);

         getid();
         check_biometric();

         check_notification.setOnClickListener(this);
         change_pass.setOnClickListener(this);
         logout.setOnClickListener(this);
        return view;
    }

    private void check_biometric() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("save", Context.MODE_PRIVATE);
        is_biometric.setChecked(sharedPreferences.getBoolean("value", false));
        is_biometric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_biometric.isChecked()){
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save",
                            Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    is_biometric.setChecked(true);
                }
                else
                {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save",
                            Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    is_biometric.setChecked(false);
                }
            }
        });
    }

    private void getid() {
        change_pass = view.findViewById(R.id.reset_pass);
        check_notification = view.findViewById(R.id.notification);
        logout = view.findViewById(R.id.logout);
        is_biometric = view.findViewById(R.id.is_biometric);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ((HomeActivity)requireActivity()).setDrawerUnlocked();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.notification){
            Intent intent = new Intent(requireActivity(), NotificationHere.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.reset_pass){
            Intent intent = new Intent(getActivity().getApplication(), Change_Tpin_Activity.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.logout){
            startActivity(new Intent(getActivity().getApplication(), LoginActivity.class));
            getActivity().onBackPressed();
        }
    }
}