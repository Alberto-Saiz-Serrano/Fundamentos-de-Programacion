//Alberto Saiz Serrano-IWSIM11-bs0128

package Practica_1;

import java.util.Scanner;

public class Sesion2 {
    public static void main(String[] arg) {
        int numero;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Introduce un número entre 0 y 1000: ");
            numero = scan.nextInt();
        } while (numero < 0 || numero > 1000);
        if (numero == 0 || numero == 1) {
            System.out.println("El " + numero + " no es un número primo");
        }
        int contador = 0, x = 1;
        while (x <= numero && contador != 3) {
            if (numero % x == 0) {
                contador++;
            }
            x++;
        }
        if (contador <= 2) {
            System.out.println("El " + numero + " es un número primo");
        } else {
            System.out.println("El " + numero + " no es un número primo");
        }


        int numero1;
        do {
            System.out.print("\nIntroduce un número entre 5 y 20: ");
            numero1 = scan.nextInt();
        } while (numero1 < 5 || numero1 > 20);

        int contadorprimos = 0, n, k = 2, contadorprint=0;
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
