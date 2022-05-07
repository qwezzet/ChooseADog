package com.example.myproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnhello, btnclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        btnclose = findViewById(R.id.btnexit);
        btnhello = findViewById(R.id.btnfrommaintotwo);
        btnhello.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, TwoActivity.class);
            startActivity(i);
            btnhello.setTextColor(Color.GRAY);
        });
        btnclose.setOnClickListener(view -> finish());

    }

    public void showAlertDialogMain(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Информация о приложении");
        alert.setMessage("-Тут будет информация о приложении-");
        alert.setPositiveButton("Скрыть", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "С уважением от разработчика!", Toast.LENGTH_SHORT).show());
        alert.create().show();
    }
}