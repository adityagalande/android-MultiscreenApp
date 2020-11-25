package com.example.multiscreenapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<word> {
    private final int colorResourceID;
    public wordAdapter(Activity context, ArrayList<word> words, int colorResourceID) {
        super(context, 0, words);
        this.colorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the object located at this position
        word itemPosition = getItem(position);
        //Cheak if existing view is reused, Otherwise create the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_item_layout, parent, false);
        }

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultTextView);
        defaultTextView.setText(itemPosition.getDefaultTranslation());

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokTextView);
        miwokTextView.setText(itemPosition.getMiwokTranslationTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_image);
        if(itemPosition.hasImage()){
            imageView.setImageResource(itemPosition.getImageID());
            //imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        //set the theme color for listView (LinearLayout = [text_container])
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that resource ID map to
        int color = ContextCompat.getColor(getContext(), colorResourceID);
        //set Background color to text_container
        textContainer.setBackgroundColor(color);
        //return the whole listItemView layout (contaning two textviews)

        return listItemView;
    }
}