package com.lv.vndispatchpax.views.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.lv.vndispatchpax.R;
import com.lv.vndispatchpax.views.fagment.AboutFragment;
import com.lv.vndispatchpax.views.fagment.BookingFragment;
import com.lv.vndispatchpax.views.fagment.HomeFragment;
import com.lv.vndispatchpax.views.fagment.LogBookingFragment;
import com.lv.vndispatchpax.views.fagment.ProfileFragment;


/**
 * Created by PC on 5/12/2016.
 */
public class ActivityHome extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        //default fragment
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("");
        toolbarTitle.setText("Home");

        //Navigation
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                toolbar = (Toolbar) findViewById(R.id.toolbar);
                TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
                switch (item.getItemId())
                {
                    case R.id.home_nav:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        toolbarTitle.setText("Home");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.profile_nav:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new ProfileFragment());
                        fragmentTransaction.commit();
                        toolbarTitle.setText("Profile");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.log_booking_nav:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new LogBookingFragment());
                        fragmentTransaction.commit();
                        toolbarTitle.setText("Log Booking");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.about_nav:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new AboutFragment());
                        fragmentTransaction.commit();
                        toolbarTitle.setText("About");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
