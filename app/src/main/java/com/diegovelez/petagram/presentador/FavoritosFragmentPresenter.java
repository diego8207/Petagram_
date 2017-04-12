package com.diegovelez.petagram.presentador;

import android.content.Context;

import com.diegovelez.petagram.db.ContructorMascotas;
import com.diegovelez.petagram.fragment.iRecyclerViewFragmentView;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 11/04/2017.
 */

public class FavoritosFragmentPresenter implements iFavoritosFragmentPresenter {

    private iRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ContructorMascotas contructorMascotas;
    private ArrayList<Mascota> mascotasFavoritas;

    public FavoritosFragmentPresenter(com.diegovelez.petagram.fragment.iRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatosFavoritos();
    }

    @Override
    public void obtenerMascotasBaseDatosFavoritos() {
        contructorMascotas = new ContructorMascotas(context);
        mascotasFavoritas = contructorMascotas.obtenerDatosFavoritos();
        mostrarMascotasFavRv();
    }

    @Override
    public void mostrarMascotasFavRv() {
        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(mascotasFavoritas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
