import java.io.*;
import java.util.*;

public class Sesion3 {
    public static void main(String[] arg) {
        Scanner entrada = new Scanner(System.in);
        ListaPersonas listaPersonas = null;
        int option;
        do {
            option = menu(entrada);
            switch (option) {
                case 1:
                    listaPersonas = Sesion2.addPersona(entrada, listaPersonas);
                    break;
                case 2:
                    assert listaPersonas != null;
                    Sesion2.mostrarPersonas(listaPersonas);
                    break;
                case 3:
                    buscarPersona(entrada, listaPersonas);
                    break;
                case 4:
                    eliminarPersona(entrada, listaPersonas);
                    break;
                case 5:
                    if (listaPersonas != null) {
                        escribirlPersonaFicheroTexto(entrada, listaPersonas);
                    }
                    break;
                case 6:
                    listaPersonas = leerlPersonaFichero_txt(entrada);
                    break;
                case 0:
                    System.out.println("\n~~Sesión Finalizada~~");
                    break;
                default:
                    System.out.println("El número no es válido.");
            }
        } while (option != 0);
    }

    public static int menu(Scanner entrada) {
        int election;

        System.out.println("\nMENU DE LA PRACTICA 3:");
        System.out.println("\t1.Insertar persona.");
        System.out.println("\t2.Listar persona.");
        System.out.println("\t3.Buscar persona.");
        System.out.println("\t4.Eliminar persona.");
        System.out.println("\t5.Escribir personas a fichero csv.");
        System.out.println("\t6.Leer personas desde fichero csv.");
        System.out.println("\t0. Finalizar programa.");
        System.out.print("Introduzca una opcion del menu: ");
        election = entrada.nextInt();
        entrada.nextLine();

        return election;
    }

    public static void buscarPersona(Scanner entrada, ListaPersonas listaPersonas) {
        String nombre;
        Persona persona;
        if (listaPersonas == null) {
            System.out.println("\nDebe crear una persona primero.");
        } else {
            System.out.print("Introduce el nombre de la persona que buscas: ");
            nombre = entrada.next();
            persona = listaPersonas.getPersona(nombre);
            if (persona != null) {
                Sesion1.mostrarPersona(persona);
            } else {
                System.out.println("\nNo existe la persona que buscas.");
            }
        }
    }

    public static void eliminarPersona(Scanner entrada, ListaPersonas listaPersonas) {
        String nombre;
        Persona persona;
        if (listaPersonas == null) {
            System.out.println("\nDebe crear una persona primero");
        } else {
            System.out.print("Introduce el nombre de la persona que deseas eliminar: ");
            nombre = entrada.next();
            persona = listaPersonas.getPersona(nombre);
            if (persona != null) {
                listaPersonas.eliminarListaPersonas(nombre);
                System.out.println("Se ha eliminado a " + nombre + "correctamente.");
            } else {
                System.out.println("\nNo existe la persona que deseas eliminar.");
            }
        }
    }

    public static void escribirlPersonaFicheroTexto(Scanner entrada, ListaPersonas lPersona) {
        BufferedWriter bw = null;
        String nombreArchivo = pedirNombre(entrada);
        try {
            File archivo = new File(nombreArchivo);
            bw = new BufferedWriter(new FileWriter(archivo));
            for (int x = 0; x < lPersona.getNumPersona(); x++) {
                bw.write(lPersona.getPersona(x).toStringFichero());
            }
            System.out.println("Se ha creado el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static String pedirNombre(Scanner entrada) {
        int option;
        String nombreArchivo = null;
        System.out.println("¿Quieres ponerle nombre al archivo?");
        System.out.println("(1) Sí.");
        System.out.println("(2) No.(Se guardara como Personas.csv)");
        option = entrada.nextInt();
        entrada.nextLine();
        switch (option) {
            case 1:
                System.out.print("Introduce como quieres llamar al archivo: ");
                nombreArchivo = entrada.nextLine();
                if (!(nombreArchivo.contains(".csv"))) {
                    nombreArchivo += ".csv";
                }
                break;
            case 2:
                nombreArchivo = "Personas.csv";
                break;
            default:
                System.out.println("Introduce un número válido");
        }
        return nombreArchivo;
    }

    public static ListaPersonas leerlPersonaFichero_txt(Scanner entrada) { //lee el fichero donde muestra las sucursales disponibles
        ListaPersonas lPersonasFichero = new ListaPersonas();
        String[] split;
        String nombreArchivo = pedirNombreLeerFichero(entrada);
        FileReader fr = null;
        BufferedReader br;
        try {
            File listaPersonasFichero = new File(nombreArchivo);
            fr = new FileReader(listaPersonasFichero);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.replace(",", ".");
                split = linea.split(";");
                lPersonasFichero.addPersona(agregarVariablesFichero(split));
            }
            System.out.println("Se han añadido correctamente.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return lPersonasFichero;
    }

    public static String pedirNombreLeerFichero(Scanner entrada){
        System.out.print("Introduce el nombre del fichero csv: ");
        String nombreArchivo = entrada.nextLine();
        if (!(nombreArchivo.contains(".csv"))) {
            nombreArchivo += ".csv";
        }
        return nombreArchivo;
    }

    public static Persona agregarVariablesFichero(String[] split) {
        String nombre = split[0];
        char genero = split[1].charAt(0);
        int edad = Integer.parseInt(split[2]);
        double altura = Double.parseDouble(split[3]);
        double peso = Double.parseDouble(split[4]);

        return new Persona(nombre, genero, edad, altura, peso);
    }
}
