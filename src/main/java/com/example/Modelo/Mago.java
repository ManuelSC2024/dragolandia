package com.example.Modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Magos")
public class Mago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida;
    private int nivelMagia;

    @ManyToMany
    private List<Hechizo> conjuros = new ArrayList<>();

    public Mago() {
    }

    public Mago(String nombre, int vida, int nivelMagia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    @Override
    public String toString() {
        return "Mago [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", nivelMagia=" + nivelMagia + ", conjuros="
                + conjuros + "]";
    }

      /**
     * Este metodo calcula el daño que causa el mago a un mostruo
     * @param monstruo Monstruo que recibe daño
     */
    public void lanzarHechizo(Monstruo monstruo) {
        int vidaRestante = monstruo.getVida() - this.getNivelMagia();
        if (vidaRestante > 0) {
            monstruo.setVida(vidaRestante);
        } else
            monstruo.setVida(0);
        System.out.println(
                "El mago quito " + this.getNivelMagia() + " puntos de vida al monstruo: " + monstruo.getNombre());
    }

    public void lanzarHechizo(Monstruo monstruo, Hechizo hechizo){
        if (conjuros.contains(hechizo)) {
            switch (hechizo.nombre) {
                case "Bola de fuego":
                        List<Monstruo> monstruos = new ArrayList<>();
                        monstruos.add(monstruo);
                        hechizo.efecto(monstruos, id);
                    break;

                case "Bola de Nieve":
                    hechizo.efecto(monstruo);
                    break;

                case "Rayo":
                    hechizo.efecto(monstruo, this.nivelMagia);
                    break;
            
                default:
                    System.out.println("El hechizo no existe");
                    break;
            }
        }else {
            System.out.println("El mago no conoce el hechizo");
            System.out.println("El mago pierde 1 punto de vida");
            setVida(this.vida-1);
        }
    }

    /**
     * Añade un hechizo a la lista de conjuros aprendidos del mago
     * @param hechizo Hechizo a aprender
     */
    public void addconjuro(Hechizo hechizo){
        conjuros.add(hechizo);
    }
}
