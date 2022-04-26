package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConfigurationActivity extends AppCompatActivity {

    private TextView ed_prixParDefaut;
    private SwitchCompat sw_triActif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        ed_prixParDefaut = findViewById(R.id.ed_prix_defaut);
        sw_triActif = findViewById(R.id.switch_triActif);

    }

    public void sauvegarderSharedPreferences(View view) {
        //recuperer valeur

        String prixDefaut = ed_prixParDefaut.getText().toString();
        Boolean triActif = sw_triActif.isChecked();

        //Acces à l'éditor de sharedPreferences
        SharedPreferences sp = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("triActif", triActif);
        edit.putString("prixDefaut",prixDefaut);

        edit.apply();
        Toast.makeText(this, "Configuration sauvegardée", Toast.LENGTH_SHORT).show();
        //equivalent du bouton return, renvoi vers listArticleActivity
        finish();
    }
}