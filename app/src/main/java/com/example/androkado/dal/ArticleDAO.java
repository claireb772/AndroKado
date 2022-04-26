package com.example.androkado.dal;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androkado.bo.Article;
import com.example.androkado.contract.ArticleContract;

import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    private SQLiteDatabase db;

    public ArticleDAO(Context context) {
        BddHelper helper = new BddHelper(context);
        db = helper.getWritableDatabase();
    }

    public Article getById(int id){
        Article article = null;

        Cursor cursor =
                db.query(ArticleContract.TABLE_NAME,
                        null,
                        ArticleContract.COL_ID + " =?",
                        new String[]{String.valueOf(id)},
                        null,null,null);

        if (cursor.moveToNext()){
            article = new Article();
            article.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ArticleContract.COL_ID)));
            article.setNom(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_NOM)));
            article.setPrix(cursor.getFloat(cursor.getColumnIndexOrThrow(ArticleContract.COL_PRIX)));
            article.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_DESCRIPTION)));
            article.setNote(cursor.getFloat(cursor.getColumnIndexOrThrow(ArticleContract.COL_NOTE)));
            article.setUrl(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_URL)));
            article.setAchete(cursor.getInt(cursor.getColumnIndexOrThrow(ArticleContract.COL_ISACHETE)) != 0);

        }

        cursor.close();
        return article;
    }

    @SuppressLint("Range")
    public ArrayList<Article> getAll(Boolean tri){



        Cursor cursor = null;

        ArrayList<Article> articles = new ArrayList<>();
        if(tri) {
            cursor =
                    db.query(ArticleContract.TABLE_NAME,
                            null, null, null, null, null, ArticleContract.COL_PRIX, null);
        } else {
            cursor =
                    db.query(ArticleContract.TABLE_NAME,
                            null, null, null, null, null, null, null);

        }

        while (cursor.moveToNext()){
            Article article = new Article();
            article.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ArticleContract.COL_ID)));
            article.setNom(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_NOM)));
            article.setPrix(cursor.getFloat(cursor.getColumnIndexOrThrow(ArticleContract.COL_PRIX)));
            article.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_DESCRIPTION)));
            article.setNote(cursor.getFloat(cursor.getColumnIndexOrThrow(ArticleContract.COL_NOTE)));
            article.setUrl(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_URL)));
            article.setAchete(cursor.getInt(cursor.getColumnIndexOrThrow(ArticleContract.COL_ISACHETE)) != 0);

            articles.add(article);
        }
        cursor.close();
        return articles;

    }

    public void insert(Article article) {
        ContentValues cv = new ContentValues();
        cv.put(ArticleContract.COL_NOM, article.getNom());
        cv.put(ArticleContract.COL_PRIX, article.getPrix());
        cv.put(ArticleContract.COL_DESCRIPTION, article.getDescription());
        cv.put(ArticleContract.COL_NOTE, article.getNote());
        cv.put(ArticleContract.COL_URL, article.getUrl());
        cv.put(ArticleContract.COL_ISACHETE, article.isAchete());
        db.insert(ArticleContract.TABLE_NAME,null,cv);

    }

    public void update(Article article) {
        ContentValues cv = new ContentValues();
        cv.put(ArticleContract.COL_NOM, article.getNom());
        cv.put(ArticleContract.COL_PRIX, article.getPrix());
        cv.put(ArticleContract.COL_DESCRIPTION, article.getDescription());
        cv.put(ArticleContract.COL_NOTE, article.getNote());
        cv.put(ArticleContract.COL_URL, article.getUrl());
        cv.put(ArticleContract.COL_ISACHETE, article.isAchete());

        db.update(ArticleContract.TABLE_NAME, cv,
                ArticleContract.COL_ID + " = ?",
                new String[]{String.valueOf(article.getId())});
    }

    public void delete(Article article){
        db.delete(ArticleContract.TABLE_NAME,
                ArticleContract.COL_ID + " = ?",
                new String[]{String.valueOf(article.getId())});
    }

}
