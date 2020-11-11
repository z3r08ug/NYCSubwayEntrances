package com.riproad.android.interviewtestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton btnShowSubwayEntrances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowSubwayEntrances = findViewById(R.id.btnShowSubwayEntrances);
        btnShowSubwayEntrances.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() != btnShowSubwayEntrances.getId()) {
            return;
        }

//        Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SubwayEntrancesActivity.class));
    }
}