package com.shenkar.battl.shenkar_android;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {birthday.class},version = 1)
public abstract class AppDatabse extends RoomDatabase {
    public abstract birthdayDAO birthdayDAO();
}
