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
public class Hechizo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected String nombre;

    public void efecto(List<Monstruo> monstruos, int danho){}
    
    public void efecto(Monstruo monstruo, int danho){}

    public void efecto(Monstruo monstruo){}
}
