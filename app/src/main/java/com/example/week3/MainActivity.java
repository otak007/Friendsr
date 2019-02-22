package com.example.week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // create an array list friends
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the friends with their name and bio
        Friend arya = new Friend("Arya", "Hi",getResources().getIdentifier("arya",
                "drawable", getPackageName()));
        Friend cersei = new Friend("Cersei", "Hi how are you",
                getResources().getIdentifier("cersei","drawable", getPackageName()));
        Friend daenerys = new Friend("Daenerys", "Enjoy life",
                getResources().getIdentifier("daenerys","drawable", getPackageName()));
        Friend jaime = new Friend("Jaime", "Traveler",
                getResources().getIdentifier("jaime","drawable", getPackageName()));
        Friend jon = new Friend("Jon", "Spontaneous",getResources().getIdentifier("jon",
                "drawable", getPackageName()));
        Friend jorah = new Friend("Jorah", "Searching for a men",
                getResources().getIdentifier("jorah","drawable", getPackageName()));
        Friend margaery = new Friend("Margaery", "Love to eat",
                getResources().getIdentifier("margaery","drawable", getPackageName()));
        Friend melisandre = new Friend("Melisandre", "Searching for a girl",
                getResources().getIdentifier("melisandre","drawable", getPackageName()));
        Friend sansa = new Friend("Sansa", "YOLO",
                getResources().getIdentifier("sansa","drawable", getPackageName()));
        Friend tyrion = new Friend("Tyrion", "Party",
                getResources().getIdentifier("tyrion","drawable", getPackageName()));

        Friend[] nameFriends = {arya, cersei, daenerys, jaime, jon, jorah, margaery, melisandre, sansa, tyrion};

        // put the friends in the array list
        for (int i = 0; i<nameFriends.length; i++){
            friends.add(nameFriends[i]);
        }

        // connect the layout with the list friends
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        // call GridItemClickListener after a friend is clicked
        gridView.setOnItemClickListener(new GridItemClickListener());
    }
    // Show the profile of the friend that is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}
