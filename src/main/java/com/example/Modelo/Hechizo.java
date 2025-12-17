package com.example.Modelo;

import java.util.List;

public class Hechizo {
    protected String nombre;

    public void efecto(List<Monstruo> monstruos, int danho){}
    
    public void efecto(Monstruo monstruo, int danho){}

    public void efecto(Monstruo monstruo){}
}
