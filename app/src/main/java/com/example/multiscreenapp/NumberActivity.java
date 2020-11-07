package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("One");
        numbers.add("Two");
        numbers.add("Three");
        numbers.add("Four");
        numbers.add("Five");
        numbers.add("Six");
        numbers.add("Seven");
        numbers.add("Eight");
        numbers.add("Nine");
        numbers.add("Ten");
        numbers.add("Eleven");
        numbers.add("Twelve");
        numbers.add("Thirteen");
        numbers.add("Fourteen");
        numbers.add("Fifteen");
        numbers.add("Sixteen");
        numbers.add("Seventeen");
        numbers.add("Eightteen");
        numbers.add("Ninteen");
        numbers.add("Twenty");

        ListView listView = (ListView) findViewById(R.id.numberView);
        ArrayAdapter<String> numArray = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, numbers);
        listView.setAdapter(numArray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumberActivity.this, "Selected position " + (position + 1) + " " + numbers.get(position), Toast.LENGTH_SHORT).show();
                Toast.makeText(NumberActivity.this, "The selected position " + (position + 1) + " " + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}