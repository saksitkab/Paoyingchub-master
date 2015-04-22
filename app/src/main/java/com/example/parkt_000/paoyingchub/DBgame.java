package com.example.parkt_000.paoyingchub;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBgame extends SQLiteOpenHelper {

    private static final String name = "dbscores.sqlite3";
    private static final int version = 2;


    public DBgame(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE dbscore (" +
                "_id integer primary key autoincrement," +
                "name text not null," +             // name of user
                "score int default 0);";         // score
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS dbscore;";
        db.execSQL(sql);
        this.onCreate(db);
    }
}
