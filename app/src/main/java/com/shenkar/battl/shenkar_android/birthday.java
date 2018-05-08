package com.shenkar.battl.shenkar_android;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class birthday {


    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo(name = "firstname")
    private String firstname;
    @ColumnInfo(name = "birthday")
    private String birthday;
    @ColumnInfo(name = "comment")
    private String comment;

    public birthday(String firstname, String birthday, String comment) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



}
