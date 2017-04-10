package com.diegovelez.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.diegovelez.petagram.adapter.MascotaAdaptador;
import com.diegovelez.petagram.adapter.PageAdapter;
import com.diegovelez.petagram.fragment.PerfilFragment;
import com.diegovelez.petagram.fragment.RecyclerViewFragment;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null){
            toolbar.setLogo(R.drawable.huella);
            toolbar.setTitle(R.string.Petagram);
            setSupportActionBar(toolbar);
        }
    }

    //añadimos los fragmento al arreglo de Fragments
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    //configuramos el viewPager
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_pets);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favoritos:
                Intent in1 = new Intent(this, FavoritosActivity.class);
                startActivity(in1);
                break;
            case R.id.mContacto:
                Intent in2 = new Intent(this, ContactoActivity.class);
                startActivity(in2);
                break;
            case R.id.mAcercaDe:
                Intent in3 = new Intent(this, AcercaActivity.class);
                startActivity(in3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
