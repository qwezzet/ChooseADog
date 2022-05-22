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

public class Table extends AppCompatActivity  {
    Button backtomain, aboutsizes, btnAlertTablAll, btnFrAlertTabl;


    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        btnAlertTablAll = findViewById(R.id.btniform);
        btnFrAlertTabl = findViewById(R.id.abcBtn);
        btnAlertTablAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogGetTabl();
            }
        });
    }


    public void dialogGetTabl() {
        String[] arrayTabl = getResources().getStringArray(R.array.mainarray);
        AlertDialog.Builder builderTabl = new AlertDialog.Builder(this);
        View viewtab = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_layout_tabl, findViewById(R.id.dialLayTable));
        builderTabl.setView(viewtab);
        AlertDialog alertDialogTabl = builderTabl.create();
        alertDialogTabl.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogTabl.setCancelable(false);
        btnFrAlertTabl = viewtab.findViewById(R.id.abcBtn);
        btnFrAlertTabl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogTabl.cancel();
                Toast.makeText(Table.this, arrayTabl[0], Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogTabl.show();
    }
    private void alertDialogs(int i3) {
        String[] array = getResources().getStringArray(R.array.mainstates);
        String[] arraydesc = getResources().getStringArray(R.array.aboutsizesintable);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(array[0]);
        alert.setMessage(arraydesc[i3]);
        alert.setPositiveButton(array[2], (dialogInterface, i) -> Toast.makeText(Table.this, array[3], Toast.LENGTH_SHORT).show());
        alert.create().show();
    }

    public void showAlertDialogInform1(View v) {
        alertDialogs(0);
    }


    public void showAlertDialogInform2(View v) {
        alertDialogs(1);
    }


    public void showAlertDialogInform3(View v) {
        alertDialogs(2);
    }


    public void showAlertDialogInform4(View v) {
        alertDialogs(3);
    }
}