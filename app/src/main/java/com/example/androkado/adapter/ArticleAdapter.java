package com.example.androkado.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androkado.MainActivity;
import com.example.androkado.R;
import com.example.androkado.bo.Article;

import java.util.ArrayList;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private ArrayList<Article> myDataSet;
    private Context activity;

    public ArticleAdapter(ArrayList<Article> myDataSet, Context activity) {
        this.myDataSet = myDataSet;
        this.activity = activity;
    }

    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lignes, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ViewHolder holder, int position) {
        Article article = myDataSet.get(position);

        holder.tv_nomarticle.setText(article.getNom());
        holder.rb_note_article.setRating(article.getNote());
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tv_nomarticle;
        public RatingBar rb_note_article;

        public ViewHolder(View itemView){
            super(itemView);
            tv_nomarticle = itemView.findViewById(R.id.tv_nom_article);
            rb_note_article = itemView.findViewById(R.id.cb_rating_bar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Article article = myDataSet.get(position);
            Intent intent = new Intent(activity, MainActivity.class);
            intent.putExtra("article", article);
            activity.startActivity(intent);
        }
    }
}
