package com.diegovelez.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.diegovelez.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 11/04/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATA_BASE_NAME, null, ConstantesBaseDatos.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE           + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_CANT_LIKES       + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO             + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_IMG_ME_GUSTA     + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_IMG_CANT_RAITING + " INTEGER" +
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") "+
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " +  ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " +  ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(3));
            mascotaActual.setImgMegusta(registros.getInt(4));
            mascotaActual.setImgCantRaiting(registros.getInt(5));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setCantLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setCantLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerTodosLasMascotasOrdenadas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTAS_ID +
                ", " + ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE +
                ", " + ConstantesBaseDatos.TABLE_MASCOTAS_FOTO +
                ", " + ConstantesBaseDatos.TABLE_MASCOTAS_IMG_ME_GUSTA +
                ", " + ConstantesBaseDatos.TABLE_MASCOTAS_IMG_CANT_RAITING +
                " FROM  "+ ConstantesBaseDatos.TABLE_MASCOTAS + " INNER JOIN " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " ON " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + ConstantesBaseDatos.TABLE_MASCOTAS_ID +
                " ORDER BY " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(3));
            mascotaActual.setImgMegusta(registros.getInt(4));
            mascotaActual.setImgCantRaiting(registros.getInt(5));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setCantLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setCantLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " = " + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
          likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
