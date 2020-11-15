package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ArrayList<word> color = new ArrayList<word>();
        color.add(new word("red","weṭeṭṭi",R.drawable.color_red));
        color.add(new word("green","chokokki",R.drawable.color_green));
        color.add(new word("brown","ṭakaakki",R.drawable.color_brown));
        color.add(new word("gray","ṭopoppi",R.drawable.color_gray));
        color.add(new word("black","kululli",R.drawable.color_black));
        color.add(new word("white","kelelli",R.drawable.color_white));
        color.add(new word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow));
        color.add(new word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow));

        ListView listView = (ListView) findViewById(R.id.colorView);
        wordAdapter colorArray = new wordAdapter(this, color, R.color.purple);
        listView.setAdapter(colorArray);

    }
}