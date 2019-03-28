package com.example.lenovo.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
     Button b1,b2,b3;
     VideoView videoView;
     MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        videoView=(VideoView)findViewById(R.id.video);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(R.raw.m1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(R.raw.m2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(R.raw.m3);
            }
        });

    }

    private void submit(int res) {

            if (mediaController==null){
                mediaController = new MediaController(MainActivity.this);
            }
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+res));
            videoView.requestFocus();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    videoView.seekTo(0);
                    videoView.start();
                }
            });

    }
}
