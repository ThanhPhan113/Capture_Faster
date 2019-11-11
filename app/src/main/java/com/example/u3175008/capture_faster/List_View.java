package com.example.u3175008.capture_faster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class List_View extends AppCompatActivity {




    public void gotocaptureload(View v){
        Intent intent = new Intent(this, Capture_Load.class);
        startActivity(intent);
    }

    //String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        events = mydb.getAllEvents();
        if (events.isEmpty()) {
           mydb.insertEvent(new Business_Card("Business Card 1", R.drawable.minimal_businesscard, new Date(2017, 3, 3)));
           mydb.insertEvent(new Business_Card("Business Card 2", R.drawable.minimal_one_businesscard, new Date(2017, 3, 10)));
            mydb.insertEvent(new Business_Card("Business Card 3", R.drawable.minimal_two_businesscard, new Date(2017, 3, 3)));
            events = mydb.getAllEvents();
        }

        //events.add(new Business_Card("Business Card 1", R.drawable.minimal_businesscard, new Date(2017,3,3)));
        //events.add(new Business_Card("Business Card 2", R.drawable.minimal1_businesscard, new Date(2017,3,10)));
        //events.add(new Business_Card("Business Card 3", R.drawable.minimal2_businesscard, new Date(2017,3,3)));
        //ArrayAdapter<Business_Card> adapter = new ArrayAdapter<Business_Card>(this, android.R.layout.simple_list_item_1, events);
        Business_CardAdapter adapter = new Business_CardAdapter(
                this, R.layout.my_listview_item, events);
        ListView listView = (ListView) findViewById(R.id.listView);listView.setAdapter(adapter);



        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Business_Card cbrevent = events.get(position);
                        Intent intent = new Intent(view.getContext(), Business_CardDetails.class);
                        //intent.putExtra("id", cbrevent.get());//////////////////////////////
                        intent.putExtra("title", cbrevent.getTitle());
                        intent.putExtra("imageResource", cbrevent.getImageResource());
                        intent.putExtra("date", cbrevent.getDateString());
                        startActivity(intent);
                    }
                });
    }




    ArrayList<Business_Card> events = new ArrayList<Business_Card>();
    List_Viewhelper mydb = new List_Viewhelper(
            this, "List_Viewhelper", null, 4);


}
