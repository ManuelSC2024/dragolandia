package com.example.Controlador;


import com.example.Modelo.TipoMonstruo;
import com.example.Util.HibernateUtil;

import jakarta.persistence.EntityManager;

public class ControladorDragolandia {

    
    private static EntityManager entityManager = HibernateUtil.getEntityManager();


    private ControladorMago controladorMago = new ControladorMago(entityManager);
    private ControladorMonstruo controladorMonstruo = new ControladorMonstruo(entityManager);
    private ControladorDragon controladorDragon = new ControladorDragon(entityManager);
    private ControladorBosque controladorBosque = new ControladorBosque(entityManager);

    // Añadir Entidades
    /**
     * Delega la creación de un mago al ControladorMago
     */
    public void addMago(String nombre, int vida, int nivelMagia) {
        controladorMago.addMago(nombre, vida, nivelMagia);
    }

    /**
     * Delega la creación de un monstruo al ControladorMonstruo
     */
    public void addMonstruo(String nombre, int vida, TipoMonstruo tipo, int fuerza) {
        controladorMonstruo.addMonstruo(nombre, vida, tipo, fuerza);
    }

    /**
     * Delega la creación de un dragón al ControladorDragon
     */
    public void addDragon(String nombre, int intensidadFuego, int resistencia) {
        controladorDragon.addDragon(nombre, intensidadFuego, resistencia);
    }

    /**
     * Delega la creación de un bosque al ControladorBosque
     */
    public void addBosque(String nombre, int nivelPeligro, int idMonstruoJefe, int idDragon) {
        controladorBosque.addBosque(nombre, nivelPeligro, idMonstruoJefe, idDragon);
    }

    /**
     * Delega añadir un monstruo a un bosque al ControladorBosque
     */
    public void addMonstruoBosque(int idBosque, int idMonstruo) {
        controladorBosque.addMonstruoBosque(idBosque, idMonstruo);
    }



    // Mostrar Entidades
    /**
     * Delega mostrar magos al ControladorMago
     */
    public void mostrarMago() {
        controladorMago.mostrarMago();
    }

    /**
     * Delega mostrar monstruos al ControladorMonstruo
     */
    public void mostrarMonstruos() {
        controladorMonstruo.mostrarMonstruos();
    }

    /**
     * Delega mostrar dragones al ControladorDragon
     */
    public void mostrarDragones() {
        controladorDragon.mostrarDragones();
    }

    /**
     * Delega mostrar bosques al ControladorBosque
     */
    public void mostrarBosques() {
        controladorBosque.mostrarBosques();
    }

    // Modificar Entidades
    public void modificarMago(int id, String nombre, int vida, int nivelMagia) {
        controladorMago.modificarMago(id, nombre, vida, nivelMagia);
    }

    public void modificarMonstruo(int id, String nombre, int vida, TipoMonstruo tipo, int fuerza) {
        controladorMonstruo.modificarMonstruo(id, nombre, vida, tipo, fuerza);
    }

    public void modificarDragon(int id, String nombre, int intensidadFuego, int resistencia) {
        controladorDragon.modificarDragon(id, nombre, intensidadFuego, resistencia);
    }

    public void modificarBosque(int id, String nombre, int nivelPeligro, int idMonstruoJefe, int idDragon) {
        controladorBosque.modificarBosque(id, nombre, nivelPeligro, idMonstruoJefe, idDragon);
    }



    // Eliminar Entidades

    /**
     * Borra un mago apartir de su id
     * @param id Id del Mago
     */
    public void borrarMago(int id) {
        controladorMago.borrarMago(id);
    }

     /**
     * Borra un Monstruo apartir de su id
     * @param id Id del Monstruo
     */
    public void borrarMonstruo(int id) {
        controladorMonstruo.borrarMonstruo(id);
    }

     /**
     * Borra un Dragon apartir de su id
     * @param id Id del Dragon
     */
    public void borrarDragon(int id) {
        controladorDragon.borrarDragon(id);
    }

     /**
     * Borra un Bosque apartir de su id
     * @param id Id del Bosque
     */
    public void borrarBosque(int id) {
        controladorBosque.borrarBosque(id);
    }

    //Jugar
    public void jugar(int idMagoJuego, int idBosqueJuego){
        System.out.println("Sin implementar");
    }
}