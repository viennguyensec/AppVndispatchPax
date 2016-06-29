package com.lv.vndispatchpax.views.activity;

import android.app.Dialog;
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
 * Created by PC on 5/12/2016.
 */
public class ActivityForgotPassword extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Button btnBackToSignIn = (Button) findViewById(R.id.btnBackToSignIn);
        btnBackToSignIn.setTypeface(font);

        btnBackToSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backToSignIn = new Intent(ActivityForgotPassword.this, ActivityLogin.class);
                ActivityForgotPassword.this.startActivity(backToSignIn);
            }
        });

        Button btnSendEmailForgotPassword = (Button) findViewById(R.id.sendEmailForgotPassword);
        btnSendEmailForgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Custom dialog
                final Dialog dialog = new Dialog(ActivityForgotPassword.this, R.style.FullHeightDialog);
                dialog.setContentView(R.layout.dialog_forgot_password);
                dialog.show();

                Button btnOK = (Button)dialog.findViewById(R.id.btnOK);
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
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
