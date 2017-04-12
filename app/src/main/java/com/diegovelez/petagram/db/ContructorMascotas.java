package com.diegovelez.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.diegovelez.petagram.R;
import com.diegovelez.petagram.pojo.Mascota;

import java.net.PortUnreachableException;
import java.util.ArrayList;

/**
 * Created by Diego Velez on 11/04/2017.
 */

public class ContructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ContructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        //insertarCincoMascotas(db); //Solo la ejecutamos una sola vez para agregar las mascotas a la SQLite
        return db.obtenerTodosLasMascotas();

    }

    public ArrayList<Mascota> obtenerDatosFavoritos(){

        BaseDatos db = new BaseDatos(context);
   /*     ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Luli", 26, R.drawable.mascota5, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ronny", 23, R.drawable.mascota1, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Bella", 18, R.drawable.mascota4, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Docky", 15, R.drawable.mascota2, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
        mascotas.add(new Mascota("Ami", 12, R.drawable.mascota3, R.drawable.hueso_del_perro_50, R.drawable.hueso_del_perro_48));
*/
        return db.obtenerTodosLasMascotasOrdenadas();
  //      return  mascotas;

    }


    public void insertarCincoMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Ronny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_ME_GUSTA, R.drawable.hueso_del_perro_50);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_CANT_RAITING, R.drawable.hueso_del_perro_48);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Docky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_ME_GUSTA, R.drawable.hueso_del_perro_50);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_CANT_RAITING, R.drawable.hueso_del_perro_48);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Ami");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_ME_GUSTA, R.drawable.hueso_del_perro_50);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_CANT_RAITING, R.drawable.hueso_del_perro_48);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Bella");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_ME_GUSTA, R.drawable.hueso_del_perro_50);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_CANT_RAITING, R.drawable.hueso_del_perro_48);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Luli");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota5);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_ME_GUSTA, R.drawable.hueso_del_perro_50);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_CANT_RAITING, R.drawable.hueso_del_perro_48);
        db.insertarMascota(contentValues);

    }


    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }




}
