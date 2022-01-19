//Alberto Saiz Serrano-IWSIM11-bs0128

import java.util.Scanner;

public class Sesion1 {
    public static void main(String[] agr){
        System.out.println("1. Comprobar si un número es primo.");
        System.out.println("2. Escribir los n primeros números primos.");
        System.out.println("3. Escribir números primos gemelos entre dos valores.");
        System.out.println("4. Número par como suma de dos primos.");
        System.out.println("0. Finalizar la ejecución.");

        int option;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nIntroduzca la opción deseada: ");
        option = scan.nextInt();
        if (option == 1) {
            System.out.println("Ha elegido la opción 1");
        }
        else if (option == 2) {
            System.out.println("Ha elegido la opción 2");
        }
        else if (option == 3) {
            System.out.println("Ha elegido la opción 3");
        }
        else if (option == 4) {
            System.out.println("Ha elegido la opción 4");
        }
        else if (option == 0) {
            System.out.println("Ha elegido la opción 0");
        }
        else{
                System.out.println("Opción incorrecta");
        }


        int entero;
        System.out.print("\nIntroduzca un numero entre 0 y 1000: ");
        entero = scan.nextInt();
        if(entero < 0 || entero > 1000){
            System.out.println("El número que ha introducido no es válido");
        }
        else{
            System.out.println("El número que ha elegido es el " + entero);
        }


        int n1, n2, div;
        do{
            System.out.print("\nIntroduce un número entero: ");
            n1 = scan.nextInt();
        }while(n1 < 0);
        do {
            System.out.print("Introduce otro número entero: ");
            n2 = scan.nextInt();
        }while(n2 < 0);

        if(n1 > n2){
            System.out.println("El segundo número no es mayor que el primero.");
        }
        else if(n2 % n1 != 0){
            System.out.println("El segundo número no es divisible entre el primero.");
        }
        else{
            div = n2/n1;
            System.out.println("Su division es: " + div);
        }
    }
}
