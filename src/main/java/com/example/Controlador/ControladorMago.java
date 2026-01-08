package com.example.Controlador;

import java.util.List;

import com.example.Modelo.Hechizo;
import com.example.Modelo.Mago;
import com.example.Modelo.Hechizos.Rayo;

import jakarta.persistence.EntityManager;

public class ControladorMago {

    private EntityManager em;


    public ControladorMago(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para crear un mago y añadrilo a la base de datos
     * 
     * @param nombre     Nombre del mago
     * @param vida       Puntos de vida del mago
     * @param nivelMagia Nivel del mago.
     */
    public void addMago(String nombre, int vida, int nivelMagia) {
        try {
            em.getTransaction().begin();

            Mago mago = new Mago(nombre, vida, nivelMagia);
            System.out.println("Se a creado corectamente el mago");

            em.persist(mago);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al añadir un Mago: " + e.getMessage());
        } 
    }

    /**
     * Metodo para mostrar todos los Magos que hay en la base de datos
     */
    public void mostrarMago() {
        try {
            em.getTransaction().begin();

            List<Mago> lista = em.createQuery("From Mago", Mago.class).getResultList();
            for (Mago mago : lista) {
                System.out.println(mago.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Magos: " + e.getMessage());
        } 
    }

    /**
     * Modifica los datos de un mago existente
     */
    public void modificarMago(int id, String nombre, int vida, int nivelMagia) {
        try {
            em.getTransaction().begin();

            Mago mago = em.find(Mago.class, id);
           
            if (mago != null) {
                mago.setNombre(nombre);
                mago.setVida(vida);
                mago.setNivelMagia(nivelMagia);
                
                em.merge(mago);
                em.getTransaction().commit();
                System.out.println("Se modificó correctamente el mago con id: " + id);
            } else {
                System.out.println("No se encontró el mago con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al modificar un Mago: " + e.getMessage());
        }
    }

    /**
     * Elimina un mago por id
     */
    public void borrarMago(int id) {
        try {
            em.getTransaction().begin();

            Mago mago = em.find(Mago.class, id);
            if (mago != null) {
                em.remove(mago);
                em.getTransaction().commit();
                System.out.println("Se eliminó correctamente el mago con id: " + id);
            } else {
                System.out.println("No se encontró el mago con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar un Mago: " + e.getMessage());
        }
    }

    public void addHechizo(int id, String nombreHechizo){
        try{
            em.getTransaction().begin();
            Mago mago = em.find(Mago.class, 1);
            switch (nombreHechizo) {
                case "Rayo":
                    Rayo rayo = new Rayo();
                    mago.addconjuro(rayo);
                    break;
            
                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
