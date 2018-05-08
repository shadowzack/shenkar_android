package com.shenkar.battl.shenkar_android;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = {birthday.class},version = 3)
@TypeConverters({Converters.class})
public abstract class AppDatabse extends RoomDatabase {
    public abstract birthdayDAO birthdayDAO();
}


