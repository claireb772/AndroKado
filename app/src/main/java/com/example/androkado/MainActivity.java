package com.example.androkado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.androkado.bo.Article;
import com.example.androkado.dal.ArticleDAO;

public class MainActivity extends AppCompatActivity {
    public Article article;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit: {
                Intent intent = new Intent(this,FormActivity.class);
                intent.putExtra("articleAmodifier", article);
                startActivity(intent);
                break;
            }
            case R.id.action_send: {
                Toast.makeText(this, "Partager", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        article = intent.getParcelableExtra("article");



        Toolbar toolbarDetail = findViewById(R.id.toolbard_detail);
        setSupportActionBar(toolbarDetail);

    }

    @Override
    protected void onResume() {
        super.onResume();

        ArticleDAO dao = new ArticleDAO(this);
        article = dao.selectById(article.getId());

        TextView nomProduit = findViewById(R.id.nom_produit);
        TextView prix = findViewById(R.id.prix_produit);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView description = findViewById(R.id.description_produit);
        ToggleButton tbAchete = findViewById(R.id.toggleButton_achete);

        nomProduit.setText(article.getNom());
        prix.setText(String.format("%s €", article.getPrix()));
        ratingBar.setRating(article.getNote());
        description.setText(article.getDescription());
        tbAchete.setChecked(article.isAchete());


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