package com.example.myproject;

import android.annotation.SuppressLint;
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

public class Table extends AppCompatActivity implements View.OnClickListener {
    Button backtomain, aboutsizes;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_tabl);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        backtomain = findViewById(R.id.btnbacktomain);
        backtomain.setOnClickListener(v -> {
            Intent i = new Intent(Table.this, TwoActivity.class);
            startActivity(i);
            backtomain.setTextColor(Color.GRAY);
        });

        aboutsizes = findViewById(R.id.btnaboutsizes);
        aboutsizes.setOnClickListener(v -> {
            Intent intent = new Intent(Table.this, Description.class);
            startActivity(intent);
            aboutsizes.setTextColor(Color.GRAY);
        });


    }
    private void alertDialogs(int i2, int i3, int i4, int lengthShort) {
        String[] array = getResources().getStringArray(R.array.mainstates);
        String[] arraydesc = getResources().getStringArray(R.array.aboutsizesintable);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(array[i2]);
        alert.setMessage(arraydesc[i3]);
        alert.setPositiveButton(array[2], (dialogInterface, i) -> Toast.makeText(Table.this, array[i4], lengthShort).show());
        alert.create().show();
    }

    public void showAlertDialogInform1(View v) {
        alertDialogs(0, 0, 3, Toast.LENGTH_SHORT);
    }


    public void showAlertDialogInform2(View v) {
        alertDialogs(0, 1, 3, Toast.LENGTH_SHORT);
    }


    public void showAlertDialogInform3(View v) {
        alertDialogs(0, 2, 3, Toast.LENGTH_SHORT);
    }


    public void showAlertDialogInform4(View v) {
        alertDialogs(0, 3, 3, Toast.LENGTH_SHORT);
    }


    public void showAlertDialogDesk(View v) {
        alertDialogs(1, 4, 4, Toast.LENGTH_LONG);
    }

    public void onClick(View v) {
    }
}