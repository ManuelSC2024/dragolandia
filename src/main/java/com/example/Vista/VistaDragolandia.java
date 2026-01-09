package com.example.Vista;

import java.util.Scanner;

import com.example.Controlador.ControladorDragolandia;
import com.example.Modelo.TipoMonstruo;
import com.example.Modelo.Hechizos.BolaFuego;
import com.example.Modelo.Hechizos.BolaNieve;
import com.example.Modelo.Hechizos.Rayo;

public class VistaDragolandia {
    ControladorDragolandia controlador = new ControladorDragolandia();

    public VistaDragolandia() {


        Rayo rayo = new Rayo();
        BolaFuego bFuego = new BolaFuego();
        BolaNieve bNieve = new BolaNieve();

        controlador.addMago("Gandalf", 200, 20);
        controlador.addMago("Merlín", 125, 10);

        controlador.addHechizo(rayo);
        controlador.addHechizo(bFuego);
        controlador.addHechizo(bNieve);

        controlador.addHechizoMago(1, 1);
        controlador.addHechizoMago(1, 2);
        
        controlador.addHechizoMago(2, 2);
        controlador.addHechizoMago(2, 3);

        controlador.addMonstruo("Ogro del Bosque", 250, TipoMonstruo.valueOf("OGRO"), 10);
        controlador.addMonstruo("Espectro", 250, TipoMonstruo.valueOf("ESPECTRO"), 10);
        controlador.addMonstruo("Ogro pequeño", 0, TipoMonstruo.valueOf("OGRO"), 0);

        controlador.addDragon("Dragon Rojo", 25, 300);
        controlador.addBosque("Bosque del Ogro", 10, 1, 1);
        controlador.addMonstruoBosque(1, 2);
        controlador.addMonstruoBosque(1, 3);


        System.out.println("=== Menu ===");
        System.out.println("Ingrese 1 para añadir un mago");
        System.out.println("Ingrese 2 para añadir un monstruo");
        System.out.println("Ingrese 3 para añadir un dragón");
        System.out.println("Ingrese 4 para añadir un bosque");

        System.out.println("Ingrese 5 para añadir un hechizo a un Mago");
        System.out.println("Ingrese 6 para añadir montruos a un bosque");
        System.out.println("Ingresa 7 para ver las entidades");
        System.out.println("Ingrese 8 para modificar/eliminar entidades");
        System.out.println("Ingrese 9 para jugar");
        System.out.println("Ingrese 10 para salir");

        System.out.print("Entrada: ");

        Scanner scanner = new Scanner(System.in);
        int entrada = Integer.parseInt(scanner.nextLine());

        while (entrada != 10) {

            switch (entrada) {
                case 1:
                    System.out.println("Se procedera a crear un nuevo Mago: ");

                    System.out.print("Ingrese el nombre del mago: ");
                    String nombreMago = scanner.nextLine();

                    System.out.print("Ingrese los puntos de vida del mago: ");
                    int vidaMago = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese el nivel de magia del mago: ");
                    int nivelMagia = Integer.parseInt(scanner.nextLine());

                    controlador.addMago(nombreMago, vidaMago, nivelMagia);
                    break;

                case 2:
                    System.out.println("Se procedera a crear un nuevo monstruo");

                    System.out.print("Ingrese el nombre del monstruo: ");
                    String nombreMonstruo = scanner.nextLine();

                    System.out.print("Ingrese los puntos de vida del monstruo: ");
                    int vidaMonstruo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese el tipo de monstruo (OGRO, TROLL, ESPECTRO): ");
                    TipoMonstruo tipo = TipoMonstruo.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Ingrese la fuerza del monstruo: ");
                    int fuerza = Integer.parseInt(scanner.nextLine());

                    controlador.addMonstruo(nombreMonstruo, vidaMonstruo, tipo, fuerza);
                    break;

                case 3:
                    System.out.println("Se procedera a crear un nuevo dragon");

                    System.out.print("Ingrese el nombre del dragon: ");
                    String nombreDragon = scanner.nextLine();

                    System.out.print("Ingrese la intensidad del fuego del dragon: ");
                    int intensidadFuego = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese la resistencia (vida) del dragon: ");
                    int resistencia = Integer.parseInt(scanner.nextLine());

                    controlador.addDragon(nombreDragon, intensidadFuego, resistencia);
                    break;

                case 4:
                    System.out.println("Se procedera a crear un nuevo Bosque");

                    System.out.print("Ingrese el nombre del bosque: ");
                    String nombreBosque = scanner.nextLine();

                    System.out.print("Ingrese el nivel de peligro de bosque: ");
                    int nivelDePeligro = Integer.parseInt(scanner.nextLine());

                    controlador.mostrarMonstruos();

                    System.out.print("Ingrese el id del monstruo jefe: ");
                    int idMonstruoJefe = Integer.parseInt(scanner.nextLine());

                    controlador.mostrarDragones();
                    System.out.print("Ingrese el id del Dragon que habita el bosque: ");
                    int idDragon = Integer.parseInt(scanner.nextLine());

                    controlador.addBosque(nombreBosque, nivelDePeligro, idMonstruoJefe, idDragon);
                    break;

                case 5:
                    System.out.println("Ingrese el id del hechizo que desea añadir al mago");
                    System.out.println("Los conjuros disponibles son: ");
                    controlador.mostrarHechizos();
                    
                    System.out.print("id del hechizo: ");
                    int idHechizo = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese el id del Mago");
                    System.out.println("Lista de magos disponibles:");
                    controlador.mostrarMago();
                    int idMago = Integer.parseInt(scanner.nextLine());

                    controlador.addHechizoMago(idMago, idHechizo);
                    break;

                case 6:
                    controlador.mostrarBosques();
                    System.out.println("Ingrese el id del bosque al que desea añadir monstruos");
                    System.out.print("Id del bosque: ");
                    int idBosque = Integer.parseInt(scanner.nextLine());

                    controlador.mostrarMonstruos();
                    System.out.println("Ingrese el id del monstruo que desea añadir al bosque");
                    System.out.print("Id del monstruo: ");

                    int idMonstruo = Integer.parseInt(scanner.nextLine());

                    controlador.addMonstruoBosque(idBosque, idMonstruo);
                    break;

                case 7:
                    System.out.println("Ingrese 1 para mostrar todos los Magos");
                    System.out.println("Ingrese 2 para mostrar todos los Mostruos");
                    System.out.println("Ingrese 3 para mostrar todos los Dragones");
                    System.out.println("Ingrese 4 para mostrar todos los Bosques");
                    System.out.println("Ingrese 5 para mostrar todos los Hechizos");
                    System.out.println("Ingrese 6 para salir");
                    System.out.print("Entrada: ");
                    entrada = Integer.parseInt(scanner.nextLine());

                    while (entrada != 6) {
                        switch (entrada) {
                            case 1:
                                controlador.mostrarMago();
                                break;

                            case 2:

                                controlador.mostrarMonstruos();
                                break;

                            case 3:
                                controlador.mostrarDragones();
                                break;

                            case 4:
                                controlador.mostrarBosques();
                                break;

                            case 5:
                                controlador.mostrarHechizos();
                                break;

                            case 6:
                                break;

                            default:
                                System.out.println("Opción inválida");
                                break;
                        }

                        System.out.println("Ingrese 1 para mostrar todos los Magos");
                        System.out.println("Ingrese 2 para mostrar todos los Mostruos");
                        System.out.println("Ingrese 3 para mostrar todos los Dragones");
                        System.out.println("Ingrese 4 para mostrar todos los Bosques");
                        System.out.println("Ingrese 5 para mostrar todos los Hechizos");
                        System.out.println("Ingrese 6 para salir");
                        System.out.print("Entrada: ");
                        entrada = Integer.parseInt(scanner.nextLine());
                    }
                    break;

                case 8:
                    System.out.println("=== Modificar o Eliminar ===");
                    System.out.println("Ingrese 1 para Mago");
                    System.out.println("Ingrese 2 para Monstruo");
                    System.out.println("Ingrese 3 para Dragón");
                    System.out.println("Ingrese 4 para Bosque");
                    System.out.println("Ingrese 5 para salir");
                    System.out.print("Entrada: ");
                    entrada = Integer.parseInt(scanner.nextLine());

                    while (entrada != 5) {

                        System.out.println("Ingrese 1 para modificar");
                        System.out.println("Ingrese 2 para borrar");
                        System.out.println("Ingrese 3 para salir");
                        System.out.print("Entrada: ");
                        int accion = Integer.parseInt(scanner.nextLine());

                        if (accion != 3) {
                            switch (entrada) {

                                case 1:
                                    controlador.mostrarMago();

                                    System.out.print("Id del mago: ");
                                    int idMagoModificar = Integer.parseInt(scanner.nextLine());

                                    if (accion == 1) {
                                        System.out.print("Nuevo nombre: ");
                                        String nuevoNombreMago = scanner.nextLine();

                                        System.out.print("Nueva vida: ");
                                        int nuevaVidaMago = Integer.parseInt(scanner.nextLine());

                                        System.out.print("Nuevo nivel de magia: ");
                                        int nuevoNivelMagia = Integer.parseInt(scanner.nextLine());

                                        controlador.modificarMago(idMagoModificar, nuevoNombreMago, nuevaVidaMago, nuevoNivelMagia);
                                    } else if (accion == 2) {
                                        controlador.borrarMago(idMagoModificar);
                                    }
                                    break;

                                case 2: 
                                    controlador.mostrarMonstruos();

                                    System.out.print("Id del monstruo: ");
                                    int idMonstruoModificar = Integer.parseInt(scanner.nextLine());

                                    if (accion == 1) {
                                        System.out.print("Nuevo nombre: ");
                                        String nuevoNombreMonstruo = scanner.nextLine();

                                        System.out.print("Nueva vida: ");
                                        int nuevaVidaMonstruo = Integer.parseInt(scanner.nextLine());

                                        System.out.print("Nuevo tipo (OGRO, TROLL, ESPECTRO): ");
                                        TipoMonstruo nuevoTipo = TipoMonstruo.valueOf(scanner.nextLine().toUpperCase());

                                        System.out.print("Nueva fuerza: ");
                                        int nuevaFuerza = Integer.parseInt(scanner.nextLine());

                                        controlador.modificarMonstruo(idMonstruoModificar, nuevoNombreMonstruo,
                                                nuevaVidaMonstruo, nuevoTipo, nuevaFuerza);
                                    } else if (accion == 2) {
                                        controlador.borrarMonstruo(idMonstruoModificar);
                                    }
                                    break;

                                case 3: 
                                    controlador.mostrarDragones();

                                    System.out.print("Id del dragón: ");
                                    int idDragonModificar = Integer.parseInt(scanner.nextLine());

                                    if (accion == 1) {
                                        System.out.print("Nuevo nombre: ");
                                        String nuevoNombreDragon = scanner.nextLine();

                                        System.out.print("Nueva intensidad de fuego: ");
                                        int nuevaIntFuego = Integer.parseInt(scanner.nextLine());

                                        System.out.print("Nueva resistencia: ");
                                        int nuevaRes = Integer.parseInt(scanner.nextLine());

                                        controlador.modificarDragon(idDragonModificar, nuevoNombreDragon, nuevaIntFuego, nuevaRes);
                                    } else if (accion == 2) {
                                        controlador.borrarDragon(idDragonModificar);
                                    }
                                    break;

                                case 4: 
                                    controlador.mostrarBosques();

                                    System.out.print("Id del bosque: ");
                                    int idBosqueModificar = Integer.parseInt(scanner.nextLine());

                                    if (accion == 1) {
                                        System.out.print("Nuevo nombre: ");
                                        String nuevoNombreBosque = scanner.nextLine();

                                        System.out.print("Nuevo nivel de peligro: ");
                                        int nuevoNivel = Integer.parseInt(scanner.nextLine());

                                        controlador.mostrarMonstruos();
                                        System.out.print("Nuevo id de monstruo jefe: ");
                                        int nuevoMonstruoJefe = Integer.parseInt(scanner.nextLine());

                                        controlador.mostrarDragones();
                                        System.out.print("Nuevo id de dragón: ");
                                        int nuevoDragon = Integer.parseInt(scanner.nextLine());

                                        controlador.modificarBosque(idBosqueModificar, nuevoNombreBosque, nuevoNivel, nuevoMonstruoJefe, nuevoDragon);
                                    } else if (accion == 2) {
                                        controlador.borrarBosque(idBosqueModificar);
                                    }
                                    break;
                                    
                                default:
                                    System.out.println("Opción inválida");
                            }
                        } 

                        System.out.println("\n=== Modificar/Eliminar Entidades ===");
                        System.out.println("Ingrese 1 para Mago");
                        System.out.println("Ingrese 2 para Monstruo");
                        System.out.println("Ingrese 3 para Dragón");
                        System.out.println("Ingrese 4 para Bosque");
                        System.out.println("Ingrese 5 para salir");
                        System.out.print("Entrada: ");
                        entrada = Integer.parseInt(scanner.nextLine());
                    }
                    break;

                case 9:
                    controlador.mostrarMago();
                    System.out.println("Ingrese la id del mago con el que desea jugar");
                    System.out.print("id del Mago: ");

                    int idMagoJuego = Integer.parseInt(scanner.nextLine());

                    controlador.mostrarBosques();
                    System.out.println("Ingrese la id del bosque al que desea ir");
                    System.out.print("id del bosque: ");

                    int idBosqueJuego = Integer.parseInt(scanner.nextLine());

                    controlador.jugar(idMagoJuego, idBosqueJuego);

                    break;

                case 10:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println("=== Menu ===");
            System.out.println("Ingrese 1 para añadir un mago");
            System.out.println("Ingrese 2 para añadir un monstruo");
            System.out.println("Ingrese 3 para añadir un dragón");
            System.out.println("Ingrese 4 para añadir un bosque");

            System.out.println("Ingrese 5 para añadir un hechizo a un Mago");
            System.out.println("Ingrese 6 para añadir montruos a un bosque");
            System.out.println("Ingresa 7 para ver las entidades");
            System.out.println("Ingrese 8 para modificar/eliminar entidades");
            System.out.println("Ingrese 9 para jugar");
            System.out.println("Ingrese 10 para salir");

            System.out.print("Entrada: ");

            entrada = Integer.parseInt(scanner.nextLine()); // <-- Mover lectura aquí
        }
        scanner.close();
    }
}
