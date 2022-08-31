package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Change_Tpin_Activity extends AppCompatActivity implements View.OnClickListener {
    CheckBox show_tpin;
    EditText existing_pass,new_pass,confirm_pass;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_tpin);

        findId();

        back.setOnClickListener(this);

        show_tpin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    existing_pass.setTransformationMethod(new PasswordTransformationMethod());
                    new_pass.setTransformationMethod(new PasswordTransformationMethod());
                    confirm_pass.setTransformationMethod(new PasswordTransformationMethod());

                    show_tpin.setText(R.string.hide_password);

                }
                else {
                    existing_pass.setTransformationMethod(null);
                    new_pass.setTransformationMethod(null);
                    confirm_pass.setTransformationMethod(null);
                    show_tpin.setText(R.string.show_password);
                }


            }
        });
    }

    private void findId() {
        show_tpin = findViewById(R.id.show_pass);
        existing_pass = findViewById(R.id.existing_tpin);
        new_pass = findViewById(R.id.new_tpin);
        confirm_pass = findViewById(R.id.conform_tpin);
        back = findViewById(R.id.back_img);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_img){
            finish();
        }
    }
}