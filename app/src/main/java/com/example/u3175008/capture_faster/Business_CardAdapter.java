package com.example.u3175008.capture_faster;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by u3175008 on 22/03/2018.
 */
public class Business_CardAdapter extends ArrayAdapter<Business_Card> {

    ArrayList<Business_Card> events;

    public Business_CardAdapter(Context context, int resource, ArrayList<Business_Card> objects) {
        super(context, resource, objects);
        events = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.my_listview_item, parent, false);
        }

        Business_Card event = events.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        icon.setImageResource(R.mipmap.ic_minimal1_businesscard);
        //icon.setImageResource(R.mipmap.ic_neon_night);

        TextView title = (TextView) convertView.findViewById(R.id.textViewTitle);
        title.setText(event.getTitle());



        if (position % 2 == 0){
            convertView.setBackgroundColor(Color.parseColor("#ccffff"));
        }else{
            convertView.setBackgroundColor(Color.parseColor("#ffffe6"));
        }


        if (position % 2 == 0){
            convertView.setBackgroundColor(Color.parseColor("#ccffff"));
        }else{
            convertView.setBackgroundColor(Color.parseColor("#ffffe6"));
        }

        return convertView;
    }
}