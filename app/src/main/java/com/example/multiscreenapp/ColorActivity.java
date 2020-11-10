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
        color.add(new word("red","weṭeṭṭi"));
        color.add(new word("green","chokokki"));
        color.add(new word("brown","ṭakaakki"));
        color.add(new word("gray","ṭopoppi"));
        color.add(new word("black","kululli"));
        color.add(new word("white","kelelli"));
        color.add(new word("dusty yellow","ṭopiisә"));
        color.add(new word("musterd yellow","chiwiiṭә"));

        ListView listView = (ListView) findViewById(R.id.colorView);
        wordAdapter colorArray = new wordAdapter(this, color);
        listView.setAdapter(colorArray);

    }
}