package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        final  ArrayList<word> color = new ArrayList<word>();
        color.add(new word("red","weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        color.add(new word("green","chokokki",R.drawable.color_green, R.raw.color_green));
        color.add(new word("brown","ṭakaakki",R.drawable.color_brown, R.raw.color_brown));
        color.add(new word("gray","ṭopoppi",R.drawable.color_gray, R.raw.color_gray));
        color.add(new word("black","kululli",R.drawable.color_black, R.raw.color_black));
        color.add(new word("white","kelelli",R.drawable.color_white, R.raw.color_white));
        color.add(new word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        color.add(new word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        ListView listView = (ListView) findViewById(R.id.colorView);
        wordAdapter colorArray = new wordAdapter(this, color, R.color.purple);
        listView.setAdapter(colorArray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = color.get(position);
                mediaPlayer = MediaPlayer.create(ColorActivity.this, word.getAudioResourceID());
                mediaPlayer.start();
            }
        });

    }
}