package com.tianshaokai.ffmpegstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.tianshaokai.myplayer.MyPlayer;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnStop;


    private MyPlayer myPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        myPlayer = new MyPlayer();
        myPlayer.setResource("http://mpge.5nd.com/2015/2015-11-26/69708/1.mp3");
        myPlayer.prepare();
    }
}
