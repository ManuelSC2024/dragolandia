package com.example.Controlador;

import com.example.Modelo.Bosque;
import com.example.Modelo.Dragon;
import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;

import jakarta.persistence.EntityManager;

public class ControladorJuego {
    private EntityManager em;

    public ControladorJuego(EntityManager em) {
        this.em = em;
    }

    /**
     * Juegar ejecuta la logica interna del juego, mago ataca al monstruo, al derotarlo se enfrenta al jefe, donde puede que intervega el dragon
     * @param idMago Id Mago
     * @param idBosque Id Bosque
     */
    public void jugar(int idMago, int idBosque) {
        em.getTransaction().begin();

        Mago mago = em.find(Mago.class, idMago);
        Bosque bosque = em.find(Bosque.class, idBosque);
        em.getTransaction().commit();

        Monstruo monstruoJefe = bosque.getMonstruoJefe();
        Monstruo monstruo = bosque.getMonstruosEnBosque().getFirst();
        Monstruo monstruo2 = bosque.getMonstruosEnBosque().getLast();
        Dragon dragon = bosque.getDragon();
        int turno = 1;
        
        while (mago.getVida() > 0 && monstruo.getVida() > 0) {

            System.out.println("=== Turno " + turno + " ===");
            System.out.println("Vida del mago " + mago.getNombre() + ": " + mago.getVida());
            System.out.println("Vida del " + monstruo.getNombre() + ": " + monstruo.getVida());

            System.out.println("El mago " + mago.getNombre() + " ataca al " + monstruo.getNombre());
            mago.lanzarHechizo(monstruo);
            System.out.println("El mago hace " + mago.getNivelMagia() + " puntos de daño");

            System.out.println("El " + monstruo.getNombre() + " ataca al mago " + mago.getNombre());
            monstruo.atacar(mago);
            System.out.println("El " + monstruo.getNombre() + " hace " + monstruo.getFuerza() + " puntos de daño");

            System.out.println();
            turno++;

            if (mago.getVida() == 0) {
                System.out.println("El mago " + mago.getNombre() + " a muerto");
                System.out.println("El monstruo a ganado");
                System.out.println(monstruo.getNombre() + " se quedo con " + monstruo.getVida() + " puntos de vida");
            }

            if (monstruo.getVida() == 0) {
                System.out.println("El " + monstruo.getNombre() + " a muerto");
                System.out.println("El mago a ganado");
                System.out.println(mago.getNombre() + " se quedo con " + mago.getVida() + " puntos de vida");
            }
        }

        turno = 1;
        while (mago.getVida() > 0 && monstruoJefe.getVida() > 0) {
            System.out.println("El mogo se enfrenta al monstruo jefe del bosque: " + monstruoJefe.getNombre());

            System.out.println("=== Turno " + turno + " ===");
            System.out.println("Vida del mago " + mago.getNombre() + ": " + mago.getVida());
            System.out.println("Vida del " + monstruoJefe.getNombre() + ": " + monstruoJefe.getVida());

            System.out.println("El mago " + mago.getNombre() + " ataca al " + monstruoJefe.getNombre());
            mago.lanzarHechizo(monstruoJefe);
            System.out.println("El mago hace " + mago.getNivelMagia() + " puntos de daño");

            System.out.println("El " + monstruoJefe.getNombre() + " ataca al mago " + mago.getNombre());
            monstruoJefe.atacar(mago);
            System.out.println("El " + monstruoJefe.getNombre() + " hace " + monstruoJefe.getFuerza() + " puntos de daño");

            System.out.println();
            turno++;

            if (turno%4 == 0) {
                System.out.println("La pelea a atraido a " + dragon.getNombre() + " el dragon que habita este bosque");
                System.out.println(dragon.getNombre() + "Ataca al monstruo jefe");
                dragon.exhalar(monstruoJefe);
                System.out.println(dragon.getNombre() + "Hace " + dragon.getIntensidadFuego() + " puntos de daño al " + monstruoJefe.getNombre());
                System.out.println();
            }

            if (mago.getVida() == 0) {
                System.out.println("El mago " + mago.getNombre() + " a muerto");
                System.out.println("El monstruo a ganado");
                System.out.println(monstruoJefe.getNombre() + " se quedo con " + monstruoJefe.getVida() + " puntos de vida");

            }

            if (monstruoJefe.getVida() == 0) {
                System.out.println("El " + monstruo.getNombre() + " a muerto");
                System.out.println("El mago a ganado");
                System.out.println(mago.getNombre() + " se quedo con " + mago.getVida() + " puntos de vida");

                bosque.cambiarMonstruoJefe(monstruo2);
                System.out.println("El nuevo monstruo jefe del bosque es: " + monstruo2.getNombre());
            }
        }
        System.out.println();
    }
}