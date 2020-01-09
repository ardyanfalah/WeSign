package com.example.wesignn;

import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    DisplayMetrics dm;
    VideoView videoViewSaya;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        // view
        videoViewSaya = findViewById(R.id.videoViewUtama);
    }

    public void video1(View v) {
        MediaController m = new MediaController(this);
        videoViewSaya.setMediaController(m);
        dm = new DisplayMetrics();

        // ambil ukuran layar
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        videoViewSaya.setMinimumWidth(width);
        videoViewSaya.setMinimumHeight(height);

        String path = "android.resource://"+getPackageName()+ "/" + R.raw.wesign;


        Uri u = Uri.parse(path);

        videoViewSaya.setVideoURI(u);

        videoViewSaya.start();

    }

}
