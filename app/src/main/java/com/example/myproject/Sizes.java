package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Sizes extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageButton beforeBtn, nextBtn;
    ImageSwitcher imageSwitcher;
    int index = 0;
    int[] dogsarray = {R.drawable.img_to_switch_1, R.drawable.img_to_switch_2, R.drawable.img_to_switch_3};

    @SuppressLint({"NonConstantResourceId", "SourceLockedOrientationActivity"})
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        setContentView(R.layout.activity_sizes);


        beforeBtn = findViewById(R.id.before);
        nextBtn = findViewById(R.id.next);
        imageSwitcher = findViewById(R.id.imageSwitch);


        beforeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --index;
                if (index < 0) {
                    index = dogsarray.length - 1;
                    imageSwitcher.setImageResource(dogsarray[index]);
                } else {
                    imageSwitcher.setImageResource(dogsarray[index]);
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index == dogsarray.length) {
                    index = 0;
                }

                imageSwitcher.setImageResource(dogsarray[index]);

            }
        });
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                return imageView;
            }
        });
        imageSwitcher.setImageResource(dogsarray[index]);


        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.desc_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.start_menu:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.home_menu:
                    startActivity(new Intent(getApplicationContext(), TwoActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.table_menu:
                    startActivity(new Intent(getApplicationContext(), Table.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.desc_menu:
                    return true;
            }
            return false;
        });
    }
}