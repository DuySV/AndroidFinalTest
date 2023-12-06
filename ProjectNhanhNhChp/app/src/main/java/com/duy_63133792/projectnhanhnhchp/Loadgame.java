package com.duy_63133792.projectnhanhnhchp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Loadgame extends AppCompatActivity {
    private TextView tvLever;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadgame);

        tvLever = findViewById(R.id.tvLevel);

    }
}