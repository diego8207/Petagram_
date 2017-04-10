package com.diegovelez.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegovelez.petagram.R;
import com.diegovelez.petagram.adapter.MascotaAdaptador;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 10/04/2017.
 */

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvListaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //asociamos o inflamos un layout a un actity class
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;


    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Ronny", "23", R.drawable.mascota1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Docky", "15", R.drawable.mascota2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ami", "12", R.drawable.mascota3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bella", "18", R.drawable.mascota4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Luli", "26", R.drawable.mascota5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvListaMascotas.setAdapter(adaptador);
    }






}
