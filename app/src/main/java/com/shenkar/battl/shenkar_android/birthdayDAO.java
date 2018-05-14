package com.shenkar.battl.shenkar_android;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface birthdayDAO {

    @Query("SELECT * FROM birthday ORDER BY birthday.birthday DESC")
    List<birthday> getallbirthdays();

    @Insert
    void instetall(birthday... birthdays);

    @Query("DELETE FROM birthday")
    public void nukeTable();


}
