package com.harish.xdev.parking.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.harish.xdev.parking.Model.AddTicket;
import com.harish.xdev.parking.Model.Login;

import java.util.ArrayList;

public class DBAddTicket {
    public static final String TABLE_ADDTICKET = "tblAddTicket";
    //public static final String KEY_DATE = "etdate";
    public static final String KEY_VEHICLE_NUMBER = "vnumber";
    public static final String KEY_VEHICLE_BRAND = "vbrand";
    public static final String KEY_LANE = "lane";
    public static final String KEY_POSITION= "pos";
    public static final String KEY_TIME = "time";
    public static final String KEY_COLOR = "color";
    public static final String KEY_PAYMETHOD = "pmethod";
    private Context context;

    private DBHelper dbHelper;
    public DBAddTicket(Context context) {
        this.context = context;
    }

    public void insertTicket(AddTicket ad) {
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_VEHICLE_NUMBER, ad.getVnumber());
      //  contentValues.put(KEY_DATE, ad.getEtdate());
        contentValues.put(KEY_VEHICLE_BRAND, ad.getVbrand());
        contentValues.put(KEY_COLOR, ad.getVcolor());
        contentValues.put(KEY_POSITION, ad.getPosition());
        contentValues.put(KEY_LANE, ad.getLane());
        contentValues.put(KEY_PAYMETHOD, ad.getPaymethod());
        contentValues.put(KEY_TIME, ad.getTime());


        database.insert(TABLE_ADDTICKET, null, contentValues);
        Log.d("DB",ad.getVnumber() + " : " + ad.getVbrand());
        database.close();
    }

    public  int getTotalCount(){
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(TABLE_ADDTICKET,
                null,
                null,
                null,
                null,
                null,
                null);
        int count =cursor.getCount();
        return count;
    }

    public ArrayList<AddTicket> getAllTickets() {
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(TABLE_ADDTICKET,
                null,
                null,
                null,
                null,
                null,
                null);

        ArrayList<AddTicket> TicketArrayList = new ArrayList<>();

        if(cursor !=null) {
            if(cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    AddTicket ad= new AddTicket();
                   // ad.setId(Integer.parseInt(cursor.getString(0)));
                    ad.setVnumber(cursor.getString(0));
                            ad.setVbrand(cursor.getString(1));
                            //ad.setEtdate(cursor.getString(2));
                            ad.setVcolor(cursor.getString(2));
                            ad.setPosition(cursor.getString(3));
                            ad.setLane(cursor.getString(4));
                            ad.setPaymethod(cursor.getString(5));
                            //ad.setTime(cursor.getString(7));
                            //ad.setEtdate(cursor.getString(7));
                    TicketArrayList.add(ad);
                    Log.d("DB",ad.getVnumber() + " : " + ad.getVbrand()+":"+cursor.getCount()+ " : " + ad.getLane()+ " : " + ad.getVcolor()+ " : " + ad.getPaymethod()+ " : " + ad.getPosition());}
            }
        }
        database.close();
        return TicketArrayList;
    }
}