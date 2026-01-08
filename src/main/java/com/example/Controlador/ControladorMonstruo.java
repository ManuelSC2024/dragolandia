package com.example.Controlador;

import java.util.List;

import com.example.Modelo.Monstruo;
import com.example.Modelo.TipoMonstruo;

import jakarta.persistence.EntityManager;

public class ControladorMonstruo {

    private EntityManager em;

    public ControladorMonstruo(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para crear un monstruo y añadirlo a la base de datos
     * 
     * @param nombre Nombre del monstruo
     * @param vida   Puntos der vida del monstruo
     * @param tipo   Tipo de monstruo
     * @param fuerza Puntos de fuerza del monstruo
     */
    public void addMonstruo(String nombre, int vida, TipoMonstruo tipo, int fuerza) {
        try {
            em.getTransaction().begin();

            Monstruo monstruo = new Monstruo(nombre, vida, tipo, fuerza);
            System.out.println("Se a creado corectamente el Monstruo");
            em.persist(monstruo);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al añadir un Monstruo: " + e.getMessage());
        } 
    }

    /**
     * Metodo para mostrar todos los Monstruos que hay en la base de datos
     */
    public void mostrarMonstruos() {
        try {
            em.getTransaction().begin();

            List<Monstruo> lista = em.createQuery("From Monstruo", Monstruo.class).getResultList();
            for (Monstruo monstruo : lista) {
                System.out.println(monstruo.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Monstruos: " + e.getMessage());
        } 
    }

    /**
     * Modifica los datos de un monstruo existente
     */
    public void modificarMonstruo(int id, String nombre, int vida, TipoMonstruo tipo, int fuerza) {
        try {
            em.getTransaction().begin();

            Monstruo monstruo = em.find(Monstruo.class, id);
            
            if (monstruo != null) {
                monstruo.setNombre(nombre);
                monstruo.setVida(vida);
                monstruo.setTipo(tipo);
                monstruo.setFuerza(fuerza);
               
                em.merge(monstruo);
                em.getTransaction().commit();
                System.out.println("Se modificó correctamente el monstruo con id: " + id);
            } else {
                System.out.println("No se encontró el monstruo con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al modificar un Monstruo: " + e.getMessage());
        } 
    }

    /**
     * Elimina un monstruo por id
     */
    public void borrarMonstruo(int id) {
        try {
            em.getTransaction().begin();

            Monstruo monstruo = em.find(Monstruo.class, id);
            if (monstruo != null) {
                em.remove(monstruo);
                em.getTransaction().commit();
                System.out.println("Se eliminó correctamente el monstruo con id: " + id);
            } else {
                System.out.println("No se encontró el monstruo con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar un Monstruo: " + e.getMessage());
        } 
    }
}
