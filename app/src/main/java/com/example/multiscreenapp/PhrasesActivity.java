package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<word> phrases = new ArrayList<word>();
        phrases.add(new word("What is your name?", "minto wuksus", R.raw.phrase_what_is_your_name));
        phrases.add(new word("Where you are going?", "tinnә oyaase'nә", R.raw.phrase_where_are_you_going));
        phrases.add(new word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrases.add(new word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        phrases.add(new word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        ListView listView = (ListView) findViewById(R.id.phrasesview);
        wordAdapter phraseArray = new wordAdapter(this, phrases, R.color.blue);
        listView.setAdapter(phraseArray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = phrases.get(position);
                releaseMediaplayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceID());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaplayer();
                    }
                });
            }
        });
    }

    protected void onStop() {
        super.onStop();
        releaseMediaplayer();
    }

    private void releaseMediaplayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}