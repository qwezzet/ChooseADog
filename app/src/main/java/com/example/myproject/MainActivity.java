package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnhello, btnclose, btnAlert, btnFrAlert;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        setContentView(R.layout.activity_main);
        btnclose = findViewById(R.id.btnexit);
        btnhello = findViewById(R.id.btnfrommaintotwo);
        btnAlert = findViewById(R.id.btnaboutall);
        btnFrAlert = findViewById(R.id.abBtn);
        btnAlert.setOnClickListener(view -> dialogGet());


        btnhello.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, TwoActivity.class);
            startActivity(i);
            btnhello.setTextColor(Color.GRAY);
        });
        btnclose.setOnClickListener(view -> {
            Intent ActivityClose = new Intent(getApplicationContext(), SplashActivity.class);
            ActivityClose.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ActivityClose.putExtra("EXIT",true);
            startActivity(ActivityClose);
            finish();
            System.exit(0);
        });
    }


    public void dialogGet() {
        String[] array = getResources().getStringArray(R.array.mainarray);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_layout, findViewById(R.id.dialLay));
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        btnFrAlert = view.findViewById(R.id.abBtn);
        btnFrAlert.setOnClickListener(view1 -> {
            alertDialog.cancel();
            Toast.makeText(MainActivity.this, array[0], Toast.LENGTH_SHORT).show();
        });
        alertDialog.show();
    }


}