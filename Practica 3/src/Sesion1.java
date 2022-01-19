//Alberto Saiz Serrano-bs0128-IWSIM11.

import java.util.*;

public class Sesion1 {
    public static void main(String [] arg){
        Scanner entrada = new Scanner(System.in);
        Persona persona = null;

        int opcion;
        do{
            opcion = menu(entrada);
            switch (opcion){
                case 1:
                    persona = crearPersona(entrada);
                    break;
                case 2:
                    mostrarPersona(persona);
                    break;
                case 0:
                    System.out.println("\n~~Sesión Finalizada~~");
                default:
                    System.out.println("\nEl número no es válido.");
            }
        }while(opcion != 0);
    }
    public static int menu(Scanner entrada){
        int eleccion;

        System.out.println("\nMENU DE LA PRACTICA 3:");
        System.out.println("\t1.Insertar persona.");
        System.out.println("\t2.Listar persona.");
        System.out.println("\t0. Finalizar programa.");
        System.out.print("Introduzca una opcion del menu: ");
        eleccion = entrada.nextInt();
        entrada.nextLine();

        return eleccion;
    }

    public static Persona crearPersona (Scanner entrada){
        String nombre1;
        char genero1;
        int edad1;
        double altura1, peso1;
        do {
            System.out.print("Nombre: ");
            nombre1 = entrada.nextLine();
        }while(Persona.comprobarNombre(nombre1));

        do{
            System.out.print("Género: ");
            genero1 = entrada.next().charAt(0);
            genero1 = Character.toUpperCase(genero1);
        }while(Persona.comprobarGenero(genero1));
        do{
            System.out.print("Edad: ");
            edad1 = entrada.nextInt();
        }while(Persona.comprobarEdad(edad1));
        do{
            System.out.print("Altura(m): ");
            altura1 = entrada.nextDouble();
        }while(Persona.comprobarAltura(altura1));
        do{
            System.out.print("Peso(kg): ");
            peso1 = entrada.nextDouble();
        }while(Persona.comprobarPeso(peso1));

        return new Persona(nombre1,genero1,edad1,altura1,peso1);
    }

    public static void mostrarPersona (Persona persona){
        if(persona == null){
            System.out.println("\nTienes que crear una persona primero.\n");
        }else{
            System.out.println("\nNombre: " + persona.getNombre());
            System.out.println("Genero: " + persona.getGenero());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Altura(m): " + persona.getAltura());
            System.out.println("Peso(kg): " + persona.getPeso() + "\n");
            System.out.println("Imc: " + persona.getImc());
            System.out.println("Estado: "  + persona.getEstado());
        }
    }
}
