package com.diegovelez.petagram.pojo;

/**
 * Created by Diego Velez on 19/02/2017.
 */

public class Mascota {

    private int id;
    private String nombre;
    private int cantLikes;
    private int foto;
    private int imgMegusta;
    private int imgCantRaiting;

    public Mascota(String nombre, int cantLikes, int foto, int imgMegusta, int imgCantRaiting) {
        this.nombre = nombre;
        this.cantLikes = cantLikes;
        this.foto = foto;
        this.imgMegusta = imgMegusta;
        this.imgCantRaiting = imgCantRaiting;
    }

    public Mascota() {

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

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantLikes() {
        return cantLikes;
    }

    public void setCantLikes(int cantLikes) {
        this.cantLikes = cantLikes;
    }
}
