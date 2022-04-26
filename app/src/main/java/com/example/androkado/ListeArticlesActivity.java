package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androkado.adapter.ArticleAdapter;
import com.example.androkado.bo.Article;
import com.example.androkado.dal.ArticleDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListeArticlesActivity extends AppCompatActivity {

    private RecyclerView rv_articles;
    private ArticleDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //on laisse les opérations qu'on execute qu'une seule fois
        setContentView(R.layout.activity_liste_articles);

        rv_articles = findViewById(R.id.rv_articles);

        rv_articles.setHasFixedSize(true);

        RecyclerView.LayoutManager myLayout = new LinearLayoutManager(this);
        rv_articles.setLayoutManager(myLayout);

        Toolbar toolbar = findViewById(R.id.toolbard);
        setSupportActionBar(toolbar);

        dao = new ArticleDAO((this));
        dao.insert(new Article("Croissant",0.8f,"une viennoiserie",4,"AndroKado/croissant.com", false ));
        dao.insert(new Article("Pain au raisin",1.2f,"une viennoiserie avec des raisins et de la crème pâtissière",3,"AndroKado/croissant.com", false ));
        dao.insert(new Article("Babka",1.1f,"une brioche au chocolat",4,"AndroKado/croissant.com", false ));

    }

    @Override
    protected void onResume() {
        super.onResume();


        //etape de tri
        //recuperer l'info tri ou non ?
        SharedPreferences sp = getSharedPreferences("pref", MODE_PRIVATE);
        Boolean triActif = sp.getBoolean("triActif", false);

        ArrayList<Article> articles = null;

        if(triActif) {
            articles = dao.getAll(true);
        } else {
            articles = dao.getAll(false);
        }

        ArticleAdapter adapter = new ArticleAdapter(articles, this );
        rv_articles.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                Intent intent = new Intent(this,FormActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.action_configuration: {
                Intent intent = new Intent(this,ConfigurationActivity.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}