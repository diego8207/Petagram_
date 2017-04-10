package com.diegovelez.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegovelez.petagram.R;
import com.diegovelez.petagram.adapter.MascotaPerfilAdaptador;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvListaMascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);

       // LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvListaMascotas.setLayoutManager(glm);

        inicializarListaMascotaPerfil();
        inicializarAdaptador();

        return v;
    }


    public void inicializarListaMascotaPerfil(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Ronny", "03", R.drawable.mascota1_1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", "05", R.drawable.mascota1_2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", "02", R.drawable.mascota1_3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", "08", R.drawable.mascota1_4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", "16", R.drawable.mascota1_5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", "21", R.drawable.mascota1_6, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
    }

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas);
        rvListaMascotas.setAdapter(adaptador);
    }

}
