package com.lv.vndispatchpax.views.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.lv.vndispatchpax.R;

/**
 * Created by Administrator on 5/10/2016.
 */
public class ActivityLogin extends AppCompatActivity {
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(ActivityLogin.this, ActivityHome.class);
                ActivityLogin.this.startActivity(toHome);
            }
        });

    }

    public void  toForgotPassword (View v) {
        Intent toforgotPassword = new Intent(ActivityLogin.this, ActivityForgotPassword.class);
        ActivityLogin.this.startActivity(toforgotPassword);
    }

    public void toSignUp (View v) {
        Intent toForgotPasswordViewIntent = new Intent(ActivityLogin.this, ActivitySignup.class);
        ActivityLogin.this.startActivity(toForgotPasswordViewIntent);
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
