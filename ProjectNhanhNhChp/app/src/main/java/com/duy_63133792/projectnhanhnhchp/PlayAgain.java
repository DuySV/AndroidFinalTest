package com.duy_63133792.projectnhanhnhchp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayAgain extends AppCompatActivity {
    Button playAgain;
    TextView wrongAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);

        playAgain =  findViewById(R.id.playAgainButton);
        wrongAns = findViewById(R.id.wrongAns);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayAgain.this, StartScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
