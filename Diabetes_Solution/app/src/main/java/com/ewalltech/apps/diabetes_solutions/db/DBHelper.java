package com.ewalltech.apps.diabetes_solutions.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.util.Log;

import com.ewalltech.apps.diabetes_solutions.constants.Constants;

public class DBHelper extends SQLiteOpenHelper {

    private final Handler handler;
    private static DBHelper instance;
    public static synchronized DBHelper getHelper(Context context)
    {
        if (instance == null)
            instance = new DBHelper(context);
        return instance;
    }

    public DBHelper(Context context) {
        super(context, Constants.config.DB_NAME, null, Constants.config.DB_VERSION);
        handler = new Handler(context.getMainLooper());
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO : Creating tables
        db.execSQL(Create_Table.create.CREATE_DEVELOPERS);
        db.execSQL(Create_Table.create.CREATE_REPOSITORIES);
        Log.e("DATABASE OPERATION",Constants.config.TOTAL_TABLES+" Tables  created / open successfully");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: Updating table here
        db.execSQL("DROP TABLE IF EXISTS " + Constants.config.DEVELOPERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.config.REPOSITORY_TABLE);
        onCreate(db);
        Log.e("DATABASE OPERATION", Constants.config.TOTAL_TABLES+" Table created / open successfully");

    }
    private void runOnUiThread(Runnable r) {
        handler.post(r);
    }

    /**

    public  SQLiteDatabase getWritableDB(){
        SQLiteDatabase database = null;
        try {
            database = this.getWritableDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }

        return database;
    }
    public SQLiteDatabase getReadableDB(){
        SQLiteDatabase database = null;
        try {
            database = this.getReadableDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }

        return database;
    }
     **/
    /************** Insertion ends here **********************/
}