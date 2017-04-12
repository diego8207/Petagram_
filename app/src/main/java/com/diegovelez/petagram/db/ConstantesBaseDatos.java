package com.diegovelez.petagram.db;

/**
 * Created by Diego Velez on 11/04/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATA_BASE_NAME = "mascotas";
    public static final int DATA_BASE_VERSION = 1;

    public static final String TABLE_MASCOTAS                   = "mascotas";
    public static final String TABLE_MASCOTAS_ID                = "id";
    public static final String TABLE_MASCOTAS_NOMBRE            = "nombre";
    public static final String TABLE_MASCOTAS_CANT_LIKES        = "cantLikes";
    public static final String TABLE_MASCOTAS_FOTO              = "foto";
    public static final String TABLE_MASCOTAS_IMG_ME_GUSTA      = "imgMegusta";
    public static final String TABLE_MASCOTAS_IMG_CANT_RAITING  = "imgCantRaiting";

    public static final String TABLE_LIKES_MASCOTA = "mascota_likes";

    public static final String TABLE_LIKES_MASCOTA_ID = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "numero_likes";
}
