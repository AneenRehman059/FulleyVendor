package com.zasa.fuellyvendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import com.zasa.fuellyvendor.Fragments.LedgerFragment;
import com.zasa.fuellyvendor.Fragments.MoreFragment;
import com.zasa.fuellyvendor.Fragments.SettingsFragment;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MyDrawerController {
    ActivityHomeBinding binding;
    ChipNavigationBar ChipNavigationBar;
    Context context;

    //    DRAWER LAYOUT  //
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    //    DRAWER LAYOUT  //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context= HomeActivity.this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ////////////////////////////////////NAVIGATION DRAWER
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.NavigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, (R.string.open), (R.string.close));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        ChipNavigationBar = findViewById(R.id.ChipNavigationBar);
        //set home selected
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, new HomeFragment());
        transaction.commit();

//        binding.ChipNavigationBar.setBackground(null);
//        //set home selected
//        binding.ChipNavigationBar.setItemSelected(R.id.home,true);
//        binding.ChipNavigationBar.showBadge(R.id.notifications,10);

        ChipNavigationBar.setBackground(null);
        //set home selected
        ChipNavigationBar.setItemSelected(R.id.home, true);
//        ChipNavigationBar.showBadge(R.id.notifications, 10);

        bottomNavigation();


    }

    private void bottomNavigation() {
        ChipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int item) {
                //initialize fragment
                Fragment fragment = null;
                //check condition
                switch (item) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.ledger:
                        fragment = new LedgerFragment();
                        break;
//                    case R.id.profile:
//                        fragment = new ProfileFragment();
//                        break;
                    case R.id.settings:
                        fragment = new SettingsFragment();
                        break;
                    case R.id.more:
                        fragment = new MoreFragment();
                        break;
                }
                //loadFragment
                loadFragment(fragment);


            }
        });

    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    //disable Nav drawer in fragments
    public void setDrawerLocked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void setDrawerUnlocked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Home:
                drawerLayout.closeDrawers();
                if (item.getItemId() != R.id.Home) {
                    startActivity(new Intent(context, HomeActivity.class));
                }
                break;
//            case R.id.Profile:
//                drawerLayout.closeDrawer(GravityCompat.START);
//               // startActivity(new Intent(context, ProfileActivity.class));
//                loadFragment(new ProfileFragment());
//                break;

           /* case R.id.favorite:
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(MainActivity.this, "favorite", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RadioBtnActivity.class));
                break;
            case R.id.promo_code:
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(MainActivity.this, "promo_code", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RadioBtnActivity.class));
                break;
            case R.id.orders:
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(MainActivity.this, "orders", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RadioBtnActivity.class));
                break;
            case R.id.setting:
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RadioBtnActivity.class));
                break;*/
            case R.id.Logout:
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
                break;
            default:
                return true;
        }
        return true;
    }


}