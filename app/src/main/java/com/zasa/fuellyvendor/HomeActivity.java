package com.zasa.fuellyvendor;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import com.zasa.fuellyvendor.AutoLogout.BaseActivity;
import com.zasa.fuellyvendor.Fragments.LedgerFragment;
import com.zasa.fuellyvendor.Fragments.MoreFragment;
import com.zasa.fuellyvendor.Fragments.SettingsFragment;
import com.zasa.fuellyvendor.databinding.ActivityHomeBinding;


public class HomeActivity extends BaseActivity  {
    ActivityHomeBinding binding;
    BottomNavigationView bottomNavigationView;
    Context context;
    TextView btn_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context= HomeActivity.this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();

    }

    private void initView() {

        btn_scan = findViewById(R.id.btnFuelly);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ScannerViewActivity.class));
            }
        });
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce_animation);
        btn_scan.startAnimation(animation);

        loadFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        //set home selected
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, new HomeFragment());
        transaction.commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home)
                loadFragment(new HomeFragment());

            else if (item.getItemId() == R.id.ledger) {
                loadFragment(new LedgerFragment());
            }

            else if (item.getItemId() == R.id.more) {
                loadFragment(new MoreFragment());
            }
            else if (item.getItemId() == R.id.settings) {
                loadFragment(new SettingsFragment());
            }
            return true;
        });
    }


    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    //disable Nav drawer in fragments
//    public void setDrawerLocked() {
//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
//    }
//
//    public void setDrawerUnlocked() {
//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
//    }



}