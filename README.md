# Dragolandia

## Introduccion

## Analisis

### Diagrama de clases

```mermaid
classDiagram
direction TB

    Principal --> VistaDragolandia

    VistaDragolandia <--> ControladorDragolandia

    ControladorDragolandia --> ControladorMago : usa
    ControladorDragolandia --> ControladorMonstruo : usa
    ControladorDragolandia --> ControladorDragon : usa
    ControladorDragolandia --> ControladorBosque : usa

    ControladorMago --> Mago : gestiona
    ControladorMonstruo --> Monstruo : gestiona
    ControladorDragon --> Dragon : gestiona
    ControladorBosque --> Bosque : gestiona

    Bosque --> Monstruo : tiene jefe
    Bosque --> Dragon : tiene
    Bosque --> Monstruo : contiene
    
    Mago --> Hechizo : conoce
    
    Hechizo <|-- BolaFuego
    Hechizo <|-- BolaNieve
    Hechizo <|-- Rayo
    

    class Principal{

    }

    class VistaDragolandia{

    }

    class ControladorDragolandia{
        -ControladorMago controladorMago
        -ControladorMonstruo controladorMonstruo
        -ControladorDragon controladorDragon
        -ControladorBosque controladorBosque
        +addMago(String, int, int)
        +addMonstruo(String, int, TipoMonstruo, int)
        +addDragon(String, int, int)
        +addBosque(String, int, int, int)
        +addMonstruoBosque(int, int)
        +mostrarMago()
        +mostrarMonstruos()
        +mostrarDragones()
        +mostrarBosques()
        +modificarMago(int, String, int, int)
        +modificarMonstruo(int, String, int, TipoMonstruo, int)
        +modificarDragon(int, String, int, int)
        +modificarBosque(int, String, int, int, int)
        +borrarMago(int)
        +borrarMonstruo(int)
        +borrarDragon(int)
        +borrarBosque(int)
        +jugar(int, int)
    }

    class ControladorMago{
        -SessionFactory factory
        +addMago(String, int, int)
        +mostrarMago()
        +modificarMago(int, String, int, int)
        +borrarMago(int)
    }

    class ControladorMonstruo{
        -SessionFactory factory
        +addMonstruo(String, int, TipoMonstruo, int)
        +mostrarMonstruos()
        +modificarMonstruo(int, String, int, TipoMonstruo, int)
        +borrarMonstruo(int)
    }

    class ControladorDragon{
        -SessionFactory factory
        +addDragon(String, int, int)
        +mostrarDragones()
        +modificarDragon(int, String, int, int)
        +borrarDragon(int)
    }

    class ControladorBosque{
        -SessionFactory factory
        +addBosque(String, int, int, int)
        +addMonstruoBosque(int, int)
        +mostrarBosques()
        +modificarBosque(int, String, int, int, int)
        +borrarBosque(int)
    }

    class Bosque {
	    -int id
	    -String nombre
	    -int nivelPeligro
	    -Monstruo monstruoJefe
	    -Dragon dragon
        -List<Monstruo> monstruosEnBosque
	    +mostrarJefe()
	    +cambiarMonstruoJefe(Monstruo)
	    +addMonstruo(Monstruo)
    }

    class Dragon {
        -int id
        -String nombre
        -int intensidadFuego
        -int resistencia
        +exhalar(Monstruo)
    }

    class Monstruo {
	    -int id
	    -String nombre
	    -int vida
	    -TipoMonstruo tipo
	    -int fuerza
	    +atacar(Mago)
    }

    class Mago {
	    -int id
	    -String nombre
	    -int vida
        -int nivelMagia
        -List<Hechizo> conjuros
        +lanzarHechizo(Monstruo)
        +addconjuro(Hechizo)
    }
    
    class Hechizo {
        -int id
        #String nombre
        +efecto(List<Monstruo>, int)*
        +efecto(Monstruo, int)*
        +efecto(Monstruo)*
    }
    
    class BolaFuego {
        +BolaFuego()
        +efecto(List<Monstruo>, int)
    }
    
    class BolaNieve {
        +BolaNieve()
        +efecto(Monstruo)
    }
    
    class Rayo {
        +Rayo()
        +efecto(Monstruo, int)
    }
```

## Diseño

#### Diagrama entidad relacion

```mermaid
erDiagram

    MONSTRUO }o--|| TIPO_MONSTRUO : "es de tipo"

    BOSQUE ||--o| MONSTRUO : "Es jefe"
    BOSQUE ||--o{ MONSTRUO : "Esta"
    BOSQUE ||--o| DRAGON : "Esta"
    
    MAGO ||--o{ HECHIZO : "conoce"

    HECHIZO ||--|{ BOLA_FUEGO : "Hereda"
    HECHIZO ||--|{ BOLA_NIEVE : "Hereda"
    HECHIZO ||--|{ RAYO : "Hereda"
    
    BOSQUE {
        int id PK
        string nombre
        int nivelPeligro
        int monstruoJefe_id FK
        int dragon_id FK
    }
    
    DRAGON {
        int id PK
        string nombre
        int intensidadFuego
        int resistencia
    }
    
    MAGO {
        int id PK
        string nombre
        int vida
        int nivelMagia
    }
    
    MONSTRUO {
        int id PK
        string nombre
        int vida
        string tipo
        int fuerza
    }
    
    TIPO_MONSTRUO {
        string tipo
    }
    
    HECHIZO {
        int id PK
        string nombre
    }
    
    BOLA_FUEGO {
        int id PK
    }
    
    BOLA_NIEVE {
        int id PK
    }
    
    RAYO {
        int id PK
    }
```