package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.androkado.bo.Article;

public class MainActivity extends AppCompatActivity {
    public Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        article = new Article("Pain au chocolat", 1f, "Une viennoiserie au beurre et au chocolat", 3, "http://AndroKado/pain_au_chocolat", false);
//        TextView nomProduit = findViewById(R.id.nom_produit);
//        nomProduit.setText(article.getNom());
//        TextView prix = findViewById(R.id.prix_produit);
//        prix.setText(String.format("%s €", article.getPrix()));
//        RatingBar ratingBar = findViewById(R.id.ratingBar);
//        ratingBar.setRating(article.getNote());
//        TextView description = findViewById(R.id.description_produit);
//        description.setText(article.getDescription());

    }


    public void onClickDisplayURL(View view) {
        Intent intent = new Intent(this,InfoUrlActivity.class);
        intent.putExtra("article", article);
        startActivity(intent);

    }

    public void onClickBuyItem(View view) {
      //  article.setAchete(!article.isAchete());
        ToggleButton toggleButton = (ToggleButton) view;
        article.setAchete(toggleButton.isChecked());
        Log.i("INFO", String.format("L'article acheté : %s", article.isAchete()));
    }
}