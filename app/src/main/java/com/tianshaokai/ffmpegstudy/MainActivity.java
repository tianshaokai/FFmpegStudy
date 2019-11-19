package com.tianshaokai.ffmpegstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tianshaokai.myplayer.MyPlayer;

public class MainActivity extends AppCompatActivity {

    private TextView tvStart;


    private MyPlayer myPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStart = findViewById(R.id.tvStart);

        myPlayer = new MyPlayer();
        myPlayer.setResource("http://mpge.5nd.com/2015/2015-11-26/69708/1.mp3");
        myPlayer.prepare();
    }
}
