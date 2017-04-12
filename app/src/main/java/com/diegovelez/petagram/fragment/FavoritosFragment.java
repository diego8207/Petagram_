package com.diegovelez.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegovelez.petagram.R;
import com.diegovelez.petagram.adapter.MascotaAdaptador;
import com.diegovelez.petagram.pojo.Mascota;
import com.diegovelez.petagram.presentador.FavoritosFragmentPresenter;
import com.diegovelez.petagram.presentador.iFavoritosFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment implements iRecyclerViewFragmentView{

    private ArrayList<Mascota> mascotasFav;
    private RecyclerView rvMascotasFav;
    private ArrayList<Mascota> mascotas;
    private iFavoritosFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favoritos, container, false);
        rvMascotasFav = (RecyclerView) v.findViewById(R.id.rvMascotasFavo);

        presenter = new FavoritosFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFav.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        rvMascotasFav.setAdapter(adaptador);
    }


}
