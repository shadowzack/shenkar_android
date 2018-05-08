package com.shenkar.battl.shenkar_android;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BirthdayActivity extends AppCompatActivity {

    FloatingActionButton add;
    RecyclerView list;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = findViewById(R.id.list);



   AppDatabse db= Room.databaseBuilder(getApplicationContext(),AppDatabse.class,"new").allowMainThreadQueries().build();

        List<birthday> birthdays=db.birthdayDAO().getallbirthdays();
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BirthdayAdapter(birthdays);
        list.setAdapter(adapter);


        add =findViewById(R.id.add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BirthdayActivity.this,addbirthday.class));
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
       // onBackPressed();
        startActivity(new Intent(BirthdayActivity.this,MainActivity.class));
        return true;
    }
}
