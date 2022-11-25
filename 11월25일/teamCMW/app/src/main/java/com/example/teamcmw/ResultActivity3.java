package com.example.teamcmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity3 extends AppCompatActivity {

    public double time;
    public int correctN = 0;
    public int wrongN = 0;
    TextView tv;
    TextView tvCorrect;
    TextView tvWrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result3);


        tv = findViewById(R.id.tvTime2);
        tvCorrect = findViewById(R.id.tvCorrectNum2);
        tvWrong = findViewById(R.id.tvWrongNum2);

        Intent intent = getIntent();

        time = intent.getDoubleExtra("time", 0.0);
        correctN = intent.getIntExtra("correct", 0);
        wrongN = intent.getIntExtra("wrong", 0);

        tv.setText("시간 : " + Double.toString(time));
        tvCorrect.setText("맞힌 갯수 : " + Integer.toString(correctN));
        tvWrong.setText("틀린 갯수 : " + Integer.toString(wrongN));


        Button moveButton=findViewById(R.id.button1232);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        int k = 0;
    }
}
