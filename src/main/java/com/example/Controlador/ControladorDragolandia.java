package com.example.Controlador;

import com.example.Modelo.Mago;

public class ControladorDragolandia {
    public void añadirMago(String nombre, int vida, int nivelMagia){
        Mago mago = new Mago(nombre, vida, nivelMagia);
        System.out.println("Se a creado corectamente el mago");
    }
    

}
