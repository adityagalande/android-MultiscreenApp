package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView family = (TextView) findViewById(R.id.family);
        TextView colors = (TextView) findViewById(R.id.colors);
        TextView phrases = (TextView) findViewById(R.id.phrases);

        numbers.setOnClickListener(this);
        family.setOnClickListener(this);
        colors.setOnClickListener(this);
        phrases.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.numbers:
                Intent number = new Intent(this, NumberActivity.class);
                startActivity(number);
                break;

            case R.id.family:
                Intent family = new Intent(this, FamilyActivity.class);
                startActivity(family);
                break;

            case R.id.colors:
                Intent color = new Intent(this, ColorActivity.class);
                startActivity(color);
                break;

            case R.id.phrases:
                Intent phrases = new Intent(this, PhrasesActivity.class);
                startActivity(phrases);
                break;
        }

    }
}