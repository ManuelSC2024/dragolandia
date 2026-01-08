package com.example;

import com.example.Util.HibernateUtil;
import com.example.Vista.VistaDragolandia;

public final class App {

    public static void main(String[] args) {
        new VistaDragolandia();
        HibernateUtil.cerrarSesion();
    }
}
