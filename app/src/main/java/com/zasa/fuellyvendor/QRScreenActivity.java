package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivityQrscreenBinding;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;


public class QRScreenActivity extends AppCompatActivity {


    ActivityQrscreenBinding binding;
    private Context context;
    private Dialog AnimatedDialog;
    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;
    String selectedLiters,selectedFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscreen);

        binding = ActivityQrscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = QRScreenActivity.this;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        sharedPrefManager = new SharedPrefManager(context);


        selectedFuel =getIntent().getStringExtra("selectedFuel");
        selectedLiters =getIntent().getStringExtra("selectedLiters");

        ////QR and Bar code generator
        try {
            //barCode();
            qrCode();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

//    public void barCode() throws WriterException {
//
//        BitMatrix bitMatrix = multiFormatWriter.encode(st_Random_Member_Unique, BarcodeFormat.CODE_128, 400, 170);
//        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
//        Barcode.setImageBitmap(bitmap);
//    }

    public void qrCode() throws WriterException {

        BitMatrix bitMatrix = multiFormatWriter.encode(selectedFuel+","+selectedLiters, BarcodeFormat.QR_CODE, 550, 700);
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
        binding.qr.setImageBitmap(bitmap);

    }

    public void btnBack(View view) {
        finish();
    }

//    private void mCircularViewWithTimer() {
//
//        CircularView.OptionsBuilder builderWithTimer =
//                new CircularView.OptionsBuilder()
//                        .shouldDisplayText(true)
//                        .setCounterInSeconds(59)
//                        .setCircularViewCallback(new CircularViewCallback() {
//                            @Override
//                            public void onTimerFinish() {
//                                binding.circular_view.setVisibility(View.GONE);
//
//                                // Will be called if times up of countdown timer
//                                // Toast.makeText(MainActivity.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onTimerCancelled() {
//
//                                //// Will be called if stopTimer is called
//                                //Toast.makeText(MainActivity.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//
//        circularViewWithTimer.setOptions(builderWithTimer);
//        circularViewWithTimer.startTimer();
//    }

}