package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        article = new Article("Pain au chocolat", 1, "Une viennoiserie au beurre et au chocolat", 3, "http://AndroKado/pain_au_chocolat", false);
        TextView nomProduit = findViewById(R.id.nom_produit);
        nomProduit.setText(article.getNom());
        TextView prix = findViewById(R.id.prix_produit);
        prix.setText(String.format("%s €", String.valueOf(article.getPrix())));
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(article.getNote());
        TextView description = findViewById(R.id.description_produit);
        description.setText(article.getDescription());

    }


    public void onClickDisplayURL(View view) {

        Toast.makeText(this, article.getUrl(), Toast.LENGTH_SHORT).show();
    }

    public void onClickBuyItem(View view) {
        article.setAchete(!article.isAchete());
    }
}