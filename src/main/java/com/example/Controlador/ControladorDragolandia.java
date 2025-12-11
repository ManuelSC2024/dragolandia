package com.example.Controlador;

import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;

public class ControladorDragolandia {
    public void addMago(String nombre, int vida, int nivelMagia){
        Mago mago = new Mago(nombre, vida, nivelMagia);
        System.out.println("Se a creado corectamente el mago");
    }
    public void addMonstruo(String nombre, int vida,String tipo ,int fuerza){
        Monstruo monstruo = new Monstruo(nombre, vida, tipo ,fuerza);
        System.out.println("Se a creado corectamente el mago");
    }

}
