//Alberto Saiz Serrano-IWSIM11-bs0128

import java.util.Scanner;

public class Sesion4 {
    public static void main(String[] arg){
        int numerodemenu;
        do{
            numerodemenu = menu();
            switch(numerodemenu){
                case 1:
                    esPrimoRecursivoMenu();
                    break;
                case 2:
                    escribeNPrimos();
                    break;
                case 3:
                    primosGemelos();
                    break;
                case 4:
                    mostrarSumasDePrimos();
                    break;
                case 5:
                    menuPotencia();
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
        System.out.println("5. Potencia de un número.");
        System.out.println("0. Finalizar la ejecución.");
        do{
            System.out.print("Introduzca un número comprendido entre 0 y 5: ");
            elegiropcion = menu.nextInt();
        }while(elegiropcion < 0 || elegiropcion > 5);
        return elegiropcion;
    }
    public static void primosGemelos(){
        Scanner gemelos = new Scanner(System.in);
        int n1, n2,contador = 1;

        do{
            System.out.print("Introduce un número entre 1 y 500: ");
            n1 = gemelos.nextInt();
        }while(n1 < 1 || n1 > 500);
        do{
            System.out.print("Introduce otro número entre "+ n1 +" y 500: ");
            n2 = gemelos.nextInt();
        }while(n2 < n1 || n2 > 500);
        int x1=n1, x2;
        for(int i = n1; i < n2; i++){
            boolean w = esPrimoRecursivo(i,2);
            if(w){
                x2 = x1;
                x1 = i;
                if(x1 - x2 == 2){
                    System.out.printf("%4d. %4d %4d\n",contador,x2,x1);
                    contador++;
                }
            }
        }
    }
    public static void mostrarSumasDePrimos(){
        Scanner sumas = new Scanner(System.in);
        int n,contador=1;
        do{
            System.out.print("Introduce un numero entre 4 y 1000 que sea par: ");
            n = sumas.nextInt();
        }while((n < 4 || n > 1000) && (n % 2) != 0);

        int x2;
        for(int x1 = 4, base = n; x1 < base; x1++, base--) {
            boolean h = esPrimoRecursivo(x1,2);
            if(h){
                for (int i = 4; i < 1000; i++) {
                    boolean w = esPrimoRecursivo(i,2);
                    if (w) {
                        x2 = i;
                        if (x1 + x2 == n) {
                            System.out.printf("%4d. %4d +%4d =%5d\n", contador, x1, x2,n);
                            contador++;
                        }
                    }
                }
            }
        }
    }
    public static boolean esPrimoRecursivo(int n,int divisor){
        boolean resultado;
        if(n==0 || n==1){
            return false; //No es primo
        }
        else if(n==2){
            return true; //Es primo
        }
        else if( n > 2){
            if(n == divisor){
                return true; //Es primo
            }
            else{
                if(n % divisor == 0){
                    return false; //No es primo
                }

            }
        }
        resultado = esPrimoRecursivo(n,divisor + 1);
        return resultado;
    }
    public static void esPrimoRecursivoMenu(){
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.print("Introduzca un número: ");
            n = scan.nextInt();
        }while(n < 0);
        System.out.println(esPrimoRecursivo(n,2));
    }
    public static void escribeNPrimos(){
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
    public static void menuPotencia(){
        Scanner scan = new Scanner(System.in);
        int base, exponente;
        do{
            System.out.print("Introduce un número entre -100 y 100: ");
            base = scan.nextInt();
        }while(base < -100 || base > 100);
        do{
            System.out.print("Introduce un número entre 0 y 10: ");
            exponente = scan.nextInt();
        }while(exponente < 0 || exponente > 10);
        System.out.println(potencia(base,exponente));
    }
    public static double potencia(int base,int exponente){
        double potencia;
        if(exponente == 0){
            potencia = 1;
        }
        else if(exponente == 1){
            potencia = base;
        }
        else{
            potencia = base * potencia(base,exponente-1);
        }

        return potencia;
    }
}

