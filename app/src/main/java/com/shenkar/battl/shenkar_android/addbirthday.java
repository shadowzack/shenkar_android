package com.shenkar.battl.shenkar_android;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addbirthday extends AppCompatActivity {

    EditText firstname;
    EditText birthday;
    EditText comment;
    Button button;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbirthday);

        firstname =findViewById(R.id.firstname);
        birthday =findViewById(R.id.birthday);
        comment =findViewById(R.id.comment);
        button =findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 5/8/2018 save to db
            }
        });
    }
}
