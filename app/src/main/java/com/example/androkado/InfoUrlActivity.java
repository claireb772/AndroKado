package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androkado.bo.Article;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("article");
        TextView tv_urlArticle = findViewById(R.id.tv_infoUrl_urlArticle);
//        tv_urlArticle.setText(article.getUrl());
    }
}