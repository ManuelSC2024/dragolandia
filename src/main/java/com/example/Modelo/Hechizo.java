package com.example.Modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Hechizo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected String nombre;

    /**
     * Recive una lista de monstruos y les hace daño daño a partir del nivel de magia del mago.
     * @param monstruos Recive una lista de monstruos
     * @param danho Recive el daño del Mago (nivel de magia)
     */
    public void efecto(List<Monstruo> monstruos, int danho){}
    
    /**
     * Recive un monstruo y le hace daño a partir del nivel de magia del mago
     * @param monstruo Revice un monstruo
     * @param danho Revice el nivel de magia del mago
     */
    public void efecto(Monstruo monstruo, int danho){}

    /**
     * Recive un monstruo y le reduce la vida a cero
     * @param monstruo Revice un monstruo
     */
    public void efecto(Monstruo monstruo){}

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Hechizo [id=" + id + ", nombre=" + nombre + "]";
    }
}
