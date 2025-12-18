# Dragolandia

## Introduccion

## Analisis

### Diagrama de clases

classDiagram
direction TB

    Principal --> VistaDragolandia

    VistaDragolandia <--> ControladorDragolandia

    ControladorDragolandia <--> Monstruo
    ControladorDragolandia <--> Mago
    ControladorDragolandia <--> Bosque

    Bosque <|-- Monstruo

    class Principal{

    }

    class VistaDragolandia{

    }

    class ControladorDragolandia{
        +addMago()
        +addMonstruo()
    }

    class Bosque {
	    -int id
	    -String nombre
	    -int nivelPeligro
	    -Monstruo monstruoJefe
        +List<Monstruo> monstruosEnBosque
	    +mostrarJefe()
	    +cambiarMonstruoJefe(Monstruo)
    }

    class Monstruo {
	    -int id
	    -String nombre<<>>
	    -int vida
	    -String tipo
	    -int fuerza

	    +atacar(Mago)
    }

    class Mago {
	    -int id
	    -String nombre
	    -int vida
        -int nivelMagia

        +lanzarHechizo(Monstruo)
    }

    clas tipo{
        
    }

    <<Enumeration>> tipo


## Diseño

#### Diagrama entidad relacion