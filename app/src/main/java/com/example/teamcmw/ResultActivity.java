package com.example.teamcmw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class ResultActivity extends AppCompatActivity {

    TextView timeResult;
    double time = 0.0;
    double btime=987654321.0;//best time
    double wtime=0.0;//worst time
    double mtime=0.0;//mean time
    double trycnt=0.0;

    int round = 0;
    int wrong = 0;

    // DBHelper
    DBHelper dbHelper = new DBHelper(this, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        timeResult  = findViewById(R.id.text1);

        SharedPreferences preferences = getSharedPreferences( "scoreInfo" , MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        btime= (double)preferences.getFloat("best", 987654321.0f);
        wtime= (double)preferences.getFloat("worst", 0.0f);
        mtime= (double)preferences.getFloat("mean", 0.0f);
        trycnt= (double)preferences.getFloat("try", 0.0f);

        Intent it = getIntent();

        time = it.getDoubleExtra("time", 0.0);

        time = (double) Math.round(time * 100) / 100;

        if(time<btime){
            btime=time;
        }
        if(time>wtime){
            wtime=time;
        }
        editor.putFloat("best", (float)btime);
        editor.putFloat("worst", (float)wtime);
        mtime=(mtime*trycnt+time)/(trycnt+1.0);
        trycnt+=1.0;
        editor.putFloat("mean", (float)mtime);
        editor.putFloat("try", (float)trycnt);


        editor.commit();

        timeResult.setText(Double.toString(time) + " 초 걸렸습니다");

        timeResult.setText(Double.toString(time) + " 초 걸렸습니다");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date currentDate = new Date();

        round = dbHelper.getGame1Round();

        String result = "보통";
        String detailResult = "총 게임 시간이 1분 미만이며 틀린 횟수가 10회 미만으로 주의력에 큰 문제가 없어 보입니다.";

        if (time >= 60) {
            if (wrong <= 10) {
                result = "주의";
                detailResult = "총 게임 시간이 " + String.valueOf(time) + "초로 1분 이상이며," +
                        " 틀린 횟수가 " + String.valueOf(wrong) + "회로 10회 미만이므로" +
                        " 주의력 결핍이 의심됩니다.";
            }
            else {
                result = "매우 주의";
                detailResult = "총 게임 시간이 " + String.valueOf(time) + "초로 1분 이상이며," +
                        " 틀린 횟수가 " + String.valueOf(wrong) + "회로 10회 이상으로" +
                        " 주의력 결핍이 매우 의심됩니다.";
            }

        }
        else if (time >= 90) {
            result = "매우 주의";
            detailResult = "총 게임 시간이 " + String.valueOf(time) + "초로 1분 30초 이상으로" +
                    " 주의력 결핍이 매우 의심됩니다.";
        }
        else if (wrong >= 10) {
            result = "주의";
            detailResult = "총 게임 시간이 " + String.valueOf(time) + "초로 1분 미만이나," +
                    " 틀린 횟수가 " + String.valueOf(wrong) + "회로 10회 이상이므로" +
                    " 주의력 결핍이 의심됩니다.";
        }
        else if (wrong >= 15) {
            result = "매우 주의";
            detailResult = "총 게임 시간이 " + String.valueOf(time) + "초로 1분 미만이나," +
                    " 틀린 횟수가 " + String.valueOf(wrong) + "회로 15회 이상이므로" +
                    " 주의력 결핍이 매우 의심됩니다.";
        }

        dbHelper.insertGame1(dateFormat.format(currentDate), round, time, wrong, result, detailResult);

        Button moveButton=findViewById(R.id.button);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
