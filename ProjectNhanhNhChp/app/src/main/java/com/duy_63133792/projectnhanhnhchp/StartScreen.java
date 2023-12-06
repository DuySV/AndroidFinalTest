package com.duy_63133792.projectnhanhnhchp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {
    Button btnStart;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        btnStart = findViewById(R.id.btnStart);
        btnExit = findViewById(R.id.btnExit);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartScreen.this, Loadgame.class));
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exitdialog();
            }
        });
    }
    private void Exitdialog(){
        final Dialog dialog = new Dialog(StartScreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghome);
        dialog.show();
        TextView tvExit;
        Button btnContinue;
        Button btnMenu;

        tvExit = dialog.findViewById(R.id.tvExit);
        btnContinue = dialog.findViewById(R.id.btnContinue);
        btnMenu = dialog.findViewById(R.id.btnMenu);

        tvExit.setText("Bạn có muốn thoát không ???");
        btnMenu.setText("Thoát");
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartScreen.class);
                startActivity(intent);
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }
}
