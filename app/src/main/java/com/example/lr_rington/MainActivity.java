package com.example.lr_rington;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Vibrator vibrator;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mediaPlayer = MediaPlayer.create(this, R.raw.doroga);

    }

    public void btn_click(View view) {

        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(this,R.raw.doroga);
        }
        mediaPlayer.start();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Новые версии

//            long[] pattern = {0, 400, 200, 400};
            long[] pattern = {5000, 4000, 3000, 2000, 1000} ;
            int[] amplitude = {255, 200, 150, 100, 50};
//            long[] pattern = {0, 400, 200, 400, 0, 400, 200, 400, 0, 400, 200, 400, 0, 400, 200, 400};
            vibrator.vibrate(VibrationEffect.createWaveform(pattern,amplitude, -1));

            //vibrator.vibrate(VibrationEffect.createOneShot(5000, 125));

        }
        else {
            vibrator.vibrate(5000);
        }
    }
}