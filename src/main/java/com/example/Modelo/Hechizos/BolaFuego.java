package com.example.Modelo.Hechizos;

import java.util.List;

import com.example.Modelo.Hechizo;
import com.example.Modelo.Monstruo;

public class BolaFuego extends Hechizo{

    public BolaFuego(){
        this.nombre = "Bola de fuego";
    }

    /**
     * 
     */
    @Override
    public void efecto(List<Monstruo> monstruos, int danho){
        if(monstruos == null || monstruos.isEmpty()) return;
        int d = Math.max(0, danho);
        for (Monstruo monstruo : monstruos) {
            if (monstruo == null) continue;
            monstruo.setVida(Math.max(0, monstruo.getVida() - d));
        }
    }
}
