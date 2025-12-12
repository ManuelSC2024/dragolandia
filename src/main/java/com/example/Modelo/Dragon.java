
package com.example.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dragones")
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nombre;
    int intensidadFuego;
    int resistencia;

    public Dragon() {
    }

    public Dragon(String nombre, int intensidadFuego, int resistencia) {
        this.nombre = nombre;
        this.intensidadFuego = intensidadFuego;
        this.resistencia = resistencia;
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

    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    public void setIntensidadFuego(int intensidadFuego) {
        this.intensidadFuego = intensidadFuego;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Dragon [\n id=" + id
                + ",\n nombre=" + nombre
                + ",\n intensidadFuego=" + intensidadFuego
                + ",\n resistencia=" + resistencia
                + "\n]";
    }

    /**
     * Este metodo calcula el daño que causa el dragon a un mostruo
     * @param monstruo Monstruo que recibe daño
     */
    public void exhalar(Monstruo monstruo) {
        int vidaRestante = monstruo.getVida() - this.getIntensidadFuego();
        if (vidaRestante > 0) {
            monstruo.setVida(vidaRestante);
        } else
            monstruo.setVida(0);
        System.out.println(
                "El dragón quito " + this.getIntensidadFuego() + " puntos de vida al monstruo: " + monstruo.getNombre());
    }
}
