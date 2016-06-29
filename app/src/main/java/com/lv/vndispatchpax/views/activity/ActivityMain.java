package com.lv.vndispatchpax.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lv.vndispatchpax.R;


public class ActivityMain extends AppCompatActivity {

    private Button btnToLoginView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToLoginView = (Button) findViewById(R.id.btnToLoginView);
        btnToLoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(ActivityMain.this, ActivityLogin.class);
                ActivityMain.this.startActivity(toLogin);
            }
        });

        Intent toLoginView = new Intent(ActivityMain.this, ActivityLogin.class);
        ActivityMain.this.startActivity(toLoginView);
    }
}
