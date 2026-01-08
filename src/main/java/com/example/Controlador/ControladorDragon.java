package com.example.Controlador;

import java.util.List;

import com.example.Modelo.Dragon;

import jakarta.persistence.EntityManager;

public class ControladorDragon {

    private EntityManager em;

    public ControladorDragon(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para crear un dragón y añadirlo a la base de datos
     * 
     * @param nombre          Nombre del dragón
     * @param intensidadFuego Intensidad del fuego del dragon
     * @param resistencia     Puntos de vida del dragon
     */
    public void addDragon(String nombre, int intensidadFuego, int resistencia) {
        try {
            em.getTransaction().begin();

            Dragon dragon = new Dragon(nombre, intensidadFuego, resistencia);
            System.out.println("Se a creado corectamente el dragon");
            em.persist(dragon);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al añadir un Dragon: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Dragones que hay en la base de datos
     */
    public void mostrarDragones() {
        try {
            em.getTransaction().begin();

            List<Dragon> lista = em.createQuery("From Dragon", Dragon.class).getResultList();
            for (Dragon dragon : lista) {
                System.out.println(dragon.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Dragones: " + e.getMessage());
        }
    }

    /**
     * Modifica los datos de un dragón existente
     */
    public void modificarDragon(int id, String nombre, int intensidadFuego, int resistencia) {
        try {
            em.getTransaction().begin();

            Dragon dragon = em.find(Dragon.class, id);
           
            if (dragon != null) {
                dragon.setNombre(nombre);
                dragon.setIntensidadFuego(intensidadFuego);
                dragon.setResistencia(resistencia);
               
                em.merge(dragon);
                em.getTransaction().commit();
                System.out.println("Se modificó correctamente el dragón con id: " + id);
            } else {
                System.out.println("No se encontró el dragón con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al modificar un Dragón: " + e.getMessage());
        }
    }

    /**
     * Elimina un dragón por id
     */
    public void borrarDragon(int id) {
        try {
            em.getTransaction().begin();

            Dragon dragon = em.find(Dragon.class, id);
            if (dragon != null) {
                em.remove(dragon);
                em.getTransaction().commit();
                System.out.println("Se eliminó correctamente el dragón con id: " + id);
            } else {
                System.out.println("No se encontró el dragón con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar un Dragón: " + e.getMessage());
        }
    }
}
