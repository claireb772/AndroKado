package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.androkado.bo.Article;
import com.example.androkado.dal.ArticleDAO;

public class FormActivity extends AppCompatActivity {
    private ArticleDAO dao;
    private Article article;
    private EditText prixArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getSharedPreferences("pref", MODE_PRIVATE);
        String prixDefaut = sp.getString("prixDefaut", "0");

        if(prixDefaut != null){
            prixArticle = findViewById(R.id.ed_form_prixArticle);
            prixArticle.setText(prixDefaut);
        }

    }

    public void SaveArticle(View view) {

        dao = new ArticleDAO((this));

        EditText nomArticle = findViewById(R.id.ed_form_nomArticle);
        prixArticle = findViewById(R.id.ed_form_prixArticle);
        EditText descriptionArticle = findViewById(R.id.ed_form_description);
        RatingBar rb = findViewById(R.id.rb_form_note);
        EditText urlArticle = findViewById(R.id.ed_form_url);

        dao.insert(new Article(String.valueOf(nomArticle.getText()), Float.parseFloat(String.valueOf(prixArticle.getText())), String.valueOf(descriptionArticle.getText()), Float.parseFloat(String.valueOf(rb.getRating())), String.valueOf(urlArticle.getText()), false));

        finish();

        //recupere les données


    }
}