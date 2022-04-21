package com.example.androkado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androkado.bo.Article;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Article> myDataSet;
    private Context activity;

    public MyAdapter(ArrayList<Article> myDataSet, Context activity) {
        this.myDataSet = myDataSet;
        this.activity = activity;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_articles, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        String data = myDataSet.get(position).getNom();
        holder.tv_nomArticle.setText(data);
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tv_nomArticle;

        public ViewHolder(View itemView){
            super(itemView);
            tv_nomArticle = itemView.findViewById(R.id.tv_nom_article);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(activity, myDataSet.get(position).getNom(), Toast.LENGTH_SHORT).show();
        }
    }
}
