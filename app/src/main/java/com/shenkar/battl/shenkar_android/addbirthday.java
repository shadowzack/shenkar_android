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
   // DatePicker birthday;
    EditText comment;
    Button button;
    //Calendar clndr;
   //EditText editText;
    //EditText birthday;
    Date maindate;

    EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbirthday);

        firstname =findViewById(R.id.firstname);
       //birthday =findViewById(R.id.birthday);
        comment =findViewById(R.id.comment);
        button =findViewById(R.id.button);
   // editText=findViewById(R.id.editText);


      /*  final int day = birthday.getDayOfMonth();
        final int month = birthday.getMonth();
        int year =  birthday.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

        final String dateFormat = dateformat.format(new Date(birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth()));
        */
       mDisplayDate=findViewById(R.id.birthday);

       mDisplayDate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar cal=Calendar.getInstance();
               int year = cal.get(Calendar.YEAR);
               int month = cal.get(Calendar.MONTH);
               int day = cal.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog dialog = new DatePickerDialog(
                       addbirthday.this,
                       android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                       mDateSetListener,
                       year,month,day);
               //final Date mainDate=cal.getTime();
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();
           }
       });
       mDateSetListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               month = month + 1;
               Log.d("main", "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);

               String date = month + "/" + dayOfMonth + "/" + year;
               String tmpDate= year + "-" + month + "-" + dayOfMonth;


               SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
              // Date convertedDate = new Date();
               try {
                   maindate = dateFormat.parse(date);
               } catch (ParseException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }


               mDisplayDate.setText(date);

           }
       };
         final Migration FROM_1_TO_3 = new Migration(1, 3) {
            @Override
            public void migrate(final SupportSQLiteDatabase database) {
                database.execSQL("DELETE FROM new");
            }
        };

       final AppDatabse db= Room.databaseBuilder(getApplicationContext(),AppDatabse.class,"birthday").allowMainThreadQueries().build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 5/8/2018 save to db
                Log.d("myTag ",mDisplayDate.getText().toString() +"-------------------" + maindate.toString());

                db.birthdayDAO().nukeTable();
                db.birthdayDAO().instetall(new birthday(firstname.getText().toString(),maindate ,comment.getText().toString()));
                startActivity(new Intent(addbirthday.this,BirthdayActivity.class));
            }
        });
    }

}






