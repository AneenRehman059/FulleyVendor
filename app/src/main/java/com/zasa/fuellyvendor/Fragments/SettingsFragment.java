package com.zasa.fuellyvendor.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.zasa.fuellyvendor.BuildConfig;
import com.zasa.fuellyvendor.Change_Tpin_Activity;
import com.zasa.fuellyvendor.Create_Tpin;
import com.zasa.fuellyvendor.Helper;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.MainActivity;
import com.zasa.fuellyvendor.NotificationHere;
import com.zasa.fuellyvendor.PrefsManager;
import com.zasa.fuellyvendor.R;


public class SettingsFragment extends Fragment implements View.OnClickListener {
    View view;
    TextView appVersion, tvUsername, notfication, subNoti, changePass, subchangePass, biometric, sub_biometric,
            appTheme, subApptheme, lgout, sublogout, txt_tpin, sub_tpin ;
    LinearLayout change_pass;
    LinearLayout check_notification , Isbiometric , change_theme , generate_tpin;
    LinearLayout logout;
    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6;
    LinearLayoutCompat settingLayout;
    RelativeLayout lay1;
    SwitchCompat is_biometric, modeSwitch , checkTpin;
    ImageView back_btn;
    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings, container, false);

        getid();
        checkOtp();
        check_biometric();
        checkDarMode();
        setDarkMode();

//
//        int versionCode = BuildConfig.VERSION_CODE;
//        String versionName = BuildConfig.VERSION_NAME;
//        appVersion.setText("App Version:" + versionName);
//        Toast.makeText(getContext(), "version" + versionName, Toast.LENGTH_SHORT).show();

        back_btn.setOnClickListener(this);
        check_notification.setOnClickListener(this);
        change_pass.setOnClickListener(this);
        logout.setOnClickListener(this);
        return view;
    }

    private void setDarkMode() {
        Helper.setDarkModeOnOff(getContext(), settingLayout);

        if (PrefsManager.IsDarkModeOn()) {

            back_btn.setColorFilter(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            logout.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            change_pass.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            check_notification.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            Isbiometric.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            change_theme.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            generate_tpin.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            layout1.setBackgroundColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            layout2.setBackgroundColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            layout3.setBackgroundColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            layout4.setBackgroundColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            layout5.setBackgroundColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            layout6.setBackgroundColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            lay1.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            tvUsername.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_tpin.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            sub_tpin.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            changePass.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            subchangePass.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            notfication.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            subNoti.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            biometric.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            sub_biometric.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            appTheme.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            subApptheme.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            lgout.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            sublogout.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
        }
        else
        {
            logout.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            change_pass.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            check_notification.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            Isbiometric.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            change_theme.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            generate_tpin.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tvUsername.setTextColor(getContext().getResources().getColor(R.color.primary, getContext().getTheme()));
            lay1.setBackgroundColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            changePass.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            subchangePass.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            notfication.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            subNoti.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            biometric.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            sub_biometric.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            appTheme.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            subApptheme.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            lgout.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            txt_tpin.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            sub_tpin.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            sublogout.setTextColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
        }
    }


    private void check_biometric() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("save", Context.MODE_PRIVATE);
        is_biometric.setChecked(sharedPreferences.getBoolean("value", false));
        is_biometric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_biometric.isChecked()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save",
                            Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    is_biometric.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("save",
                            Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    is_biometric.setChecked(false);
                }
            }
        });
    }

    private void
    getid() {
//        appVersion = view.findViewById(R.id.version);

        checkTpin = view.findViewById(R.id.check_tpin);
        change_theme = view.findViewById(R.id.changeMode);
        Isbiometric = view.findViewById(R.id.isBiometric);
        generate_tpin = view.findViewById(R.id.generateTpin);
        layout1 = view.findViewById(R.id.layout1);
        layout2 = view.findViewById(R.id.layout2);
        layout3 = view.findViewById(R.id.layout3);
        layout4 = view.findViewById(R.id.layout4);
        layout5 = view.findViewById(R.id.layout5);
        layout6 = view.findViewById(R.id.layout6);

        txt_tpin = view.findViewById(R.id.tpin);
        sub_tpin = view.findViewById(R.id.subTpin);
        back_btn = view.findViewById(R.id.btn);
        change_pass = view.findViewById(R.id.reset_pass);
        lay1 = view.findViewById(R.id.lays1);
        check_notification = view.findViewById(R.id.notifications);
        logout = view.findViewById(R.id.logout);
        is_biometric = view.findViewById(R.id.is_biometric);
        modeSwitch = view.findViewById(R.id.check_mode);
        settingLayout = view.findViewById(R.id.setting_layout);
        tvUsername = view.findViewById(R.id.tvSettings);
        changePass = view.findViewById(R.id.tv_changePassword);
        subchangePass = view.findViewById(R.id.subchangePass);
        notfication = view.findViewById(R.id.tvNotification);
        subNoti = view.findViewById(R.id.subNotification);
        biometric = view.findViewById(R.id.tvBiometric);
        sub_biometric = view.findViewById(R.id.subBiometric);
        appTheme = view.findViewById(R.id.tvApptheme);
        subApptheme = view.findViewById(R.id.subApptheme);
        lgout = view.findViewById(R.id.tvLogout);
        sublogout = view.findViewById(R.id.subLogout);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ((HomeActivity)requireActivity()).setDrawerUnlocked();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.notification) {
            Intent intent = new Intent(requireActivity(), NotificationHere.class);
            startActivity(intent);
        } else if (v.getId() == R.id.reset_pass) {
            Intent intent = new Intent(getActivity().getApplication(), Change_Tpin_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.logout) {
            startActivity(new Intent(getActivity().getApplication(), LoginActivity.class));
            getActivity().onBackPressed();
        } else if (v.getId() == R.id.btn){
            Intent intent = new Intent(getContext(), HomeActivity.class);
            startActivity(intent);
        }
    }

    private void checkOtp() {
        checkTpin.setChecked(PrefsManager.getPin());
        checkTpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkTpin.isChecked()){
                    checkTpin.setChecked(true);
                    Intent intent = new Intent(getContext() , Create_Tpin.class);
                    startActivity(intent);
                    PrefsManager.setPin(true);
                }
            }
        });
    }

    private void checkDarMode() {
        modeSwitch.setChecked(PrefsManager.IsDarkModeOn());
        modeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modeSwitch.isChecked()) {
                    modeSwitch.setChecked(true);
                    Toast.makeText(getContext(), "Mode On", Toast.LENGTH_SHORT).show();
                    PrefsManager.IsDarkModeOn(true);
                    setDarkMode();
                } else {
                    modeSwitch.setChecked(false);
                    Toast.makeText(getContext(), "Mode Of", Toast.LENGTH_SHORT).show();
                    PrefsManager.IsDarkModeOn(false);
                    setDarkMode();
                }
            }
        });
    }

//    private void checkDarMode() {
//        modeSwitch.setChecked(PrefsManager.IsDarkModeOn());
//        modeSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (modeSwitch.isChecked()) {
//                    modeSwitch.setChecked(true);
//                    Toast.makeText(getContext(), "Mode On", Toast.LENGTH_SHORT).show();
//                    PrefsManager.IsDarkModeOn(true);
//                    setDarkMode();
//                } else {
//                    modeSwitch.setChecked(false);
//                    Toast.makeText(getContext(), "Mode Of", Toast.LENGTH_SHORT).show();
//                    PrefsManager.IsDarkModeOn(false);
//                    setDarkMode();
//                }
//            }
//        });
//    }
}