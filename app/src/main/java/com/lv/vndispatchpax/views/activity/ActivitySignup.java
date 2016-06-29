package com.lv.vndispatchpax.views.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.lv.vndispatchpax.R;

/**
 * Created by PC on 5/11/2016.
 */
public class ActivitySignup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Button btnBackToSignIn = (Button) findViewById(R.id.btnBackToSignIn);
        btnBackToSignIn.setTypeface(font);

        btnBackToSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backToSignIn = new Intent(ActivitySignup.this, ActivityLogin.class);
                ActivitySignup.this.startActivity(backToSignIn);
            }
        });

        Button btnSignup = (Button) findViewById(R.id.btnSignUp);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(ActivitySignup.this, ActivityHome.class);
                ActivitySignup.this.startActivity(toHome);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
