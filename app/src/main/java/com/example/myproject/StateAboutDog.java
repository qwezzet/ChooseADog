package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class StateAboutDog extends AppCompatActivity {
    State selectedState;
    Button btntotwo;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_stateaboutdog);
        getSelectedState();
        setValues();
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        btntotwo = findViewById(R.id.btnfromstatetotwo);
        btntotwo.setOnClickListener(v -> {
            Intent i = new Intent(StateAboutDog.this, TwoActivity.class);
            startActivity(i);
        });
    }

    private void getSelectedState() {
        Intent prevIntent = getIntent();
        String parsStringID = prevIntent.getStringExtra("id");
        selectedState = TwoActivity.stateList.get(Integer.parseInt(parsStringID));
    }

    private void setValues() {
        TextView textView = findViewById(R.id.dogname);

        TextView textView2 = findViewById(R.id.dogdescription);
        TextView textView3 = findViewById(R.id.dogsecondporoda);
        ImageView imageView = findViewById(R.id.picture);

        textView.setText(selectedState.getPoroda());

        textView2.setText(selectedState.getDescription());
        textView3.setText(selectedState.getSecondporoda());
        imageView.setImageResource(selectedState.getImagedog());
    }
}
