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

public class NumberActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

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
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<word> numbers = new ArrayList<word>();
        numbers.add(new word("One", "lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new word("Two", "otiiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new word("Three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new word("Four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new word("Five", "massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new word("Six", "temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new word("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new word("Ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        ListView listView = (ListView) findViewById(R.id.numberView);
        wordAdapter numberArray = new wordAdapter(this, numbers, R.color.yellow);
        listView.setAdapter(numberArray);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = numbers.get(position);
                //It release resources before occupying
                releaseMediaPlayer();

                int result = audioManager.requestAudioFocus(AudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now


                    mediaPlayer = MediaPlayer.create(NumberActivity.this, word.getAudioResourceID());
                    mediaPlayer.start();

                    //It release resources after occupying
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(AudioFocusChangeListener);
        }
    }
}