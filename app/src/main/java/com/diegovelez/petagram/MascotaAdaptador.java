package com.diegovelez.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 19/02/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public  MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.imgMegusta.setImageResource(mascota.getImgMegusta());
        mascotaViewHolder.imgCantRaiting.setImageResource(mascota.getImgCantRaiting());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvCantRaiting.setText(mascota.getCantLikes());

        mascotaViewHolder.imgMegusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Me Gusta a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override //Cantidad de elementos que contiene la lista
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageView imgMegusta;
        private TextView tvNombreMascota;
        private  TextView tvCantRaiting;
        private  ImageView imgCantRaiting;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgMegusta      = (ImageView) itemView.findViewById(R.id.imgMegusta);
            imgCantRaiting  = (ImageView) itemView.findViewById(R.id.imgCantRaiting);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvCantRaiting   = (TextView) itemView.findViewById(R.id.tvCantRaiting);
        }


    }

}
