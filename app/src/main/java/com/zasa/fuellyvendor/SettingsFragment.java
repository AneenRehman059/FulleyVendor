package com.zasa.fuellyvendor;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class SettingsFragment extends Fragment {


    LinearLayout change_tpin;
    Button shareBtn;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
      change_tpin = view.findViewById(R.id.edit_tpin_layout);
      shareBtn = view.findViewById(R.id.share_btn);

      change_tpin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getActivity().getApplication(),Change_Tpin_Activity.class);
              startActivity(intent);
          }
      });

      shareBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String shareBody = "Share app via";
              Intent intent = new Intent();
              intent.setAction(Intent.ACTION_SEND);
              intent.setType("text/plain");
              intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
              startActivity(Intent.createChooser(intent,"Share App"));
          }
      });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((HomeActivity)requireActivity()).setDrawerUnlocked();

    }

}