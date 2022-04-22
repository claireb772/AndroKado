package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.androkado.adapter.ArticleAdapter;
import com.example.androkado.bo.Article;

import java.util.ArrayList;

public class ListeArticlesActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                Toast.makeText(this, "Ajouter", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.action_configuration: {
                Toast.makeText(this, "Configurer", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);
        Log.i("CLAIRE", "je suis dans le liste article");
        RecyclerView rv_articles = findViewById(R.id.rv_articles);
        rv_articles.setHasFixedSize(true);

        RecyclerView.LayoutManager myLayout = new LinearLayoutManager(this);
        rv_articles.setLayoutManager(myLayout);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article("Croissant",0.8f,"une viennoiserie",4,"AndroKado/croissant.com", false ));
        articles.add(new Article("Pain au raisin",1.2f,"une viennoiserie avec des raisins et de la crème pâtissière",3,"AndroKado/croissant.com", false ));
        articles.add(new Article("Babka",1.1f,"une brioche au chocolat",4,"AndroKado/croissant.com", false ));


        ArticleAdapter adapter = new ArticleAdapter(articles, this );
        rv_articles.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbard);
        setSupportActionBar(toolbar);

    }
}