package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        ArrayList<word> numbers = new ArrayList<word>();
        numbers.add(new word("One", "lutti"));
        numbers.add(new word("Two", "otiiko"));
        numbers.add(new word("Three", "tolookosu"));
        numbers.add(new word("Four", "oyyisa"));
        numbers.add(new word("Five", "massokka"));
        numbers.add(new word("Six", "temmokka"));
        numbers.add(new word("Seven", "kenekaku"));
        numbers.add(new word("Eight", "kawinta"));
        numbers.add(new word("Nine", "wo'e"));
        numbers.add(new word("Ten", "na'aacha"));

        ListView listView = (ListView) findViewById(R.id.numberView);
        wordAdapter numberArray = new wordAdapter(this, numbers);
        listView.setAdapter(numberArray);

    }
}