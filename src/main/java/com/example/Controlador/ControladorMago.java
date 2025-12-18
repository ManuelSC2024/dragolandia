package com.example.Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Modelo.Mago;

public class ControladorMago {

    private SessionFactory factory;

    public ControladorMago(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Metodo para crear un mago y añadrilo a la base de datos
     * 
     * @param nombre     Nombre del mago
     * @param vida       Puntos de vida del mago
     * @param nivelMagia Nivel del mago.
     */
    public void addMago(String nombre, int vida, int nivelMagia) {
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Mago mago = new Mago(nombre, vida, nivelMagia);
            System.out.println("Se a creado corectamente el mago");
            session.persist(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al añadir un Mago: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Magos que hay en la base de datos
     */
    public void mostrarMago() {
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            List<Mago> lista = session.createQuery("From Mago", Mago.class).getResultList();
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Mago mago = session.get(Mago.class, id);
           
            if (mago != null) {
                mago.setNombre(nombre);
                mago.setVida(vida);
                mago.setNivelMagia(nivelMagia);
                
                session.merge(mago);
                tx.commit();
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Mago mago = session.get(Mago.class, id);
            if (mago != null) {
                session.remove(mago);
                tx.commit();
                System.out.println("Se eliminó correctamente el mago con id: " + id);
            } else {
                System.out.println("No se encontró el mago con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar un Mago: " + e.getMessage());
        }
    }
}
