package com.example.tvd.sqlcipher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase.loadLibs(this);
        Database database = new Database(this);
        database.open();
    }
}
