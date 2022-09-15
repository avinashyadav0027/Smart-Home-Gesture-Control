package com.example.smarthomegesturecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

public class Screen2 extends AppCompatActivity {
    private VideoView videoView;
    private Button practiceButton;
    private int numberOfTimesVideoPlayed;
    private ImageButton imageButton;
    public  int address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        String gestureVideoName = getIntent().getStringExtra("Gesture");

        Toast.makeText(getApplicationContext(), String.valueOf(gestureVideoName)+"gesture", Toast.LENGTH_SHORT).show();

        getAddress(gestureVideoName);
        videoView = (VideoView) findViewById(R.id.videoView);
        practiceButton = (Button) findViewById(R.id.practiceButton);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setVisibility(View.INVISIBLE);
        String videoPath = "android.resource://" + getPackageName() + "/" + address;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.start();
        numberOfTimesVideoPlayed = 0;


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButton.setVisibility(View.INVISIBLE);
                videoView.start();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screen2.this, Screen3.class);
                Bundle b = new Bundle();
                b.putString("Gesture", gestureVideoName);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                numberOfTimesVideoPlayed++;
                imageButton.setVisibility(View.VISIBLE);

            }
        });

    }

    void getAddress(String gestureName) {


        switch (gestureName) {
            case "0":
                address = R.raw.h0;
                break;
            case "1":
                address = R.raw.h1;
                break;
            case "2":
                address = R.raw.h2;
                break;
            case "3":
                address = R.raw.h3;
                break;
            case "4":
                address = R.raw.h4;
                break;
            case "5":
                address = R.raw.h5;
                break;
            case "6":
                address = R.raw.h6;
                break;
            case "7":
                address = R.raw.h7;
                break;
            case "8":
                address = R.raw.h8;
                break;
            case "9":
                address = R.raw.h9;
                break;
            case "Turn on lights":
                address = R.raw.hlighton;
                break;
            case "Turn off lights":
                address = R.raw.hlightoff;
                break;
            case "Turn on fan":
                address = R.raw.hfanon;
                break;
            case "Turn off fan":
                address = R.raw.hfanoff;
                break;
            case "Increase fan speed":
                address = R.raw.hincreasefanspeed;
                break;
            case "Decrease fan speed":
                address = R.raw.hdecreasefanspeed;
                break;
            case "Set Thermostat to specified temperature":
                address = R.raw.hsetthermo;
                break;
            default:
                address = R.raw.h0;
                break;
        }

    }
}