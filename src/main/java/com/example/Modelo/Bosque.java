package com.example.Modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bosques")
public class Bosque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int nivelPeligro;

    @OneToOne(cascade = CascadeType.MERGE)
    private Monstruo monstruoJefe;

    @OneToMany(targetEntity = Monstruo.class)
    private List<Monstruo> monstruosEnBosque;

    public Bosque() {
    }

    public Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    @Override
    public String toString() {
        return "Bosque [\n id=" + id
                + ",\n nombre=" + nombre
                + ",\n nivelPeligro=" + nivelPeligro
                + ",\n monstruoJefe=" + monstruoJefe
                + "\n]";
    }

    /**
     * Mostra el mosntruo jefe.
     */
    public void mostrarJefe() {
        System.err.println(this.monstruoJefe.toString());
    }

    /**
     * Cambia el monstruo jefe del bosque
     * 
     * @param monstruo Nuevo monstruo jefe
     */
    public void cambiarMonstruoJefe(Monstruo monstruo) {
        setMonstruoJefe(monstruo);
        System.out.println("Se cambio correctamente el monstruo jefe por: " + monstruo.getNombre());
    }

    /**
     * Añade un nuevo mosntruo al bosque
     * 
     * @param monstruo Monstruo nuevo en el bosque
     */
    public void addMonstruo(Monstruo monstruo) {
        monstruosEnBosque.add(monstruo);
        System.out.println("Se añadio el monstruo correctamente al bosque");
    }
}
