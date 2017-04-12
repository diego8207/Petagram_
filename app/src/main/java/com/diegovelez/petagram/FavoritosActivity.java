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
            miActionBar.setLogo(R.drawable.huella);
            miActionBar.setTitle("   Petagram Favoritos");
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //metodo que permite agregar el FavoritosFragment en el viewPagerFav declarado
        //de esta manera asociamos un activity a Fragments dinamicamente
        setUpViewPager();


        /*

        */

        //Ejemplo de como Recuperar datos de un SharePrefereces
        datos_compartidos = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String usuario = datos_compartidos.getString("usuario", "");
        String fecha = datos_compartidos.getString("fecha", "");

        Toast.makeText(this, "usuario: " + usuario + " Fecha: " + fecha, Toast.LENGTH_SHORT).show();
    }

    public void inicializarListaMascotas(){
/*        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Luli", "26", R.drawable.mascota5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", "23", R.drawable.mascota1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bella", "18", R.drawable.mascota4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Docky", "15", R.drawable.mascota2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ami", "12", R.drawable.mascota3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));  */
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotasFav.setAdapter(adaptador);
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
