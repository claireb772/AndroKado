package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androkado.bo.Contact;

public class ContactActivity extends AppCompatActivity {

    private TextView nomContact;
    private TextView numTel;
    private Contact contactArecup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

//        Intent intent = getIntent();
//        contactArecup = intent.getParcelableExtra("contacts");
//
//        nomContact = findViewById(R.id.tv_contactNom);
//        nomContact.setText(contactArecup.getNomAmis());
//        numTel = findViewById(R.id.tv_contactNumeroTel);
//        numTel.setText(contactArecup.getNumberTel());


    }
}