package com.example.u3175008.capture_faster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Business_CardDetails extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business__card_details);
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


        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");
        String title = extras.getString("title");
        int imageRes = extras.getInt("imageResource");
        String date = extras.getString("date");

        TextView tv = (TextView) findViewById(R.id.businesscardname);
        tv.setText(title);
        ImageView image = (ImageView) findViewById(R.id.imageView3);
        //image.setImageResource(imageRes);
        tv = (TextView) findViewById(R.id.textViewSmall);
        tv.setText(date);

    }






    public void gotoeditpage(View v){
        Intent intent = new Intent(this, Edit.class);
        startActivity(intent);
    }


}
