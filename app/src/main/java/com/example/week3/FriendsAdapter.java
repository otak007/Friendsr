package com.example.week3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FriendsAdapter extends ArrayAdapter<Friend> {
    // create array list with all the friends
    private ArrayList<Friend> friends;
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }
    // Make the gridview with the peoples name and picture
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.foto);
        imageView.setImageResource(friends.get(position).getDrawableId());
        TextView textView = convertView.findViewById(R.id.name);
        textView.setText(friends.get(position).getName());

        return convertView;
    }
}

