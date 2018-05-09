package com.shenkar.battl.shenkar_android;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;
//to save date to db we have to convert it to long
public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}