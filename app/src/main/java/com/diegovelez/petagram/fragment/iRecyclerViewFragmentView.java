package com.diegovelez.petagram.fragment;

import com.diegovelez.petagram.adapter.MascotaAdaptador;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 11/04/2017.
 */

public interface iRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
