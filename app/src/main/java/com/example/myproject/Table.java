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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Table extends AppCompatActivity {
    RecyclerView recycler_view;
    RecyclerAdapter adapter;
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


        recycler_view = findViewById(R.id.recycler_view);
        setRecyclerView();


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
        btnAlertTablAll.setOnClickListener(view -> dialogGetTabl());
    }

    private void setRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, getList());
        recycler_view.setAdapter(adapter);
    }
    private List< ClassForRecycler> getList(){
        String[] s = getResources().getStringArray(R.array.sizez);
        String[] r = getResources().getStringArray(R.array.sizez_d);
        List<ClassForRecycler> recycler_list = new ArrayList<>();
        recycler_list.add(new ClassForRecycler(s[0],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[0],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[0],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[1],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[1],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[1],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[2],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[2],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[2],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[3],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[3],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[3],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[4],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[4],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[4],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[5],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[5],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[5],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[6],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[6],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[6],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[7],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[7],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[7],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[8],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[8],r[0],r[2],r[2]));
        recycler_list.add(new ClassForRecycler(s[8],r[0],r[4],r[2]));
        recycler_list.add(new ClassForRecycler(s[9],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[9],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[9],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[10],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[10],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[10],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[11],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[11],r[0],r[2],r[7]));
        recycler_list.add(new ClassForRecycler(s[11],r[0],r[2],r[7]));

        return recycler_list;
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
        btnFrAlertTabl.setOnClickListener(view -> {
            alertDialogTabl.cancel();
            Toast.makeText(Table.this, arrayTabl[0], Toast.LENGTH_SHORT).show();
        });
        alertDialogTabl.show();
    }
}