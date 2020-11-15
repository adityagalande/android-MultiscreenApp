package com.example.multiscreenapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<word> {
    public wordAdapter(Activity context, ArrayList<word> words) {
        super(context, 0, words);
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
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(itemPosition.getImageID());
        }else {
            imageView.setVisibility(View.GONE);
        }

        //return the whole listItemView layout (contaning two textviews)
        return listItemView;
    }
}