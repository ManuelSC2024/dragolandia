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
import com.example.Modelo.Hechizos.BolaFuego;
import com.example.Modelo.Hechizos.Rayo;
import com.example.Modelo.Hechizos.BolaNieve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorDragolandia {

    private Session session = null;

    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     * Metodo para crear un mago y añadrilo a la base de datos
     * 
     * @param nombre     Nombre del mago
     * @param vida       Puntos de vida del mago
     * @param nivelMagia Nivel del mago.
     */
    public void addMago(String nombre, int vida, int nivelMagia) {
        try {
            session = factory.getCurrentSession();
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
        try {
            session = factory.getCurrentSession();
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
        try {
            session = factory.getCurrentSession();
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
     */
    public void addBosque(String nombre, int nivelPeligro, int monstruoJefe) {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Monstruo monstruo = session.get(Monstruo.class, monstruoJefe);
            Bosque bosque = new Bosque(nombre, nivelPeligro, monstruo);

            session.persist(bosque);
            tx.commit();
            System.out.println("Se añadio el bosque correctamente");
        } catch (Exception e) {
            System.out.println("Error al añadir un bosque: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los MAgos que hay en la base de datos
     */
    public void mostrarMago() {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            List<Mago> lista = session.createQuery("From Mago", Mago.class).getResultList();
            for (Mago mago : lista) {
                System.out.println(mago.toString());
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Magos: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Monstruos que hay en la base de datos
     */
    public void mostrarMonstruos() {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            List<Monstruo> lista = session.createQuery("From Monstruo", Monstruo.class).getResultList();
            for (Monstruo monstruo : lista) {
                System.out.println(monstruo.toString());
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Monstruos: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Dragones que hay en la base de datos
     */
    public void mostrarDragones() {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            List<Dragon> lista = session.createQuery("From Dragon", Dragon.class).getResultList();
            for (Dragon dragon : lista) {
                System.out.println(dragon.toString());
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Dragones: " + e.getMessage());
        }
    }

    /**
     * Metodo para mostrar todos los Bosques que hay en la base de datos
     */
    public void mostrarBosques() {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            List<Bosque> lista = session.createQuery("From Bosque", Bosque.class).getResultList();
            for (Bosque Bosque : lista) {
                System.out.println(Bosque.toString());
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar todos los Bosques: " + e.getMessage());
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
            session = factory.getCurrentSession();
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

    public List<Monstruo> obtenerMonstruosDelBosque(int idBosque, int max) {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Bosque bosque = session.get(Bosque.class, idBosque);
            if (bosque == null) {
                System.out.println("Bosque no encontrado.");
                session.close();
                return Collections.emptyList();
            }

            List<Monstruo> monstruos = bosque.getMonstruosEnBosque();
            if (monstruos == null || monstruos.isEmpty()) {
                System.out.println("El bosque seleccionado no tiene monstruos.");
                session.close();
                return Collections.emptyList();
            }

            int limite = Math.min(Math.max(1, max), monstruos.size());
            List<Monstruo> seleccion = new ArrayList<>(monstruos.subList(0, limite));
            tx.commit();
            return seleccion;
        } catch (Exception e) {
            System.out.println("Error obteniendo monstruos del bosque: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void combatirMonstruo(int idMago, int idMonstruo, int hechizoOpcion) {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Mago mago = session.get(Mago.class, idMago);
            Monstruo monstruo = session.get(Monstruo.class, idMonstruo);
            if (mago == null || monstruo == null) {
                System.out.println("Mago o Monstruo no encontrado.");
                session.close();
                return;
            }

            BolaFuego bolaFuego = new BolaFuego();
            Rayo rayo = new Rayo();
            BolaNieve bolaNieve = new BolaNieve();

            switch (hechizoOpcion) {
                case 1:
                    ArrayList<Monstruo> objetivos = new ArrayList<>();
                    objetivos.add(monstruo);
                    bolaFuego.efecto(objetivos, mago.getNivelMagia());
                    System.out.println("El mago lanza Bola de Fuego (daño=" + mago.getNivelMagia() + ") → vida del monstruo: " + monstruo.getVida());
                    break;

                case 2:
                    rayo.efecto(monstruo, mago.getNivelMagia());
                    System.out.println("El mago lanza Rayo (daño=" + mago.getNivelMagia() + ") → vida del monstruo: " + monstruo.getVida());
                    break;
                case 3:
                    bolaNieve.efecto(monstruo);
                    System.out.println("El mago lanza Bola de Nieve → vida del monstruo: " + monstruo.getVida());
                    break;
            }

            if (monstruo.getVida() > 0) {
                monstruo.atacar(mago);
                System.out.println("Contraataque de " + monstruo.getNombre() + " -> vida del mago: " + mago.getVida());
            }

            session.merge(monstruo);
            session.merge(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error durante el combate: " + e.getMessage());
        }
    }

    public void combatirJefe(int idMago, int idBosque, int hechizoOpcion) {
        try {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Mago mago = session.get(Mago.class, idMago);
            Bosque bosque = session.get(Bosque.class, idBosque);
            if (mago == null || bosque == null) {
                System.out.println("Mago o Bosque no encontrado.");
                session.close();
                return;
            }

            Monstruo jefe = bosque.getMonstruoJefe();
            if (jefe == null) {
                System.out.println("El bosque no tiene jefe definido.");
                session.close();
                return;
            }

            BolaFuego bolaFuego = new BolaFuego();
            Rayo rayo = new Rayo();
            BolaNieve bolaNieve = new BolaNieve();

            switch (hechizoOpcion) {
                case 1:
                    ArrayList<Monstruo> objetivos = new ArrayList<>();
                    objetivos.add(jefe);
                    bolaFuego.efecto(objetivos, mago.getNivelMagia());
                    System.out.println("Bola de Fuego (daño=" + mago.getNivelMagia() + ") → vida del jefe: " + jefe.getVida());
                    break;
                case 2:
                    rayo.efecto(jefe, mago.getNivelMagia());
                    System.out.println("Rayo (daño=" + mago.getNivelMagia() + ") → vida del jefe: " + jefe.getVida());
                    break;
                case 3:
                    bolaNieve.efecto(jefe);
                    System.out.println("Bola de Nieve → vida del jefe: " + jefe.getVida());
                    break;
            }

            if (jefe.getVida() > 0) {
                jefe.atacar(mago);
                System.out.println("Contraataque del jefe → vida del mago: " + mago.getVida());
            }

            session.merge(jefe);
            session.merge(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error en el enfrentamiento con el jefe: " + e.getMessage());
        }
    }


}