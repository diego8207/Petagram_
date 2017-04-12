package com.diegovelez.petagram.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegovelez.petagram.R;
import com.diegovelez.petagram.adapter.MascotaAdaptador;
import com.diegovelez.petagram.adapter.MascotaPerfilAdaptador;
import com.diegovelez.petagram.db.ContructorMascotas;
import com.diegovelez.petagram.pojo.Mascota;
import com.diegovelez.petagram.presentador.RecyclerViewFragmentPresenter;
import com.diegovelez.petagram.presentador.iRecyclerViewFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment{

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvListaMascotas;
    private CircularImageView circularImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);
        circularImageView = (CircularImageView) v.findViewById(R.id.cimgPet);
        circularImageView.setBorderWidth(10);
        // Add Shadow with default param
        circularImageView.addShadow();
        // or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.BLUE);


        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvListaMascotas.setLayoutManager(glm);

        inicializarListaMascotaPerfil();
        inicializarAdaptador();

        return v;
    }


    public void inicializarListaMascotaPerfil(){
        mascotas = new ArrayList<Mascota>();

       mascotas.add(new Mascota("Ronny", 3, R.drawable.mascota1_1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", 5, R.drawable.mascota1_2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", 11, R.drawable.mascota1_3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", 12, R.drawable.mascota1_4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", 16, R.drawable.mascota1_5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", 21, R.drawable.mascota1_6, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
    }

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas);
        rvListaMascotas.setAdapter(adaptador);
    }

}
