package com.example.u3175008.capture_faster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by u3175008 on 22/03/2018.
 */

public class List_Viewhelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "events";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_IMAGE_RESOURCE = "image_resource";
    public static final String COLUMN_DATE = "date";

    public List_Viewhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" +
                COLUMN_ID + " integer primary key, " +
                COLUMN_TITLE + " text, " +
                COLUMN_IMAGE_RESOURCE + " integer, " +
                COLUMN_DATE + " text)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);


    }

    public ArrayList<Business_Card> getAllEvents() {
        ArrayList<Business_Card> eventList = new ArrayList<Business_Card>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            Business_Card BC = new Business_Card(
                    res.getString(res.getColumnIndex(COLUMN_TITLE)),
                    res.getInt(res.getColumnIndex(COLUMN_IMAGE_RESOURCE)),
                    new Date(res.getString(res.getColumnIndex(COLUMN_DATE)) ));
            eventList.add(BC);
            res.moveToNext();
        }
        return eventList;
    }

    public boolean insertEvent(Business_Card BC) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, BC.getTitle());
        contentValues.put(COLUMN_IMAGE_RESOURCE, BC.getImageResource());
        contentValues.put(COLUMN_DATE, BC.getDateString());
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public Integer deleteEvent(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ? ", new String[]{id});
    }

    public boolean updateEvent(String id, Business_Card event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, event.getTitle());
        contentValues.put(COLUMN_IMAGE_RESOURCE, event.getImageResource());
        contentValues.put(COLUMN_DATE, event.getDateString());
        db.update(TABLE_NAME, contentValues, "id = ? ", new String[]{id});
        return true;
    }

}
