package com.example.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Magos")
public class Mago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida;
    private int nivelMagia;

    public Mago() {
    }

    public Mago(String nombre, int vida, int nivelMagia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    @Override
    public String toString() {
        return "Mago [\nid=" + id
                + ",\n nombre=" + nombre
                + ",\n vida=" + vida
                + ",\n nivelMagia="+ nivelMagia
                + "\n]";
    }

    public void lanzarHechizo(Monstruo monstruo) {
        int vidaRestante = monstruo.getVida() - this.getNivelMagia();
        if (vidaRestante > 0) {
            monstruo.setVida(vidaRestante);
        } else
            monstruo.setVida(0);
        System.out.println(
                "El mago quito " + this.getNivelMagia() + " puntos de vida al monstruo: " + monstruo.getNombre());
    }

}
