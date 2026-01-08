package com.example.Modelo.Hechizos;

import com.example.Modelo.Hechizo;
import com.example.Modelo.Monstruo;

public class Rayo extends Hechizo{

    public Rayo(){
        this.nombre = "Rayo";
    }

    /**
     * 
     */
    @Override
    public void efecto(Monstruo monstruos, int danho){
       monstruos.setVida(monstruos.getVida() - danho);
    }
}
