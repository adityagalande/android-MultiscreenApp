package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<word> family = new ArrayList<word>();

        family.add(new word("father", "әpә"));
        family.add(new word("mother", "әṭa"));
        family.add(new word("son", "angsi"));
        family.add(new word("daughter", "tune"));
        family.add(new word("older brother", "taachi"));
        family.add(new word("younger brother", "chalitti"));
        family.add(new word("older sister", "teṭe"));
        family.add(new word("younger sister", "kolliti"));
        family.add(new word("grandmother", "ama"));
        family.add(new word("grandfather", "paapa"));

        ListView listView = (ListView) findViewById(R.id.familyView);
        wordAdapter familyArray = new wordAdapter(this,family);
        listView.setAdapter(familyArray);

    }
}