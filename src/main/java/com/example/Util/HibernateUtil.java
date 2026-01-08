package com.example.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory xestorEntidades = Persistence.createEntityManagerFactory("dragolandiaServizo");

    public static EntityManager getEntityManager(){
        return xestorEntidades.createEntityManager();
    }

    public static void cerrarSesion(){
        if (xestorEntidades.isOpen()) {
            xestorEntidades.close();
        }
    }
}

