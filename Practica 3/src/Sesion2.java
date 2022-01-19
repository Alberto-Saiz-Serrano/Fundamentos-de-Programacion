import java.util.*;

public class Sesion2 {
    public static void main(String [] arg){
        Scanner entrada = new Scanner(System.in);
        ListaPersonas listaPersonas = null;

        int opcion;
        do{
            opcion = Sesion1.menu(entrada);
            switch (opcion){
                case 1:
                    listaPersonas = addPersona(entrada, listaPersonas);
                    break;
                case 2:
                    assert listaPersonas != null;
                    mostrarPersonas(listaPersonas);
                    break;
                case 0:
                    System.out.println("\n~~Sesión Finalizada~~");
                default:
                    System.out.println("El número no es válido.");
            }
        }while(opcion != 0);

    }
    public static ListaPersonas addPersona(Scanner entrada, ListaPersonas listaPersonas){
        if(listaPersonas == null){
            listaPersonas = new ListaPersonas();
        }
        listaPersonas.addPersona(Sesion2.crearPersona(entrada, listaPersonas));

        return listaPersonas;
    }
    public static Persona crearPersona (Scanner entrada, ListaPersonas listaPersonas){
        String nombre1;
        char genero1;
        int edad1;
        double altura1, peso1;
        do {
            System.out.print("Nombre: ");
            nombre1 = entrada.nextLine();
            nombre1 = nombre1.substring(0,1).toUpperCase() + nombre1.substring(1).toLowerCase();
            if(listaPersonas.comprobarRepeticionNombre(nombre1)){
                System.out.println("La persona que quieres añadir ya existe en la lista.\n");
            }
        }while(Persona.comprobarNombre(nombre1) || listaPersonas.comprobarRepeticionNombre(nombre1));
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

    public static void mostrarPersonas(ListaPersonas listaPersonas){
        Persona [] lPers = listaPersonas.getLpersona();
        if(lPers[0] == null){
            System.out.println("\nDebes crear al menos una persona primero.");
        } else{
            listaPersonas.mostrarListaPersonas();
        }
    }
}
