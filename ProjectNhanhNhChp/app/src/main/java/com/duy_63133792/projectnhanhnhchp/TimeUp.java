package com.duy_63133792.projectnhanhnhchp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class TimeUp extends AppCompatActivity {
    private TextView timeup;
    private ImageView imgTimeup;
    private Button btnTimeUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_up);
        timeup = findViewById(R.id.timeup);
        imgTimeup = findViewById(R.id.imgTimeup);
        btnTimeUp = findViewById(R.id.btnTimeUp);
        btnTimeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimeUp.this, StartScreen.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
