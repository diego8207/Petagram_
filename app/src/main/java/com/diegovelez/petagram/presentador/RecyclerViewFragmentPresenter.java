package com.diegovelez.petagram.presentador;

import android.content.Context;
import android.widget.Toast;

import com.diegovelez.petagram.db.ContructorMascotas;
import com.diegovelez.petagram.fragment.iRecyclerViewFragmentView;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 11/04/2017.
 */

public class RecyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter {

    private iRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ContructorMascotas contructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(com.diegovelez.petagram.fragment.iRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        contructorMascotas = new ContructorMascotas(context);
        mascotas = contructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

}
