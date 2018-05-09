package com.shenkar.battl.shenkar_android;

import android.app.DatePickerDialog;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class addbirthday extends AppCompatActivity {

    EditText firstname;
    EditText comment;
    Button button;
    Date maindate;
    EditText birthday_feild;
    private DatePickerDialog.OnDateSetListener DateSetListener;

    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbirthday);

        firstname =findViewById(R.id.firstname);
        comment =findViewById(R.id.comment);
        button =findViewById(R.id.button);
        birthday_feild=findViewById(R.id.birthday);

        birthday_feild.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar cal=Calendar.getInstance();
               int year = cal.get(Calendar.YEAR);
               int month = cal.get(Calendar.MONTH);
               int day = cal.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog dialog = new DatePickerDialog(
                       addbirthday.this,
                       android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                       DateSetListener,
                       year,month,day);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();
           }
       });
        DateSetListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               month = month + 1;
               Log.d("main", "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);
               String date = month + "/" + dayOfMonth + "/" + year;
               String tmpDate= year + "-" + month + "-" + dayOfMonth;
               SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
               try {
                   maindate = dateFormat.parse(date);
               } catch (ParseException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
               
               birthday_feild.setText(date);
           }
       };

       final AppDatabse db= Room.databaseBuilder(getApplicationContext(),AppDatabse.class,"birthday").allowMainThreadQueries().build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                //check if all fields are entered
                if(TextUtils.isEmpty(firstname.getText().toString())) {
                    firstname.setError("you must enter your firstname");
                    return;
                }
                if(TextUtils.isEmpty(comment.getText().toString())) {
                    comment.setError("you must add a comment");
                    return;
                }
                if(TextUtils.isEmpty(birthday_feild.getText().toString())) {
                    birthday_feild.setError("you must choose birthdate");
                    return;
                }

                // TODO: 5/8/2018 save to db
                Log.d("myTag ",birthday_feild.getText().toString() +"-------------------" + maindate.toString());

                //db.birthdayDAO().nukeTable();    //in case you want to empty the db
                
                db.birthdayDAO().instetall(new birthday(firstname.getText().toString(),maindate ,comment.getText().toString()));
                startActivity(new Intent(addbirthday.this,BirthdayActivity.class));
            }
        });
    }

}






