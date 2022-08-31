package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.zasa.fuellyvendor.Fragments.ExtraServicesFragment;
import com.zasa.fuellyvendor.Fragments.LubricantDetailFragment;
import com.zasa.fuellyvendor.Fragments.ProductDetailFragment;
import com.zasa.fuellyvendor.Fragments.PumpDetailFragment;

public class AfterSignup1 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_signup1);

        getId();
    }

    private void getId() {
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new PumpDetailFragment(),"PUMP DETAILS");
        vpAdapter.addFragment(new ProductDetailFragment(),"PRODUCT DETAILS");
        vpAdapter.addFragment(new LubricantDetailFragment(),"LUBRICANT DETAILS");
        vpAdapter.addFragment(new ExtraServicesFragment(),"EXTRA SERVICES DETAILS");
        viewPager.setAdapter(vpAdapter);
    }
}