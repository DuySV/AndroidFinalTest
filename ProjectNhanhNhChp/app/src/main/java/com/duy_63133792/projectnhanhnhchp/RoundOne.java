package com.duy_63133792.projectnhanhnhchp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RoundOne extends AppCompatActivity {
    private TextView tvScore;
    private TextView tvTime;
    private FrameLayout Frame_Add30s;
    private FrameLayout  Frame_DoiCauHoi;
    private ImageView imgHome;
    private CheckBox CheckBox_Volume;
    private TextView tvQuiz;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private  ImageView img_score1;
    private  ImageView img_score2;
    private  ImageView img_score3;
    private  ImageView img_score4;
    private  ImageView img_score5;
    private  ImageView img_score6;
    private  ImageView img_score7;
    private  ImageView img_score8;
    private  ImageView img_score9;
    private  ImageView img_score10;
    private ImageView img_Animation;
    private FrameLayout Frame_A;
    private FrameLayout Frame_B;
    private FrameLayout Frame_C;
    private FrameLayout Frame_D;
    private FrameLayout frame100;
    private FrameLayout frame50;
    private TextView tv_A;
    private TextView tv_B;
    private TextView tv_C;
    private TextView tv_D;
    private int Victory=0;
    Question currentQuestion;
    QuestionHelper questionHelper;
    List<Question> list;
    int qid = 0;
    int timeValue = 0;
    int coinValue = 0;
    AnimatedImageDrawable animatedImageDrawable;
    CountDownTimer countDownTimer;
    MediaPlayer bacgroudmuis = new MediaPlayer();
    private float imgAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_one);
        khaibao();
        Them30s();
        Doicauhoi();
}
    private void khaibao() {

        Frame_Add30s=findViewById(R.id.Frame_Add30s);
        Frame_DoiCauHoi=findViewById(R.id.Frame_DoiCauHoi);

        CheckBox_Volume=findViewById(R.id.CheckBox_Volume);

        tvScore = findViewById(R.id.tvScore);
        tvTime=findViewById(R.id.tvTime);
        tvQuiz=findViewById(R.id.tvQuiz);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);
        tv8=findViewById(R.id.tv8);
        tv9=findViewById(R.id.tv9);
        tv10=findViewById(R.id.tv10);
        imgHome=findViewById(R.id.imgHome);
        img_score1=findViewById(R.id.img_score1);
        img_score2=findViewById(R.id.img_score2);
        img_score3=findViewById(R.id.img_score3);
        img_score4=findViewById(R.id.img_score4);
        img_score5=findViewById(R.id.img_score5);
        img_score6=findViewById(R.id.img_score6);
        img_score7=findViewById(R.id.img_score7);
        img_score8=findViewById(R.id.img_score8);
        img_score9=findViewById(R.id.img_score9);
        img_score10=findViewById(R.id.img_score10);

        questionHelper = new QuestionHelper(this);
        questionHelper.getWritableDatabase();
        if (questionHelper.getAllofTheQuestion().size() == 0) {
            questionHelper.allQuestion();
        }
        list = questionHelper.getAllofTheQuestion();
        Collections.shuffle(list);
        currentQuestion = list.get(qid);
        countDownTimer = new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTime.setText(String.valueOf(timeValue) + "\tgiây");
                timeValue -= -1;
                if (timeValue == -1) {
                    tvTime.setText("Hết giờ");
                    disableButton();
                }
            }
            @Override
            public void onFinish() {
                timeUp();
            }
        }.start();
        updateQO();
    }
    private void ReturnMenu() {
        final Dialog dialog = new Dialog(RoundOne.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_home);
        dialog.show();
        TextView tvExit;
        Button btnTiepTuc;
        Button btnMenu;

        tvExit = dialog.findViewById(R.id.tvExit);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        btnMenu = dialog.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoundOne.this,StartScreen.class));
            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    private void updateQO() {
        tvQuiz.setText(currentQuestion.getQuestion());
        tv_A.setText(currentQuestion.getOpta());
        tv_B.setText(currentQuestion.getOptb());
        tv_C.setText(currentQuestion.getOptc());
        tv_D.setText(currentQuestion.getOptd());
        countDownTimer.cancel();
        countDownTimer.start();
        tvScore.setText(String.valueOf(coinValue));
        coinValue+=50;

    }
    private void timeUp() {
        Intent intent = new Intent(this, TimeUp.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }
    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
        finish();
    }
    private void disableButton() {
        tv_A.setEnabled(false);
        tv_B.setEnabled(false);
        tv_C.setEnabled(false);
        tv_D.setEnabled(false);
    }
    private void enableButton() {
        tv_A.setEnabled(true);
        tv_B.setEnabled(true);
        tv_C.setEnabled(true);
        tv_D.setEnabled(true);
    }
    private void correctDialog() {
        final Dialog dialogCorrect = new Dialog(RoundOne.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();
        onPause();
        TextView correctText = dialogCorrect.findViewById(R.id.correctText);
        Button buttonNext = dialogCorrect.findViewById(R.id.dialogNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCorrect.dismiss();
                qid++;
                currentQuestion = list.get(qid);
                updateQO();
                resetColor();
                enableButton();
            }
        });
    }
    private void resetColor() {
        Frame_A.setBackgroundResource(R.drawable.fom_start);
        Frame_B.setBackgroundResource(R.drawable.fom_start);
        Frame_C.setBackgroundResource(R.drawable.fom_start);
        Frame_D.setBackgroundResource(R.drawable.fom_start);
    }
    private void processAnswerSelection(String selectedOption) {
        FrameLayout selectedFrameLayout = null;
        String correctOption = currentQuestion.getAnswer();
        if (selectedOption.equals(correctOption)) {
            disableButton();
            correctDialog();
            if (currentQuestion.getOpta().equals(currentQuestion.getAnswer())) {
                if (qid < list.size() - 1) {
                    disableButton();
                    correctDialog();
                }
            }   if (qid == 0) {
                img_score1.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 1){
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 585f);
                anim.setDuration(10);
                anim.start();
                img_score2.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 2){
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 510f);
                anim.setDuration(10);
                anim.start();
                img_score3.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 3){
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 435f);
                anim.setDuration(10);
                anim.start();
                img_score4.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 4){
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 360f);
                anim.setDuration(10);
                anim.start();
                img_score5.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 5){
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 285);
                anim.setDuration(10);
                anim.start();
                img_score6.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 6) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 210f);
                anim.setDuration(10);
                anim.start();
                img_score7.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 7) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 135f);
                anim.setDuration(10);
                anim.start();
                img_score8.setBackgroundResource(R.drawable.anim4);
            }else if (qid == 8) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 60f);
                anim.setDuration(10);
                anim.start();
                img_score9.setBackgroundResource(R.drawable.anim4);
            }
            else if (qid == 9){
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 0f);
                anim.setDuration(10);
                anim.start();
                img_score10.setBackgroundResource(R.drawable.anim4);
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void Frame_B(View view) {
        Frame_B.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));
        processAnswerSelection(currentQuestion.getOpta());
    }

    public void Frame_A(View view) {
        Frame_A.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));
        processAnswerSelection(currentQuestion.getOptb());
    }

    public void Frame_C(View view) {
        Frame_C.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));
        processAnswerSelection(currentQuestion.getOptc());
    }

    public void Frame_D(View view) {
        Frame_D.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));
        processAnswerSelection(currentQuestion.getOptd());
    }

    public void gameLostPlayAgain() {
        Intent intent = new Intent(this, PlayAgain.class);
        startActivity(intent);
        finish();
    }
    public void gameWon() {
        Intent intent = new Intent(this, GameWon.class);
        startActivity(intent);
        finish();
    }
    private void Dungtrogiup(){
        final Dialog dialog = new Dialog(RoundOne.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghelp);
        dialog.show();
        TextView tvStatus;
        Button btnTiepTuc;
        tvStatus = dialog.findViewById(R.id.tvStatus);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    private void onclickDoiCauhoi(){
        Frame_DoiCauHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doicauhoi();
            }
        });
    }
    private void onclickXemthem30s(){
        Frame_Add30s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Them30s();
            }
        });
    }
    private void Them30s(){
        frame100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coinValue < 100){
                    Dungtrogiup();
                }
                else {
                    String a = String.valueOf(coinValue-=150);
                    tvScore.setText(a);
                    timeValue-=30;
                }
            }
        });
    }
    private void Doicauhoi(){
        frame50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coinValue < 100){
                    Dungtrogiup();
                }
                else {
                    list = questionHelper.getAllofTheQuestion();
                    Collections.shuffle(list);
                    String a = String.valueOf(coinValue-=100);
                    tvScore.setText(a);
                    coinValue-=100;
                }
            }
        });
    }
    }
