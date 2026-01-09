package com.example.Modelo.Hechizos;

import com.example.Modelo.Hechizo;
import com.example.Modelo.Monstruo;

import jakarta.persistence.Entity;

@Entity
public class rayoOscuro extends Hechizo {

    public rayoOscuro() {
        this.nombre = "Rayo Oscuro";
    }

    @Override
    public void efecto(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - 100);
    }
}
