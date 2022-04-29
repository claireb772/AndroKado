package com.example.androkado.dal;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androkado.bo.Article;
import com.example.androkado.contract.ArticleContract;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ArticleDAO {

    @Query("SELECT * FROM articles WHERE id =:id")
    Article selectById(int id);

    @Query("SELECT * FROM articles order by (:triActif)")
    List<Article> selectAllSorted(boolean triActif);

    @Query("SELECT * FROM articles")
    List<Article> selectAll();

    @Insert
    void insert(Article... articles);

    @Update
    void update(Article article);

    @Delete
    void delete(Article article);


}
