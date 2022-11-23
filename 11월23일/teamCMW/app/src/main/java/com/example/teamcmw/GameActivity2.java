package com.example.teamcmw;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity2 extends AppCompatActivity {



    TextView tv;
    EditText et;
    public int iteration = 0; // 10
    public int ans = -1;
    public int num, maxNum, minNum, userNum;
    public int correct = 0, wrong = 0;
    public double p;
    public String str = null;
    public double time = 0.0;

    public double beforeTime = System.currentTimeMillis();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        tv = findViewById(R.id.gameText);
        et = findViewById(R.id.editTextId);

                // 6 - 8 까지 0.4, 0.4, 0.2 의 확률로 뽑힘
        num = -1; maxNum = -987654321; minNum = 987654321;


        playGame();
        userNum = -1;

        if(iteration == 2){

            tv.setText("asdfasdf");
        }


    }
    public void pickNumAndAns(){
        p = Math.random();
        if(p <= 0.4)
            num = 6;
        else if(p <= 0.8)
            num = 7;
        else
            num = 8;
        if(num == 6){
            maxNum = 999999;
            minNum = 100000;
        }
        else if(num == 7){
            maxNum = 9999999;
            minNum = 1000000;
        }
        else if(num == 8){
            maxNum = 99999999;
            minNum = 10000000;
        }
        ans = (int) (Math.random() * (maxNum-minNum+1) + minNum);
    }
    public void playGame(){
        et.setText("");
        pickNumAndAns();
        String tvText = "";
        for(int i=0;i<num;i++){
            tvText = tvText + "_ ";
        }
        tv.setText(tvText);
        str = tvText;
        new Timer().schedule(new TimerTask() {
            public void run() {
                tv.setText(String.valueOf(ans));
            }
        }, 1000); // 1초후 실행

        new Timer().schedule(new TimerTask() {
            public void run() {
                tv.setText(str);
            }
        }, 1500); // 1초후 실행


        et = findViewById(R.id.editTextId);

        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        userNum = Integer.parseInt(et.getText().toString());
                        if (userNum == ans) {
                            tv.setText("맞았음");
                            iteration++;
                            correct++;
                            new Timer().schedule(new TimerTask() {
                                public void run() {

                                    if(iteration == 10){
                                        double afterTime = System.currentTimeMillis();
                                        time = (afterTime - beforeTime)/1000;
                                        Intent intent = new Intent(getApplicationContext(), ResultActivity2.class);
                                        intent.putExtra("correct", correct);
                                        intent.putExtra("wrong", wrong);
                                        intent.putExtra("time", time);
                                        startActivity(intent);
                                    }
                                    playGame();
                                }
                            }, 1500); // 1초후 실행
                        }
                        else{
                            tv.setText("틀렸음");
                            iteration++;
                            wrong++;
                            new Timer().schedule(new TimerTask() {
                                public void run() {

                                    if(iteration == 10){
                                        double afterTime = System.currentTimeMillis();
                                        time = (afterTime - beforeTime)/1000;
                                        Intent intent = new Intent(getApplicationContext(), ResultActivity2.class);
                                        intent.putExtra("correct", correct);
                                        intent.putExtra("wrong", wrong);
                                        intent.putExtra("time", time);
                                        startActivity(intent);
                                    }
                                    playGame();
                                }
                            }, 1500); // 1초후 실행


                        }
                        return true;
                    }
                return false;
            }
        });

    }


}