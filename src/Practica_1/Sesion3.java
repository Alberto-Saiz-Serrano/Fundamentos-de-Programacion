//Alberto Saiz Serrano-IWSIM11-bs0128

package Practica_1;

import java.util.Scanner;

public class Sesion3 {
    public static void main(String[] arg){
        boolean bucle = true;
        int numerodemenu;
        do{
            numerodemenu = menu();
            switch(numerodemenu){
                case 1:
                    System.out.println(numerodemenu);
                    break;
                case 2:
                    System.out.println(numerodemenu);
                    System.out.println(leerNumero());
                    break;
                case 3:
                    System.out.println(numerodemenu);
                    System.out.println(esPrimo());
                    break;
                case 4:
                    System.out.println(numerodemenu);
                    escribePrimos();
                    break;
            }
        }while(numerodemenu != 0);
        System.out.println("Adiós.");
    }
    public static int menu(){
        Scanner menu = new Scanner(System.in);
        int elegiropcion;
        System.out.println("\n1. Comprobar si un número es primo.");
        System.out.println("2. Escribir los n primeros numeros primos.");
        System.out.println("3. Escribir números primos gemelos entre dos valores.");
        System.out.println("4. Número par como suma de dos primos.");
        System.out.println("0. Finalizar la ejecución.");
        do{
            System.out.print("Introduzca un número comprendido entre 0 y 4: ");
            elegiropcion = menu.nextInt();
        }while(elegiropcion < 0 || elegiropcion > 4);
        return elegiropcion;
    }
    public static int leerNumero(){
        Scanner leer = new Scanner(System.in);
        int n1,n2;
        do{
            System.out.print("Introduzca un numero entero: ");
            n1 = leer.nextInt();
        }while(n1 < 0);
        do{
            System.out.print("Introduzca otro numero entero mayor que el primero: ");
            n2 = leer.nextInt();
        }while(n2 < n1);
        return n2;
    }
    public static boolean esPrimo(){
        int numero;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Introduce un número entre 0 y 1000: ");
            numero = scan.nextInt();
        }while (numero < 1 || numero > 1000);

        if (numero == 1) {
            return false;
        }
        int contador = 0;
        for (int x = 2; x <= numero && contador != 3; x++) {
            if (numero % x == 0) {
                contador++;
            }
        }
        if(contador < 2) {
            return true;
        } else {
            return false;
        }
    }
    public static void escribePrimos(){
        Scanner primeros = new Scanner(System.in);
        int numero1,contadorprint=0;
        do{
            System.out.print("Introduce un número entre 5 y 20: ");
            numero1 = primeros.nextInt();
        }while (numero1 < 5 || numero1 > 20);
        int contadorprimos = 0, n, k = 2;
        while (k < 73 && contadorprimos != numero1) {
            n = k;
            int contador1 = 0;
            int j = 2;
            while (j <= n && contador1 != 3) {
                if (n % j == 0) {
                    contador1++;
                }
                j++;
            }
            if (contador1 < 2) {
                contadorprimos++;
                if (contadorprint < 4) {
                    System.out.printf("%8d", n);
                    contadorprint++;
                } else {
                    System.out.printf("\n%8d", n);
                    contadorprint = 1;
                }
            }
            k++;
        }
    }
}
