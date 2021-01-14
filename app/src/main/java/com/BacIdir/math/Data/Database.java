package com.BacIdir.math.Data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

import java.io.File;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Database";
    private static final int DATABASE_VERSION = 1;
    private static String DB_PATH = "";
    private static String Table = "Unit1";
    public static final String T[] = {"Unit1","Unit2","Unit3","Unit4","Unit5"};
    private static String Column1 = "exo";
    private static String Column3 = "mark";
    public SQLiteDatabase myDataBase;
    private Context mContext ;


    private static final String SQL_INSERT_ENTRIES =
            "CREATE TABLE math (exo int , solution TEXT)";




    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context ;
        DB_PATH =  context.getDatabasePath(DATABASE_NAME).toString();

        // Create new Database if it doesnt exist
        if(!checkDatabase()){this.getWritableDatabase();}


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // needs to be changed

            for (String i : T){
            String SQL_CREATE_ENTRIES =
                    "CREATE TABLE "+ i+"(" +Column1+ " INTEGER," +Column3+ " FLOAT(1,1) )";

            db.execSQL(SQL_CREATE_ENTRIES);

        }


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    private boolean checkDatabase() {
        File dbfile = new File(DB_PATH);
        if ( dbfile.exists()) return true;
        return false;
    }

    public void Connect()
            throws SQLException
    {
        myDataBase = SQLiteDatabase.openDatabase(
                DB_PATH, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    public void Disconect(){
        myDataBase.close();
    }

    public void InsertData (String Table,ContentValues values){
        myDataBase.insert(Table,null,values);

    }

    public int UpdateData (String Table,ContentValues values , int exo){

        return myDataBase.update(Table,values,"exo = "+ exo ,null);

    }

    public Cursor FetchData(String Table , String[] Columns){
        Cursor cursor = myDataBase.query(Table,Columns,null,null,null,null,null);
        return cursor ;
    }


}