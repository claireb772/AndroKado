package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.androkado.bo.Article;
import com.example.androkado.dal.AppDatabase;
import com.example.androkado.dal.ArticleDAO;
import com.example.androkado.dal.Connexion;

public class FormActivity extends AppCompatActivity {
    private EditText prixArticle;
    private Article articleRecuperer;
    private EditText nomArticle;
    private EditText descriptionArticle;
    private RatingBar rb;
    private EditText urlArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent intent = getIntent();
        articleRecuperer = intent.getParcelableExtra("articleAmodifier");

        nomArticle = findViewById(R.id.ed_form_nomArticle);
        prixArticle = findViewById(R.id.ed_form_prixArticle);
        descriptionArticle = findViewById(R.id.ed_form_description);
        rb = findViewById(R.id.rb_form_note);
        urlArticle = findViewById(R.id.ed_form_url);

        if(articleRecuperer != null){
            nomArticle.setText(articleRecuperer.getNom());
            prixArticle.setText(String.valueOf(articleRecuperer.getPrix()));
            descriptionArticle.setText(articleRecuperer.getDescription());
            rb.setRating(articleRecuperer.getNote());
            urlArticle.setText(articleRecuperer.getUrl());

        } else {
            SharedPreferences sp = getSharedPreferences("pref", MODE_PRIVATE);
            String prixDefaut = sp.getString("prixDefaut", "");

            prixArticle = findViewById(R.id.ed_form_prixArticle);
            prixArticle.setText(prixDefaut);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void SaveArticle(View view) {

        Article article = new Article();
        article.setNom(nomArticle.getText().toString());
        article.setPrix(Float.parseFloat(prixArticle.getText().toString()));
        article.setDescription(descriptionArticle.getText().toString());
        article.setNote(rb.getRating());
        article.setUrl(urlArticle.getText().toString());

        AppDatabase db = Connexion.getConnection(this);
        ArticleDAO dao = db.getArticleDAO();

        if(articleRecuperer != null) {
            article.setId(articleRecuperer.getId());
            dao.update(article);

        } else {

        dao.insert(article);


        }
        finish();

        //recupere les données


    }
}