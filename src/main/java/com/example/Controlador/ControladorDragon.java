package com.example.Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Modelo.Dragon;

public class ControladorDragon {

    private SessionFactory factory;

    public ControladorDragon(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Metodo para crear un dragón y añadirlo a la base de datos
     * 
     * @param nombre          Nombre del dragón
     * @param intensidadFuego Intensidad del fuego del dragon
     * @param resistencia     Puntos de vida del dragon
     */
    public void addDragon(String nombre, int intensidadFuego, int resistencia) {
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Dragon dragon = new Dragon(nombre, intensidadFuego, resistencia);
            System.out.println("Se a creado corectamente el dragon");
            session.persist(dragon);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al añadir un Dragon: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Dragones que hay en la base de datos
     */
    public void mostrarDragones() {
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            List<Dragon> lista = session.createQuery("From Dragon", Dragon.class).getResultList();
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Dragon dragon = session.get(Dragon.class, id);
           
            if (dragon != null) {
                dragon.setNombre(nombre);
                dragon.setIntensidadFuego(intensidadFuego);
                dragon.setResistencia(resistencia);
               
                session.merge(dragon);
                tx.commit();
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Dragon dragon = session.get(Dragon.class, id);
            if (dragon != null) {
                session.remove(dragon);
                tx.commit();
                System.out.println("Se eliminó correctamente el dragón con id: " + id);
            } else {
                System.out.println("No se encontró el dragón con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar un Dragón: " + e.getMessage());
        }
    }
}
