package com.example.Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Modelo.Monstruo;
import com.example.Modelo.TipoMonstruo;

public class ControladorMonstruo {

    private SessionFactory factory;

    public ControladorMonstruo(SessionFactory factory) {
        this.factory = factory;
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = new Monstruo(nombre, vida, tipo, fuerza);
            System.out.println("Se a creado corectamente el Monstruo");
            session.persist(monstruo);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al añadir un Monstruo: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Monstruos que hay en la base de datos
     */
    public void mostrarMonstruos() {
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            List<Monstruo> lista = session.createQuery("From Monstruo", Monstruo.class).getResultList();
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = session.get(Monstruo.class, id);
            
            if (monstruo != null) {
                monstruo.setNombre(nombre);
                monstruo.setVida(vida);
                monstruo.setTipo(tipo);
                monstruo.setFuerza(fuerza);
               
                session.merge(monstruo);
                tx.commit();
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = session.get(Monstruo.class, id);
            if (monstruo != null) {
                session.remove(monstruo);
                tx.commit();
                System.out.println("Se eliminó correctamente el monstruo con id: " + id);
            } else {
                System.out.println("No se encontró el monstruo con id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar un Monstruo: " + e.getMessage());
        }
    }
}
