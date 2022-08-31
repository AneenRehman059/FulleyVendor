package com.zasa.fuellyvendor.Fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class LedgerFragment extends Fragment implements View.OnClickListener {

    public LedgerFragment() {
        // Required empty public constructor
    }

    LinearLayout fromlayout, tolayout, main_date_layout;
    TextView tvFromdate, tvTodate,ledger_date,startDate,endDate;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ledger, container, false);


        fromlayout = view.findViewById(R.id.from_date_layout);
        tolayout = view.findViewById(R.id.to_date_layout);
        main_date_layout = view.findViewById(R.id.main_layout_date);
        tvFromdate = view.findViewById(R.id.tv_from_date);
        tvTodate = view.findViewById(R.id.tv_to_date);


        fromlayout.setOnClickListener(this);
        tolayout.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back_img:
                getActivity().onBackPressed();
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((HomeActivity) requireActivity()).setDrawerUnlocked();

    }

}