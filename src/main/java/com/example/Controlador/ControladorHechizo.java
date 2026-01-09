package com.example.Controlador;

import java.util.List;

import com.example.Modelo.Hechizo;

import jakarta.persistence.EntityManager;



public class ControladorHechizo {
    private EntityManager em;

    public ControladorHechizo(EntityManager em){
        this.em = em;
    } 

    /**
     * Añade un hechizo a la base de datos
     * @param hechizo Hechizo al añadir a la base de datos
     */
    public void addHechizo(Hechizo hechizo){
        try {
            em.getTransaction().begin();
            em.persist(hechizo);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo añadir el hechizo a la base de datos: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los hechizos que hay en la base de datos
     */
    public void mostrarHechizos(){
        try {
            em.getTransaction().begin();
            List<Hechizo> lista = em.createQuery("From Hechizo", Hechizo.class).getResultList();
            for (Hechizo hechizo : lista) {
                System.out.println(hechizo);
            }
            System.out.println();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo mostrar los hechizos");        
        }   
    }
}
