package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Description extends AppCompatActivity {
    Button back;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        setContentView(R.layout.activity_description);
        VideoView videoView = findViewById(R.id.videodescription);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.videosobaka;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        BottomNavigationView bottomNavi = findViewById(R.id.bottom_navi);
        bottomNavi.setOnNavigationItemSelectedListener(navListener);


        back = findViewById(R.id.btnfromvideototable);
        back.setOnClickListener(v -> {
            Intent i = new Intent(Description.this, Table.class);
            startActivity(i);
            back.setTextColor(Color.GRAY);
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.first_step:
                    selectedFragment = new StepFragment_1();
                    break;
                case R.id.second_step:
                    selectedFragment = new StepFragment_2();
                    break;
                case R.id.third_step:
                    selectedFragment = new StepFragment_3();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont,selectedFragment).commit();
            return true;
        }
    };

}
