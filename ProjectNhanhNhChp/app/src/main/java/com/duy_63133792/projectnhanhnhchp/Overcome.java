package com.duy_63133792.projectnhanhnhchp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Overcome extends AppCompatActivity {
    private TextView tvchucmung2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overcome);
        tvchucmung2 = findViewById(R.id.tvchucmung2);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Overcome.this, RoundOne.class ));
            }
        }, 1000);
    }

    }

