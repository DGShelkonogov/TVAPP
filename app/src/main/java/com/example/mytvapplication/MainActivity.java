package com.example.mytvapplication;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import java.util.Random;


public class MainActivity extends FragmentActivity {

    Button alarmButton;
    Handler handler = new Handler();
    Random random = new Random();
    String[] messages =  {"Еще", "Давай еще", "Чуть чуть осталось", "ДА"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmButton = findViewById(R.id.alarmButton);

        alarmButton.setOnClickListener(view -> {
            if(random.nextBoolean()){
                int index = rnd(0, messages.length-1);
                alarmButton.setText(messages[index]);
            }else{
                alarmButton.setText("Кто нажал тот лох");
                handler.postDelayed(timerRunnable, 3000);
            }
        });

    }

    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            alarmButton.setText("Умница");
        }
    };

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}