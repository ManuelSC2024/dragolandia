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
     * Metodo para crear un dragón y añadirlo a la base de datos
     * @param nombre  Nombre del dragón
     * @param intensidadFuego Intensidad del fuego del dragon
     * @param resistencia Puntos de vida del dragon
     */
    public void addDragon(String nombre, int intensidadFuego, int resistencia) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Dragon dragon = new Dragon(nombre, intensidadFuego, resistencia);
            System.out.println("Se a creado corectamente el dragon");
            session.persist(dragon);
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
    public int addBosque(String nombre, int nivelPeligro, int monstruoJefe) {
        Monstruo monstruo = leerMonstruo(monstruoJefe);
        Bosque bosque = new Bosque(nombre, nivelPeligro, monstruo);

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.persist(bosque);
            tx.commit();
            return bosque.getId();
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
        return -1;
    }

    /**
     * Metodo para mostrar todos los MAgos que hay en la base de datos
     */
    public void mostrarMago() {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            List<Mago> lista = session.createQuery("From Mago", Mago.class).getResultList();
            for (Mago mago : lista) {
                System.out.println(mago.toString());
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Monstruos que hay en la base de datos
     */
    public void mostrarMonstruos() {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            List<Monstruo> lista = session.createQuery("From Monstruo", Monstruo.class).getResultList();
            for (Monstruo monstruo : lista) {
                System.out.println(monstruo.toString());
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Bosques que hay en la base de datos
     */
    public void mostrarBosques() {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();

            List<Bosque> lista = session.createQuery("From Bosque", Bosque.class).getResultList();
            for (Bosque Bosque : lista) {
                System.out.println(Bosque.toString());
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
    }

    /**
     * Metodo para recoger un Bosque de la base de datos apartir de su id
     * 
     * @param idBosque Id del Bosque
     * @return debuelve un objeto de tipo Bosque
     */
    public Bosque leerBosque(int idBosque) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();

            Bosque bosque = session.get(Bosque.class, idBosque);
            session.close();

            return bosque;
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para recoger un Monstruo de la base de datos apartir de su id
     * 
     * @param idMonstruo Id del Monstruo
     * @return debuelve un objeto de tipo Monstruo
     */
    public Monstruo leerMonstruo(int idMonstruo) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = session.get(Monstruo.class, idMonstruo);
            session.close();
            return monstruo;
        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }
        return null;
    }

    /**
     * Añade un Monstruo a un bosque
     * @param idBosque   Id del bosque
     * @param idMonstruo Id del Monstruo
     */
    public void addMonstruoBosque(int idBosque, int idMonstruo) {
        Bosque bosque = leerBosque(idBosque);
        Monstruo monstruo = leerMonstruo(idMonstruo);

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

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
