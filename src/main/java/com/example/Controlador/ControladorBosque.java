package com.example.Controlador;

import java.util.List;

import com.example.Modelo.Bosque;
import com.example.Modelo.Dragon;
import com.example.Modelo.Monstruo;

import jakarta.persistence.EntityManager;

public class ControladorBosque {

    private EntityManager em;

    public ControladorBosque(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para crear un nuevo bosque y añadirlo a la base de datos
     * 
     * @param nombre       Nombre del boque
     * @param nivelPeligro Nivel de peligro del bosque
     * @param idMonstruoJefe Id del monstruo jefe del bosque
     * @param idDragon     Id del dragon del bosque
     */
    public void addBosque(String nombre, int nivelPeligro, int idMonstruoJefe, int idDragon) {
        try {
            em.getTransaction().begin();

            Monstruo monstruo = em.find(Monstruo.class, idMonstruoJefe);
            Dragon dragon = em.find(Dragon.class, idDragon);

            Bosque bosque = new Bosque(nombre, nivelPeligro, monstruo, dragon);

            em.persist(bosque);
            em.getTransaction().commit();
            System.out.println("Se añadio el bosque correctamente");
        } catch (Exception e) {
            System.out.println("Error al añadir un bosque: " + e.getMessage());
        } 
    }

    /**
     * Añade un Monstruo a un bosque
     * 
     * @param idBosque   Id del bosque
     * @param idMonstruo Id del Monstruo
     */
    public void addMonstruoBosque(int idBosque, int idMonstruo) {
        try {
            em.getTransaction().begin();

            Bosque bosque = em.find(Bosque.class, idBosque);
            Monstruo monstruo = em.find(Monstruo.class, idMonstruo);

            if (bosque != null && monstruo != null) {
                bosque.addMonstruo(monstruo);
                em.merge(bosque);
                em.getTransaction().commit();
                System.out.println("Se añadio el monstruo al bosque correctamente");
            }
        } catch (Exception e) {
            System.out.println("Error al añadir un monstruo al bosque: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Bosques que hay en la base de datos
     */
    public void mostrarBosques() {
        try {
            em.getTransaction().begin();

            List<Bosque> lista = em.createQuery("From Bosque", Bosque.class).getResultList();
            for (Bosque Bosque : lista) {
                System.out.println(Bosque.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Bosques: " + e.getMessage());
        } 
    }

    /**
     * Modifica los datos de un bosque existente
     */
    public void modificarBosque(int id, String nombre, int nivelPeligro, int idMonstruoJefe, int idDragon) {
        try {
            em.getTransaction().begin();

            Bosque bosque = em.find(Bosque.class, id);
            if (bosque != null) {
                bosque.setNombre(nombre);
                bosque.setNivelPeligro(nivelPeligro);
                
                Monstruo jefe = em.find(Monstruo.class, idMonstruoJefe);
                Dragon dragon = em.find(Dragon.class, idDragon);
               
                bosque.setMonstruoJefe(jefe);
                bosque.setDragon(dragon);
               
                em.merge(bosque);
                em.getTransaction().commit();
                System.out.println("Se modificó correctamente el bosque con id: " + id);
            } else {
                System.out.println("No se encontró el bosque con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al modificar un Bosque: " + e.getMessage());
        } 
    }

    /**
     * Elimina un bosque por id
     */
    public void borrarBosque(int id) {
        try {
            em.getTransaction().begin();

            Bosque bosque = em.find(Bosque.class, id);
            if (bosque != null) {
                em.remove(bosque);
                em.getTransaction().commit();
                System.out.println("Se eliminó correctamente el bosque con id: " + id);
            } else {
                System.out.println("No se encontró el bosque con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar un Bosque: " + e.getMessage());
        } 
    }
}
