package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by celena on 8/28/2017.
 */

public class WordAdapter extends ArrayAdapter <Word> {
    private int colorResourceId;

    public WordAdapter (Activity context, ArrayList <Word> words, int colorResource) {
        super (context, 0, words);
        colorResourceId = colorResource;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null)
            listItemView = LayoutInflater.from (getContext ()).inflate (R.layout.list_item, parent, false);

        Word currentWord = getItem (position);

        TextView miwokTextView = (TextView) listItemView.findViewById (R.id.miwok_text_view);
        miwokTextView.setText (currentWord.getMiwok ());

        TextView englishTextView = (TextView) listItemView.findViewById (R.id.english_text_view);
        englishTextView.setText (currentWord.getEnglish ());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_view);

        if (currentWord.getVisibility ()) {
            iconView.setImageResource(currentWord.getImageResourceID());
        }
        else {
            iconView.setVisibility (View.GONE);
        }

        View textContainer = listItemView.findViewById (R.id.text_container);
        int color = ContextCompat.getColor (getContext (), colorResourceId);
        textContainer.setBackgroundColor (color);

        return listItemView;
    }
}
