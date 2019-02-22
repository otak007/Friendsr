package com.example.week3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;
    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // display the right picture, bio and name after click the friend
        ImageView imageView = findViewById(R.id.foto);
        imageView.setImageResource(retrievedFriend.getDrawableId());
        TextView name = findViewById(R.id.name);
        name.setText(retrievedFriend.getName());
        TextView bio = findViewById(R.id.bio);
        bio.setText(retrievedFriend.getBio());

        // save the rating on the rating-bar
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();
        float rating = prefs.getFloat(retrievedFriend.getName(), (float) 0.0);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBarChangeListener());
    }
    //create the rating-bar
    private class RatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            editor.putFloat(retrievedFriend.getName(),v);
            editor.apply();
            retrievedFriend.setRating(v);
        }
    }
}

