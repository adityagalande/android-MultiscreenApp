package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener AudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                // Pause playback
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playing
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                //Cleanup resource
                releaseMediaplayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        //Create and setUp the audio focus
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<word> family = new ArrayList<word>();

        family.add(new word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        family.add(new word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        family.add(new word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        family.add(new word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family.add(new word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        family.add(new word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        ListView listView = (ListView) findViewById(R.id.familyView);
        wordAdapter familyArray = new wordAdapter(this, family, R.color.green);
        listView.setAdapter(familyArray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = family.get(position);
                releaseMediaplayer();

                int result = audioManager.requestAudioFocus(AudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceID());
                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaplayer();
                        }
                    });
                }
            }
        });

    }

    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
    }

    private void releaseMediaplayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(AudioFocusChangeListener);
        }
    }
}