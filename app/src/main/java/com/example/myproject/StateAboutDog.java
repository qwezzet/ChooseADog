package com.example.myproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class StateAboutDog extends AppCompatActivity {
    State selectedState;
    Button btntotwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_stateaboutdog);
        getSelectedState();
        setValues();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btntotwo = findViewById(R.id.btnfromstatetotwo);
        btntotwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StateAboutDog.this, TwoActivity.class);
                startActivity(i);
            }
        });
    }

    private void getSelectedState() {
        Intent prevIntent = getIntent();
        String parsStringID = prevIntent.getStringExtra("id");
        selectedState = TwoActivity.stateList.get(Integer.valueOf(parsStringID));
    }

    private void setValues() {
        TextView textView = (TextView) findViewById(R.id.dogname);
        ImageView imageView = (ImageView) findViewById(R.id.picture);

        textView.setText(selectedState.getPoroda());
        imageView.setImageResource(selectedState.getImagedog());
    }
}
