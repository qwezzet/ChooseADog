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

public class Table extends AppCompatActivity implements View.OnClickListener {
    Button backtomain, aboutsizes;
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
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle("Рекомендация :)");
        alert.setMessage("Чаще всего питомца маленького размера заводят по простой причине — он не требует много места. Дома ему понадобится лежанка, хотя скорее всего малыш будет проводить время на диване рядом с хозяином. Любимца легко взять с собой в путешествие или гости, разместив в пути у себя на коленях. ");
        alert.setPositiveButton("Скрыть", (dialogInterface, i) -> Toast.makeText(Table.this,"Удачного выбора!", Toast.LENGTH_SHORT).show());
        alert.create().show();
    }



    public void showAlertDialogInform2(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle("Рекомендация :)");
        alert.setMessage("Данная разновидность собак очень хорошо подойдет каждому человеку, ведь породы включенные в эту разновидность не достигают больших размеров в росте, не требуют к себе особенного ухода, только любовь и ласка. Но несмотря на их маленький рост они очень умны и дружелюбны к людям.");
        alert.setPositiveButton("Скрыть", (dialogInterface, i) -> Toast.makeText(Table.this,"Удачного выбора!", Toast.LENGTH_SHORT).show());
        alert.create().show();
    }





    public void showAlertDialogInform3(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle("Рекомендация :)");
        alert.setMessage("Собаки среднего размера универсальны, их можно содержать в небольшой городской квартире, частном доме, многие породы отлично будут себя чувствовать на улице в вольере и будке. При принятии решения завести четвероногого друга, необходимо определиться, кто необходим семье: питомец, который будет радовать своим присутствием, охранник и защитник дома и ребёнка или рабочая собака, которая будет сопровождать хозяина на охоте.");
        alert.setPositiveButton("Скрыть", (dialogInterface, i) -> Toast.makeText(Table.this,"Удачного выбора!", Toast.LENGTH_SHORT).show());
        alert.create().show();
    }





    public void showAlertDialogInform4(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle("Рекомендация :)");
        alert.setMessage("Заводя питомца крупной породы, необходимо обеспечить ему условия комфортного проживания. Обладателям загородного дома можно приобрести любую породу, которые будут плохо себя чувствовать в условиях городской квартиры и создадут массу неудобств при взрослении. Для квартирного содержания подойдёт не каждая собака и перед выбором нужно проанализировать свои возможности и особенности содержания породы.");
        alert.setPositiveButton("Скрыть", (dialogInterface, i) -> Toast.makeText(Table.this,"Удачного выбора!", Toast.LENGTH_SHORT).show());
        alert.create().show();
    }





    public void showAlertDialogDesk(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle("Внимание!");
        alert.setMessage("В данной таблице представлены приблизительные значения и размеры разных пород собак. Для достоверной информации необходима консультация специалиста.");
        alert.setPositiveButton("Скрыть", (dialogInterface, i) -> Toast.makeText(Table.this,"Спасибо за понимание!", Toast.LENGTH_LONG).show());
        alert.create().show();
    }
    public void onClick(View v) {
    }
}