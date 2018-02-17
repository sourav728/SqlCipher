package com.example.tvd.sqlcipher;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

import java.io.File;

import static com.example.tvd.sqlcipher.Constant.DATABASE_KEY;

/**
 * Created by TVD on 2/17/2018.
 */

public class Database {
    private MyHelper mh;
    private SQLiteDatabase sdb;
    private String databasepath = "";
    private String databasefolder = "database";
    private String database_name = "sqlcipher.db";

    public Database(Context context) {
        try {
            databasepath = filepath(databasefolder) + File.separator + database_name;
            mh = new MyHelper(context, databasepath, null, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void open() {
        sdb = mh.getWritableDatabase(DATABASE_KEY.toCharArray());
    }

    public void close() {
        sdb.close();
    }

    public class MyHelper extends SQLiteOpenHelper {

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table MRDETAILS(_id integer primary key, " +
                    "MRNAME TEXT, MRCODE TEXT, SUBDIVISION TEXT, MRID TEXT);");
            db.execSQL("Create table CONSUMER(_id integer primary key, " +
                    "CONSUMERNAME TEXT, CONSUMER_ADDRESS TEXT, STATE TEXT);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }

    public String AppFolderName() {
        return "Cipher";
    }

    public String filepath(String value) {
        File dir = new File(android.os.Environment.getExternalStorageDirectory(), AppFolderName() + File.separator + value);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String pathname = dir.toString();
        return pathname;
    }
}
