package com.example.teamcmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView timeResult;
    double time = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        timeResult  = findViewById(R.id.text1);


        Intent it = getIntent();

        time = it.getDoubleExtra("time", 0.0);

        timeResult.setText(Double.toString(time) + " 초 걸렸습니다");


    }

}
