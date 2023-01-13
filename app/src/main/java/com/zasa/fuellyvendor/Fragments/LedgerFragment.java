package com.zasa.fuellyvendor.Fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zasa.fuellyvendor.Helper;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.PrefsManager;
import com.zasa.fuellyvendor.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class LedgerFragment extends Fragment implements View.OnClickListener {

    public LedgerFragment() {
        // Required empty public constructor
    }

    RelativeLayout lay2;
    ImageView back_button;
    LinearLayoutCompat layout_ledger;
    LinearLayout fromlayout, tolayout, main_date_layout;
    TextView tvFromdate, tvTodate,txt_frmDate,txtTodate,ledger_date,startDate,endDate , tvLedger;
    TextView txt_date,txt_c_name,txt_p_name,txt_quantitiy,date,comapny_name,pump_name,quantity,amount;
    TextView txt_date1,txt_c_name1,txt_p_name1,txt_quantitiy1,date1,comapny_name1,pump_name1,quantity1,amount1;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ledger, container, false);

        txt_date = view.findViewById(R.id.txt_date);
        txt_c_name = view.findViewById(R.id.txt_c_name);
        txt_p_name = view.findViewById(R.id.txt_p_name);
        txt_quantitiy = view.findViewById(R.id.txt_quantity);
        date = view.findViewById(R.id.date);
        comapny_name = view.findViewById(R.id.company_name);
        pump_name = view.findViewById(R.id.pump_name);
        quantity = view.findViewById(R.id.quantity);
        amount = view.findViewById(R.id.amount);

        txt_date1 = view.findViewById(R.id.txt_date1);
        txt_c_name1 = view.findViewById(R.id.txt_c_name1);
        txt_p_name1 = view.findViewById(R.id.txt_p_name1);
        txt_quantitiy1 = view.findViewById(R.id.txt_quantity1);
        date1 = view.findViewById(R.id.date1);
        comapny_name1 = view.findViewById(R.id.company_name1);
        pump_name1 = view.findViewById(R.id.pump_name1);
        quantity1 = view.findViewById(R.id.quantity1);
        amount1 = view.findViewById(R.id.amount1);

        lay2 = view.findViewById(R.id.lay2);
        tvLedger = view.findViewById(R.id.tvLedger);
        back_button = (ImageView) view.findViewById(R.id.m2);
        fromlayout = view.findViewById(R.id.from_date_layout);
        tolayout = view.findViewById(R.id.to_date_layout);
        main_date_layout = view.findViewById(R.id.main_layout_date);
        tvFromdate = view.findViewById(R.id.tv_from_date);
        tvTodate = view.findViewById(R.id.tv_to_date);
        layout_ledger = view.findViewById(R.id.ledger_Layout);
        txt_frmDate = view.findViewById(R.id.txt_from_date);
        txtTodate = view.findViewById(R.id.txt_to_date);

        back_button.setOnClickListener(this);
        fromlayout.setOnClickListener(this);
        tolayout.setOnClickListener(this);

        if (PrefsManager.IsDarkModeOn()) {
            setDarkMode();
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

//            case R.id.back_img:
//                getActivity().onBackPressed();
//                break;

            case R.id.m2:
                Intent intent = new Intent(getContext(),HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.from_date_layout:


                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

                setListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        tvFromdate.setText(date);
                    }
                };

                break;

            case R.id.to_date_layout:

                Calendar calendar1 = Calendar.getInstance();
                final int year1 = calendar1.get(Calendar.YEAR);
                final int month1 = calendar1.get(Calendar.MONTH);
                final int day1 = calendar1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog1 = new DatePickerDialog(
                        getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year1,month1,day1);
                datePickerDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog1.show();

                setListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        tvTodate.setText(date);
                    }
                };
                break;
        }

    }

    private void setDarkMode() {
        Helper.setDarkModeOnOff(getContext(), layout_ledger);

        if (PrefsManager.IsDarkModeOn()) {

            lay2.setBackgroundColor(getContext().getResources().getColor(R.color.black, getContext().getTheme()));
            back_button.setColorFilter(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tvLedger.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_frmDate.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txtTodate.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tvFromdate.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            tvTodate.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));

            txt_date.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_c_name.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_p_name.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_quantitiy.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            date.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            comapny_name.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            pump_name.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            quantity.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            amount.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));

            txt_date1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_c_name1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_p_name1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            txt_quantitiy1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            date1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            comapny_name1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            pump_name1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            quantity1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
            amount1.setTextColor(getContext().getResources().getColor(R.color.white, getContext().getTheme()));
        }
        else {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ((HomeActivity) requireActivity()).setDrawerUnlocked();

    }
}