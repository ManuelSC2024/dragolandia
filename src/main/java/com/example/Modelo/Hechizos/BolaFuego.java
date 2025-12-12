package com.example.Modelo.Hechizos;

import java.util.List;

import com.example.Modelo.Hechizo;
import com.example.Modelo.Monstruo;

public class BolaFuego extends Hechizo{
    
    public BolaFuego(){
        this.nombre = "Bola de fuego";
    }

    @Override
    public void efecto(List<Monstruo> monstruos) {

        //El numero de enemigos affectados es aleatorio
        for (Monstruo monstruo : monstruos) {
            // Añadir daño del hechizo no el del mago 
        }

    }
}
