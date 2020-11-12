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

        family.add(new word("father", "әpә",R.drawable.family_father));
        family.add(new word("mother", "әṭa",R.drawable.family_mother));
        family.add(new word("son", "angsi",R.drawable.family_son));
        family.add(new word("daughter", "tune",R.drawable.family_daughter));
        family.add(new word("older brother", "taachi",R.drawable.family_older_brother));
        family.add(new word("younger brother", "chalitti",R.drawable.family_younger_brother));
        family.add(new word("older sister", "teṭe",R.drawable.family_older_sister));
        family.add(new word("younger sister", "kolliti",R.drawable.family_younger_sister));
        family.add(new word("grandmother", "ama",R.drawable.family_grandmother));
        family.add(new word("grandfather", "paapa",R.drawable.family_grandfather));

        ListView listView = (ListView) findViewById(R.id.familyView);
        wordAdapter familyArray = new wordAdapter(this,family);
        listView.setAdapter(familyArray);

    }
}