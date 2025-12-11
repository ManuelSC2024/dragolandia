package com.example.Modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Monstruos")
public class Monstruo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida;
    private String tipo;
    private int fuerza;

    // Añadir la lista de tipos al mostruo
    // Añadir la lista de tipos al mostruo
    // Añadir la lista de tipos al mostruo

    public Monstruo() {
    }

    public Monstruo(String nombre, int vida, String tipo, int fuerza) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipo = tipo;
        this.fuerza = fuerza;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public String toString() {
        return "Monstruo [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", tipo=" + tipo + ", fuerza=" + fuerza
                + "]";
    }

    public void atacar(Mago mago) {
        int vidaRestante = mago.getVida() - this.fuerza;
        if (vidaRestante > 0) {
            mago.setVida(vidaRestante);
        } else
            mago.setVida(0);
        System.out.println(
                "El monstruo quito " + this.getFuerza() + " puntos de vida al mago: " + mago.getNombre());
    }
}
