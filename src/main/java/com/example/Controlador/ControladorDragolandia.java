package com.example.Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Modelo.Bosque;
import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;
import com.example.Modelo.TipoMonstruo;

public class ControladorDragolandia {

    Session session = null;

    /**
     * Metodo para crear un mago y añadrilo a la base de datos
     * 
     * @param nombre     Nombre del mago
     * @param vida       Puntos de vida del mago
     * @param nivelMagia Nivel del mago.
     */
    public void addMago(String nombre, int vida, int nivelMagia) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Mago mago = new Mago(nombre, vida, nivelMagia);
            System.out.println("Se a creado corectamente el mago");
            session.persist(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
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
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = new Monstruo(nombre, vida, tipo, fuerza);
            System.out.println("Se a creado corectamente el mago");
            session.persist(monstruo);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
    }

    /**
     * Metodo para crear un nuevo bosque y añadirlo a la base de datos
     * 
     * @param nombre       Nombre del boque
     * @param nivelPeligro Nivel de peligro del bosque
     * @param monstruoJefe Monstruo jefe del bosque
     */
    public int addBosque(String nombre, int nivelPeligro, Monstruo monstruoJefe) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Bosque bosque = new Bosque(nombre, nivelPeligro, monstruoJefe);
            session.persist(bosque);
            tx.commit();
            return bosque.getId();
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
        return -1;
    }

    public void mostrarMonstruos() {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();

            List<Monstruo> lista = session.createQuery("From Monstruos", Monstruo.class).getResultList();
            for (Monstruo monstruo : lista) {
                System.out.println(monstruo.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
    }

    public void mostrarBosques() {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();

            List<Bosque> lista = session.createQuery("From Bosques", Bosque.class).getResultList();
            for (Bosque Bosque : lista) {
                System.out.println(Bosque.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
    }

    public Bosque leerBosque(int idBosque) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();

            Bosque bosque = session.get(Bosque.class, idBosque);
            return bosque;

        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
        return null;
    }

    public Monstruo leerMonstruo(int idMonstruo) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = session.get(Monstruo.class, idMonstruo);
            return monstruo;

        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
        return null;
    }

    public void addMonstruoBosque(int idBosque, int idMonstruo) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Bosque bosque = leerBosque(idBosque);
            Monstruo monstruo = leerMonstruo(idMonstruo);

            if (bosque != null && monstruo != null) {
                bosque.addMonstruo(monstruo);
                System.out.println("Se añadio el monstruo al bosque correctamente");
            } else
                System.out.println("Error al añadir el monstruo al bosque");

        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
    }
}
