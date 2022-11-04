//package com.zasa.fuellyvendor;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.squareup.picasso.Picasso;
//import com.zasa.fuellyvendor.models.App_Detail_Request;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class AdsActivity extends AppCompatActivity {
//    ImageView aadImg;
//    ImageButton close;
//    TextView more_txt;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.flag_dialog);
//
//        aadImg = findViewById(R.id.Aadimg);
//        close = findViewById(R.id.btn_dialog);
//        more_txt = findViewById(R.id.more_txt);
//
//        more_txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = getIntent().getExtras();
//                if (bundle != null) {
//                    String AdsLink = bundle.getString("AadLink");
//                    Uri webpage = Uri.parse(AdsLink);
//                    if (!AdsLink.startsWith("http://") && !AdsLink.startsWith("https://")) {
//                        webpage = Uri.parse("http://" + AdsLink);
//                    }
//                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//                    startActivity(intent);
//                }
//
//            }
//        });
//
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             finish();
//            }
//        });
//
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            String value = bundle.getString("AdImage");
//            Picasso.get().load(value).into(aadImg);
//        }
//    }
//
//}
