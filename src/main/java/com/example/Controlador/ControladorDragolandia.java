package com.example.Controlador;


import com.example.Modelo.Hechizo;
import com.example.Modelo.TipoMonstruo;
import com.example.Util.HibernateUtil;

import jakarta.persistence.EntityManager;

public class ControladorDragolandia {

    private static EntityManager entityManager = HibernateUtil.getEntityManager();

    private ControladorMago controladorMago = new ControladorMago(entityManager);
    private ControladorMonstruo controladorMonstruo = new ControladorMonstruo(entityManager);
    private ControladorDragon controladorDragon = new ControladorDragon(entityManager);
    private ControladorBosque controladorBosque = new ControladorBosque(entityManager);
    private ControladorHechizo controladorHechizo = new ControladorHechizo(entityManager);
    private ControladorJuego controladorJuego = new ControladorJuego(entityManager);

    // Añadir Entidades
    /**
     * Delega la creación de un mago al ControladorMago
     */
    public void addMago(String nombre, int vida, int nivelMagia) {
        controladorMago.addMago(nombre, vida, nivelMagia);
    }

    /**
     * 
     * @param hechizo
     */
    public void addHechizo(Hechizo hechizo){
        controladorHechizo.addHechizo(hechizo);
    }

    /**
     * Delega el añadir un hechizo al mago al ControladorMago
     * @param idMago Id del mago
     * @param idHechizo id del hechizo
     */
    public void addHechizoMago(int idMago, int idHechizo){
        controladorMago.addHechizo(idMago, idHechizo);
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
     * Delega mostrar hechizos al ControladorHechizos
     */
    public void mostrarHechizos(){
        controladorHechizo.mostrarHechizos();
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

    /**
     * Empieza el juego con el mago selecionado y el bosque
     * @param idMagoJuego Id del mago
     * @param idBosqueJuego Id del bosque
     */    
    public void jugar(int idMagoJuego, int idBosqueJuego){
        controladorJuego.jugar(idMagoJuego, idBosqueJuego);
    }
}