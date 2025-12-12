package com.example.Vista;

import java.util.Scanner;

import com.example.Controlador.ControladorDragolandia;
import com.example.Modelo.TipoMonstruo;

public class VistaDragolandia {
    ControladorDragolandia controlador = new ControladorDragolandia();

    public VistaDragolandia() {

        System.out.println("=== Menu ===");
        System.out.println("Ingrese 1 para añadir un mago");
        System.out.println("Ingrese 2 para añadir un monstruo");
        System.out.println("Ingrese 3 para añadir un bosque");
        System.out.println("Ingrese 4 para añadir un dragón");
        System.out.println("Ingrese 5 para añadir montruos a un bosque");
        System.out.println("Ingresa 6 para ver las entidades");
        System.out.println("Ingrese 7 para jugar");
        System.out.println("Ingrese 8 para salir");

        System.out.print("Entrada: ");

        Scanner scanner = new Scanner(System.in);
        int entrada = Integer.parseInt(scanner.nextLine());

        while (entrada != 8) {

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
                    System.out.println("Se procedera a crear un nuevo Bosque");

                    System.out.print("Ingrese el nombre del bosque: ");
                    String nombreBosque = scanner.nextLine();

                    System.out.print("Ingrese el nivel de peligro de bosque: ");
                    int nivelDePeligro = Integer.parseInt(scanner.nextLine());

                    controlador.mostrarMonstruos();

                    System.out.print("Ingrese lel id del monstruo jefe: ");
                    int idMonstruoJefe = Integer.parseInt(scanner.nextLine());

                    controlador.addBosque(nombreBosque, nivelDePeligro, idMonstruoJefe);
                    break;

                case 4:
                    System.out.println("Se procedera a crear un nuevo dragon");

                    System.out.print("Ingrese el nombre del dragon: ");
                    String nombreDragon = scanner.nextLine();

                    System.out.print("Ingrese la intensidad del fuego del dragon: ");
                    int intensidadFuego = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese la resistencia (vida) del dragon: ");
                    int resistencia = Integer.parseInt(scanner.nextLine());

                    controlador.addDragon(nombreDragon, intensidadFuego, resistencia);
                    break;

                case 5:
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
                case 6:
                    System.out.println("Ingrese 1 para mostrar todos los Magos");
                    System.out.println("Ingrese 2 para mostrar todos los Mostruos");
                    System.out.println("Ingrese 3 para mostrar todos los Dragones");
                    System.out.println("Ingrese 4 para mostrar todos los Bosques");
                    System.out.println("Ingrese 5 para salir");
                    System.out.print("Entrada: ");
                    entrada = Integer.parseInt(scanner.nextLine());

                    while (entrada != 5) {
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
                                break;

                            default:
                                System.out.println("Opción inválida");
                                break;
                        }

                        System.out.println("Ingrese 1 para mostrar todos los Magos");
                        System.out.println("Ingrese 2 para mostrar todos los Mostruos");
                        System.out.println("Ingrese 3 para mostrar todos los Dragones");
                        System.out.println("Ingrese 4 para mostrar todos los Bosques");
                        System.out.println("Ingrese 5 para salir");
                        System.out.print("Entrada: ");
                        System.out.print("Entrada: ");
                        entrada = Integer.parseInt(scanner.nextLine());
                    }
                    break;

                case 7:
                    break;

                case 8:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println("=== Menu ===");
            System.out.println("Ingrese 1 para añadir un mago");
            System.out.println("Ingrese 2 para añadir un monstruo");
            System.out.println("Ingrese 3 para añadir un bosque");
            System.out.println("Ingrese 4 para añadir un dragón");
            System.out.println("Ingrese 5 para añadir montruos a un bosque");
            System.out.println("Ingresa 6 para ver las entidades");
            System.out.println("Ingrese 7 para jugar");
            System.out.println("Ingrese 8 para salir");

            System.out.print("Entrada: ");
            entrada = Integer.parseInt(scanner.nextLine()); // <-- Mover lectura aquí
        }

        scanner.close();
    }
}
