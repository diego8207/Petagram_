package com.diegovelez.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AcercaActivity extends AppCompatActivity {
    private TextView txtBiografia;
    private String Bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        txtBiografia = (TextView) findViewById(R.id.txtBiografia);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitle(R.string.app_name);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bio = "Ingeniero de sistemas \n" +
                "Universidad del Tolima - Colombia \n" +
                "Soy desarrolador de software en crecimiento \n" +
                "Me gusta mucho la innovación \n" +
                "Para poderla implementar en soluciones \n" +
                "que le sirvan al entorno en el que me encuentre.";


        txtBiografia.setText(Bio);
        txtBiografia.setTextSize(15);


    }
}
