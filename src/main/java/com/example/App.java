package com.example;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;

/**
 * Hello world!
 */
public final class App {

    public static void main(String[] args) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {

            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();
           
           
           
            System.out.println("Se procedera a crear un nuevo Mago");
            Scanner scanner = new Scanner(System.in);

            System.out.println("ingrese el nombre del mago");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese los puntos de vida del mago");
            int vida = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el nivel de magia del mago");
            int nivelMagia = Integer.parseInt(scanner.nextLine());

            Mago mago = new Mago(nombre, vida, nivelMagia);
            session.persist(mago);


            // Añadir la lista de tipos al mostruo

            System.out.println("Se procedera a crear un nuevo Monstruo");

            System.out.println("ingrese el nombre del Monstruo");
            nombre = scanner.nextLine();

            System.out.println("Ingrese los puntos de vida del Monstruo");
            vida = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el tipo de Monstruo");
            String tipo = scanner.nextLine();

            System.out.println("Ingrese el nivel de magia del Monstruo");
            int fuerza = Integer.parseInt(scanner.nextLine());

            Monstruo monstruo = new Monstruo(nombre, vida, tipo, fuerza);
            session.persist(monstruo);

            tx.commit();


        } catch (Exception e) {
            System.out.println("Error al crear la session: " + e.getMessage());
        }

    }
}
