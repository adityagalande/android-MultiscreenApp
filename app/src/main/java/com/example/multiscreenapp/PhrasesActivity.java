package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<word> phrases = new ArrayList<word>();
        phrases.add(new word("What is your name?","minto wuksus"));
        phrases.add(new word("What is your name?","tinnә oyaase'nә"));
        phrases.add(new word("My name is...","oyaaset..."));
        phrases.add(new word("How are you feeling?","michәksәs?"));
        phrases.add(new word("I’m feeling good.","kuchi achit"));
        phrases.add(new word("Are you coming?","әәnәs'aa?"));
        phrases.add(new word("Yes, I’m coming.","hәә’ әәnәm"));
        phrases.add(new word("Let’s go.","yoowutis"));
        phrases.add(new word("Come here.","әnni'nem"));

        ListView listView = (ListView) findViewById(R.id.phrasesview);
        wordAdapter phraseArray = new wordAdapter(this,phrases);
        listView.setAdapter(phraseArray);
    }
}