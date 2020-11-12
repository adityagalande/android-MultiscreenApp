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
        numbers.add(new word("One","lutti",R.drawable.number_one));
        numbers.add(new word("Two","otiiko",R.drawable.number_two));
        numbers.add(new word("Three","tolookosu",R.drawable.number_three));
        numbers.add(new word("Four","oyyisa",R.drawable.number_four));
        numbers.add(new word("Five","massokka",R.drawable.number_five));
        numbers.add(new word("Six","temmokka",R.drawable.number_six));
        numbers.add(new word("Seven","kenekaku",R.drawable.number_seven));
        numbers.add(new word("Eight","kawinta",R.drawable.number_eight));
        numbers.add(new word("Nine","wo'e",R.drawable.number_nine));
        numbers.add(new word("Ten","na'aacha",R.drawable.number_ten));

        ListView listView = (ListView) findViewById(R.id.numberView);
        wordAdapter numberArray = new wordAdapter(this, numbers);
        listView.setAdapter(numberArray);

    }
}