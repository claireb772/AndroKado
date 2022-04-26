package com.example.androkado.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androkado.ListeArticlesActivity;
import com.example.androkado.R;
import com.example.androkado.bo.Contact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{


        private ArrayList<Contact> myDataSet;
        private Context activity;

        public ContactAdapter(ArrayList<Contact> myDataSet, Context activity) {
            this.myDataSet = myDataSet;
            this.activity = activity;
        }

        @Override
        public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contact, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {
            Contact contact = myDataSet.get(position);
            holder.tv_contact_Nom.setText(contact.getNomAmis());
            holder.tv_contact_NumeroTel.setText(contact.getNumberTel());

        }

        @Override
        public int getItemCount() {
            return myDataSet.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView tv_contact_Nom;
            public TextView tv_contact_NumeroTel;

            public ViewHolder(View itemView){
                super(itemView);
                tv_contact_Nom = itemView.findViewById(R.id.tv_contactNom);
                tv_contact_NumeroTel = itemView.findViewById(R.id.tv_contactNumeroTel);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Contact contact = myDataSet.get(position);
                Intent intent = new Intent(activity, ListeArticlesActivity.class);
                intent.putExtra("contact", contact);
                activity.startActivity(intent);
            }
        }
    }

