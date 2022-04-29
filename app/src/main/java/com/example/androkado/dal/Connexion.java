package com.example.androkado.dal;

import android.content.Context;

import androidx.room.Room;


public class Connexion {

    public static AppDatabase getConnection(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "androkado.db").build();
    }
}
