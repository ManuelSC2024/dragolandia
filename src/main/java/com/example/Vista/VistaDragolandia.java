package com.example.Vista;

import java.util.Scanner;

import com.example.Controlador.ControladorDragolandia;
import com.example.Modelo.TipoMonstruo;

public class VistaDragolandia {
    ControladorDragolandia controlador = new ControladorDragolandia();

    public VistaDragolandia() {

        Scanner scanner = new Scanner(System.in);
        int entrada = Integer.parseInt(scanner.nextLine());

        while (entrada != 5) {

            System.out.println("=== Menu ===");
            System.out.println("Ingrese 1 para añadir un mago");
            System.out.println("Ingrese 2 para añadir un monstruo");
            System.out.println("Ingrese 3 para añadir un bosque");
            System.out.println("Ingrese 4 para añadir montruos a un bosque");
            System.out.println("ingrese 5 para jugar");
            System.out.println("6 para salir");

            switch (entrada) {

                case 1:
                    System.out.println("Se procedera a crear un nuevo Mago");

                    System.out.println("Ingrese el nombre del mago");
                    String nombreMago = scanner.nextLine();

                    System.out.println("Ingrese los puntos de vida del mago");
                    int vidaMago = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese el nivel de magia del mago");
                    int nivelMagia = Integer.parseInt(scanner.nextLine());

                    controlador.addMago(nombreMago, vidaMago, nivelMagia);
                    break;

                case 2:
                    System.out.println("Se procedera a crear un nuevo monstruo");

                    System.out.println("Ingrese el nombre del monstruo");
                    String nombreMonster = scanner.nextLine();

                    System.out.println("Ingrese los puntos de vida del monstruo");
                    int vidaMonster = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese el tipo de monstruo (OGRO, TROLL, ESPECTRO)");
                    TipoMonstruo tipo = TipoMonstruo.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Ingrese la fuerza del monstruo");
                    int fuerza = Integer.parseInt(scanner.nextLine());

                    controlador.addMonstruo(nombreMonster, vidaMonster, tipo, fuerza);
                    break;

                case 3:
                    System.out.println("Se procedera a crear un nuevo Bosque");

                    System.out.println("Ingrese el nombre del monstruo");
                    String nombreBosque = scanner.nextLine();

                    System.out.println("Ingrese los puntos de vida del monstruo");
                    int nivelDePeligro = Integer.parseInt(scanner.nextLine());

                    controlador.addBosque(nombreBosque, nivelDePeligro, null);
                    break;

                case 4:
                    controlador.mostrarBosques();
                    System.out.println("Ingrese el id del bosque al que desea añadir monstruos");
                    int idBosque = Integer.parseInt(scanner.nextLine());

                    controlador.mostrarMonstruos();
                    System.out.println("Ingrese el id del monstruo que desea añadir al bosque");
                    int idMonstruo = Integer.parseInt(scanner.nextLine());

                    controlador.addMonstruoBosque(idBosque, idMonstruo);
                    break;

                case 5:
                    break;
                    
                case 6:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

            entrada = Integer.parseInt(scanner.nextLine()); // <-- Mover lectura aquí
        }

        scanner.close();
    }
}
