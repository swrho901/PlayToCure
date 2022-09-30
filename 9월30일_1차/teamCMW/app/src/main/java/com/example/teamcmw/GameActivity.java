package com.example.teamcmw;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    public int[] visit = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //index : 0 - 25

    public int TotalNum = 25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView tv1 = findViewById(R.id.textView1);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);
        TextView tv5 = findViewById(R.id.textView5);
        TextView tv6 = findViewById(R.id.textView6);
        TextView tv7 = findViewById(R.id.textView7);
        TextView tv8 = findViewById(R.id.textView8);
        TextView tv9 = findViewById(R.id.textView9);
        TextView tv10 = findViewById(R.id.textView10);
        TextView tv11 = findViewById(R.id.textView11);
        TextView tv12 = findViewById(R.id.textView12);
        TextView tv13 = findViewById(R.id.textView13);
        TextView tv14 = findViewById(R.id.textView14);
        TextView tv15 = findViewById(R.id.textView15);
        TextView tv16 = findViewById(R.id.textView16);
        TextView tv17 = findViewById(R.id.textView17);
        TextView tv18 = findViewById(R.id.textView18);
        TextView tv19 = findViewById(R.id.textView19);
        TextView tv20 = findViewById(R.id.textView20);
        TextView tv21 = findViewById(R.id.textView21);
        TextView tv22 = findViewById(R.id.textView22);
        TextView tv23 = findViewById(R.id.textView23);
        TextView tv24 = findViewById(R.id.textView24);
        TextView tv25 = findViewById(R.id.textView25);

        for(int i=0;i<=25;i++)
            visit[i] = 0;

        Random rand = new Random();
 //       rand.nextInt(25);
        int idx = 0;

        while(checkFull() == 0){
            int nx = rand.nextInt(25) + 1; // 1 - 25
            String num = Integer.toString(nx);
            if(visit[nx] == 1) continue;
            visit[nx] = 1;
            idx++;
            switch(nx){
                case 1:
                    tv1.setText(" " + idx + " ");
                    break;
                case 2:
                    tv2.setText(" " + idx + " ");
                    break;
                case 3:
                    tv3.setText(" " + idx + " ");
                    break;
                case 4:
                    tv4.setText(" " + idx + " ");
                    break;
                case 5:
                    tv5.setText(" " + idx + " ");
                    break;
                case 6:
                    tv6.setText(" " + idx + " ");
                    break;
                case 7:
                    tv7.setText(" " + idx + " ");
                    break;
                case 8:
                    tv8.setText(" " + idx + " ");
                    break;
                case 9:
                    tv9.setText(" " + idx + " ");
                    break;
                case 10:
                    tv10.setText(" " + idx + " ");
                    break;
                case 11:
                    tv11.setText(" " + idx + " ");
                    break;
                case 12:
                    tv12.setText(" " + idx + " ");
                    break;
                case 13:
                    tv13.setText(" " + idx + " ");
                    break;
                case 14:
                    tv14.setText(" " + idx + " ");
                    break;
                case 15:
                    tv15.setText(" " + idx + " ");
                    break;
                case 16:
                    tv16.setText(" " + idx + " ");
                    break;
                case 17:
                    tv17.setText(" " + idx + " ");
                    break;
                case 18:
                    tv18.setText(" " + idx + " ");
                    break;
                case 19:
                    tv19.setText(" " + idx + " ");
                    break;
                case 20:
                    tv20.setText(" " + idx + " ");
                    break;
                case 21:
                    tv21.setText(" " + idx + " ");
                    break;
                case 22:
                    tv22.setText(" " + idx + " ");
                    break;
                case 23:
                    tv23.setText(" " + idx + " ");
                    break;
                case 24:
                    tv24.setText(" " + idx + " ");
                    break;
                case 25:
                    tv25.setText(" " + idx + " ");
                    break;
            }
        }
    }
    public int checkFull() {
        for(int i=1;i<=25;i++){
            if(visit[i] == 0)
                return 0; // 체크 다 됨
        }
        return 1; // 가득 참
    }

}
