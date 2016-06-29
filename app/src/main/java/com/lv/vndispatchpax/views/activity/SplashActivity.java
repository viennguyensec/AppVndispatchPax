package com.lv.vndispatchpax.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lv.vndispatchpax.R;

/**
 * Created by PC on 5/11/2016.
 */
public class SplashActivity extends AppCompatActivity{
    @Override
   protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);
        finish();
    }
}
