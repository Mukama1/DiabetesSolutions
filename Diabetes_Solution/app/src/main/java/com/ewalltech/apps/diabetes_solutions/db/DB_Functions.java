package com.ewalltech.apps.diabetes_solutions.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB_Functions {
    private static Context context;
    public DB_Functions(Context context){
        this.context = context;
    }

    public static Boolean sqliteTableChecker(String query){

        SQLiteDatabase db = DBHelper.getHelper(context).getReadableDatabase();
        Cursor cursor = null;
        Boolean status=Boolean.FALSE;
        try {
            cursor = db.rawQuery(query, null);
            if (cursor.getCount()>=1) {
                status=Boolean.TRUE;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;

    }
}
