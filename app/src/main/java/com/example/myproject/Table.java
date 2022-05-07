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

    public void showAlertDialogInform1(View v){
        String[] array = getResources().getStringArray(R.array.mainstates);
        String[] arraydesc = getResources().getStringArray(R.array.aboutsizesintable);
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle(array[0]);
        alert.setMessage(arraydesc[0]);
        alert.setPositiveButton(array[2], (dialogInterface, i) -> Toast.makeText(Table.this,array[3], Toast.LENGTH_SHORT).show());
        alert.create().show();
    }



    public void showAlertDialogInform2(View v){
        String[] array = getResources().getStringArray(R.array.mainstates);
        String[] arraydesc = getResources().getStringArray(R.array.aboutsizesintable);
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle(array[0]);
        alert.setMessage(arraydesc[1]);
        alert.setPositiveButton(array[2], (dialogInterface, i) -> Toast.makeText(Table.this,array[3], Toast.LENGTH_SHORT).show());
        alert.create().show();
    }





    public void showAlertDialogInform3(View v){
        String[] array = getResources().getStringArray(R.array.mainstates);
        String[] arraydesc = getResources().getStringArray(R.array.aboutsizesintable);
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle(array[0]);
        alert.setMessage(arraydesc[2]);
        alert.setPositiveButton(array[2], (dialogInterface, i) -> Toast.makeText(Table.this,array[3], Toast.LENGTH_SHORT).show());
        alert.create().show();
    }





    public void showAlertDialogInform4(View v){
        String[] array = getResources().getStringArray(R.array.mainstates);
        String[] arraydesc = getResources().getStringArray(R.array.aboutsizesintable);
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        setTitle(array[0]);
        alert.setMessage(arraydesc[3]);
        alert.setPositiveButton(array[2], (dialogInterface, i) -> Toast.makeText(Table.this,array[3], Toast.LENGTH_SHORT).show());
        alert.create().show();
    }





    public void showAlertDialogDesk(View v){
        String[] array = getResources().getStringArray(R.array.mainstates);
        String[] arraydesc = getResources().getStringArray(R.array.aboutsizesintable);
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle(array[1]);
        alert.setMessage(arraydesc[4]);
        alert.setPositiveButton(array[2], (dialogInterface, i) -> Toast.makeText(Table.this,array[4], Toast.LENGTH_LONG).show());
        alert.create().show();
    }
    public void onClick(View v) {
    }
}