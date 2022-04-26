package com.example.androkado.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androkado.contract.ArticleContract;

public class BddHelper extends SQLiteOpenHelper {

    private static final String BDD_NAME = "androkado.db";
    private static final int VERSION = 1;

    public BddHelper(Context context){
        super(context, BDD_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ArticleContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ArticleContract.DROP_TABLE);
        onCreate(db);
    }

}
