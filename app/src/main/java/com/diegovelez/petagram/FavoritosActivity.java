package com.diegovelez.petagram;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.diegovelez.petagram.adapter.MascotaAdaptador;
import com.diegovelez.petagram.adapter.PageAdapter;
import com.diegovelez.petagram.fragment.FavoritosFragment;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotasFav;
    private SharedPreferences datos_compartidos; //es una prueba SharedPreferences
    private Toolbar miActionBar;
    private ViewPager viewPagerFav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        viewPagerFav = (ViewPager) findViewById(R.id.viewPagerFav);

        if (miActionBar != null){
            miActionBar.setLogo(R.drawable.star);
            miActionBar.setTitle("   Petagram Top 5");
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //metodo que permite agregar el FavoritosFragment en el viewPagerFav declarado
        //de esta manera asociamos un activity a Fragments dinamicamente
        setUpViewPager();


        //Ejemplo de como Recuperar datos de un SharePrefereces
       /* datos_compartidos = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String usuario = datos_compartidos.getString("usuario", "");
        String fecha = datos_compartidos.getString("fecha", "");

        Toast.makeText(this, "usuario: " + usuario + " Fecha: " + fecha, Toast.LENGTH_SHORT).show(); */
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FavoritosFragment());
        return  fragments;
    }

    private void setUpViewPager(){
        viewPagerFav.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
    }

}
