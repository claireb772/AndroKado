package com.example.androkado.dal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androkado.bo.Article;

@Database(entities = {Article.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDAO getArticleDAO();
}
