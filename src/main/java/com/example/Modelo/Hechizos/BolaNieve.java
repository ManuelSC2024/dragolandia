package com.example.Modelo.Hechizos;

import com.example.Modelo.Hechizo;
import com.example.Modelo.Monstruo;

import jakarta.persistence.Entity;

@Entity
public class BolaNieve extends Hechizo {

    public BolaNieve() {
        this.nombre = "Bola de nieve";
    }

    @Override
    public void efecto(Monstruo monstruo) {
        monstruo.setVida(0);
    }



}
