package com.shenkar.battl.shenkar_android;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.util.Date;



@Entity
public class birthday {


    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo(name = "firstname")
    private String firstname;
    @ColumnInfo(name = "birthday")
    private Date birthday;
    @ColumnInfo(name = "comment")
    private String comment;

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    public birthday(String firstname, Date birthday, String comment) {
        this.firstname = firstname;
        this.birthday = birthday;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



}
