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
import com.diegovelez.petagram.presentador.RecyclerViewFragmentPresenter;
import com.diegovelez.petagram.presentador.iRecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 10/04/2017.
 */

public class RecyclerViewFragment extends Fragment implements iRecyclerViewFragmentView {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvListaMascotas;
    private iRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //asociamos o inflamos un layout a un actity class
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm);
    }


    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }


    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        rvListaMascotas.setAdapter(adaptador);
    }
}
