package com.example.Modelo.Hechizos;

import com.example.Modelo.Hechizo;
import com.example.Modelo.Monstruo;

public class BolaNieve extends Hechizo {

    public BolaNieve() {
        this.nombre = "Bola de Nieve";
    }

    @Override
    public void efecto(Monstruo monstruo) {
        monstruo.setVida(0);
    }
}
