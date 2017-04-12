package com.diegovelez.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diegovelez.petagram.R;
import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 10/04/2017.
 */

public class MascotaPerfilAdaptador extends  RecyclerView.Adapter<MascotaPerfilAdaptador.mascotaPerfilViewHolder>{

    ArrayList<Mascota> mascotas;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public mascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_perfil, parent, false);
        return new mascotaPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(mascotaPerfilViewHolder mascotaperfilviewholder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaperfilviewholder.imgFoto.setImageResource(mascota.getFoto());
        mascotaperfilviewholder.imgCantRaiting.setImageResource(mascota.getImgCantRaiting());
        mascotaperfilviewholder.tvCantRaiting.setText(String.valueOf(mascota.getCantLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class mascotaPerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageView imgCantRaiting;
        private TextView tvCantRaiting;


        public mascotaPerfilViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgCantRaiting  = (ImageView) itemView.findViewById(R.id.imgCantLikes);
            tvCantRaiting   = (TextView) itemView.findViewById(R.id.tvCantLikes);
        }



    }

}
