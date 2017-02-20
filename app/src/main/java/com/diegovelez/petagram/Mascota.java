package com.diegovelez.petagram;

/**
 * Created by Diego Velez on 19/02/2017.
 */

public class Mascota {
    private String nombre;
    private String cantLikes;
    private int foto;
    private int imgMegusta;
    private int imgCantRaiting;

    public Mascota(String nombre, String cantLikes, int foto, int imgMegusta, int imgCantRaiting) {
        this.nombre = nombre;
        this.cantLikes = cantLikes;
        this.foto = foto;
        this.imgMegusta = imgMegusta;
        this.imgCantRaiting = imgCantRaiting;
    }

    public int getImgMegusta() {
        return imgMegusta;
    }

    public void setImgMegusta(int imgMegusta) {
        this.imgMegusta = imgMegusta;
    }

    public int getImgCantRaiting() {
        return imgCantRaiting;
    }

    public void setImgCantRaiting(int imgCantRaiting) {
        this.imgCantRaiting = imgCantRaiting;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantLikes() {
        return cantLikes;
    }

    public void setCantLikes(String cantLikes) {
        this.cantLikes = cantLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
