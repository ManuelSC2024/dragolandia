package com.example.Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Modelo.Bosque;
import com.example.Modelo.Dragon;
import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;
import com.example.Modelo.TipoMonstruo;

public class ControladorDragolandia {

    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

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
     * Metodo para crear un nuevo bosque y añadirlo a la base de datos
     * 
     * @param nombre       Nombre del boque
     * @param nivelPeligro Nivel de peligro del bosque
     * @param monstruoJefe Monstruo jefe del bosque
     * @param idDragon     Dragon del bosque
     */
    public void addBosque(String nombre, int nivelPeligro, int idMonstruoJefe, int idDragon) {
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = session.get(Monstruo.class, idMonstruoJefe);
            Dragon dragon = session.get(Dragon.class, idDragon);

            Bosque bosque = new Bosque(nombre, nivelPeligro, monstruo, dragon);

            session.persist(bosque);
            tx.commit();
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
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            Bosque bosque = session.get(Bosque.class, idBosque);
            Monstruo monstruo = session.get(Monstruo.class, idMonstruo);

            if (bosque != null && monstruo != null) {
                bosque.addMonstruo(monstruo);
                session.merge(bosque);
                tx.commit();
                System.out.println("Se añadio el monstruo al bosque correctamente");
            }
        } catch (Exception e) {
            System.out.println("Error al añadir un monstruo al bosque: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los MAgos que hay en la base de datos
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
     * Metodo para mostrar todos los Bosques que hay en la base de datos
     */
    public void mostrarBosques() {
        try (Session session = factory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();

            List<Bosque> lista = session.createQuery("From Bosque", Bosque.class).getResultList();
            for (Bosque Bosque : lista) {
                System.out.println(Bosque.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Bosques: " + e.getMessage());
        }
    }

}