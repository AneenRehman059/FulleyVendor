package com.zasa.fuellyvendor.Fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.zasa.fuellyvendor.R;


public class PumpDetailFragment extends Fragment {

    ImageButton get_pumpImage;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pump_detail, container, false);

        init();
        return view;
    }

    private void init() {
        get_pumpImage = view.findViewById(R.id.pump_img);

        if (ContextCompat.checkSelfPermission(getActivity().getApplication(),
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
        }
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