//Alberto Saiz Serrano-IWSIM11-bs0128

package Practica_2;

import java.util.Scanner;

public class Sudoku {

	public static final int DIMENSION_TABLERO = 9;
	public static final int DIMENSION_CAJA = 3;

	public static void main(String[] args) {
		Sudoku.ejecutar();
	}

	public static void ejecutar() {
		int[][] celdas = new int[DIMENSION_TABLERO][DIMENSION_TABLERO];
		int ocupacion;
		ocupacion = Sudoku.iniciar(celdas);
		Sudoku.jugar(celdas, ocupacion);
	}

	public static int iniciar(int[][] celdas) {
		int ocupacion = 0;
		for (int fila = 0; fila < DIMENSION_TABLERO; fila++) {
			for (int columna = 0; columna < DIMENSION_TABLERO; columna++) {
				celdas[fila][columna] = 0;
			}
		}

		celdas[0][0] = 5;
		ocupacion++;
		celdas[0][1] = 3;
		ocupacion++;
		celdas[0][4] = 7;
		ocupacion++;
		celdas[1][0] = 6;
		ocupacion++;
		celdas[1][3] = 1;
		ocupacion++;
		celdas[1][4] = 9;
		ocupacion++;
		celdas[1][5] = 5;
		ocupacion++;
		celdas[2][1] = 9;
		ocupacion++;
		celdas[2][2] = 8;
		ocupacion++;
		celdas[2][7] = 6;
		ocupacion++;
		celdas[3][0] = 8;
		ocupacion++;
		celdas[3][4] = 6;
		ocupacion++;
		celdas[3][8] = 3;
		ocupacion++;
		celdas[4][0] = 4;
		ocupacion++;
		celdas[4][3] = 8;
		ocupacion++;
		celdas[4][5] = 3;
		ocupacion++;
		celdas[4][8] = 1;
		ocupacion++;
		celdas[5][0] = 7;
		ocupacion++;
		celdas[5][4] = 2;
		ocupacion++;
		celdas[5][8] = 6;
		ocupacion++;
		celdas[6][1] = 6;
		ocupacion++;
		celdas[6][6] = 2;
		ocupacion++;
		celdas[6][7] = 8;
		ocupacion++;
		celdas[7][3] = 4;
		ocupacion++;
		celdas[7][4] = 1;
		ocupacion++;
		celdas[7][5] = 9;
		ocupacion++;
		celdas[7][8] = 5;
		ocupacion++;
		celdas[8][4] = 8;
		ocupacion++;
		celdas[8][7] = 7;
		ocupacion++;
		celdas[8][8] = 9;
		ocupacion++;

		return ocupacion;
	}


	public static void jugar(int[][] celdas, int ocupacion) {
		Sudoku.mostrar(celdas);
		while (ocupacion != DIMENSION_TABLERO * DIMENSION_TABLERO) {
			System.out.print("Introduzca una fila [1.." + DIMENSION_TABLERO + "]: ");
			int fila = Sudoku.leerEntero(1, DIMENSION_TABLERO);
			System.out.print("Introduzca una columna [1.." + DIMENSION_TABLERO + "]: ");
			int columna = Sudoku.leerEntero(1, DIMENSION_TABLERO);
			System.out.print("Introduzca un numero [1.." + DIMENSION_TABLERO + "]: ");
			int numero = Sudoku.leerEntero(1, DIMENSION_TABLERO);
			if (Sudoku.estaOcupada(celdas, fila, columna)) {
				System.out.println("ERROR: La celda [" + fila + "][" + columna + "] esta ocupada");
			} else if (Sudoku.estaEnFila(celdas, fila, numero)) {
				System.out.println("ERROR: El numero " + numero + " ya esta en la fila " + fila);
			} else if (Sudoku.estaEnColumna(celdas, columna, numero)) {
				System.out.println("ERROR: El numero " + numero + " ya esta en la columna " + columna);
			} else if (Sudoku.estaEnCaja(celdas, fila, columna, numero)) {
				System.out.println("ERROR: El numero " + numero + " ya esta en la caja "
						+ "de la celda [" + fila + "][" + columna + "]");
			} else {
				celdas[fila - 1][columna - 1] = numero;
				ocupacion++;
			}
			Sudoku.mostrar(celdas);
		}
		System.out.println("SUDOKU RESUELTO - ENHORABUENA");
	}

	public static int leerEntero(int minimo, int maximo) {
		Scanner scanner = new Scanner(System.in);
		int entero;
		do {
			entero = scanner.nextInt();
			scanner.nextLine();
		} while (entero < minimo || entero > maximo);
		return entero;
	}

	public static void mostrarLinea() {
		final int CAJAS = DIMENSION_TABLERO / DIMENSION_CAJA;
		final int GUIONES = 1 + 2 * (DIMENSION_CAJA + 1) * CAJAS;
		for (int i = 0; i < GUIONES; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	// TODO 1 ------------------------------------------------------------------------------------------
	public static void mostrar(int[][] celdas) {
        for(int i = 0; i < DIMENSION_TABLERO; i++){
            if(i % DIMENSION_CAJA == 0){
                Sudoku.mostrarLinea();
            }
            for(int j = 0; j < DIMENSION_TABLERO; j++){
                if(j % DIMENSION_CAJA == 0){
                    System.out.print("| ");
                }
                if(celdas[i][j] == 0){
                    System.out.print("- ");
                }else{
                    System.out.print(celdas[i][j] + " ");
                }
            }
			System.out.println("|");
        }
		Sudoku.mostrarLinea();
    }

	// TODO 2 ------------------------------------------------------------------------------------------
	public static boolean estaOcupada(int[][] celdas, int fila, int columna) {
		return celdas[fila - 1][columna - 1] != 0;
	}

	// TODO 3 ------------------------------------------------------------------------------------------
	public static boolean estaEnFila(int[][] celdas, int fila, int numero) {
		boolean estaFila = false;
		int i = 0;
		while( i < DIMENSION_TABLERO && !estaFila){
			if(celdas[fila - 1][i] == numero){
				estaFila = true;
			}
			i++;
		}
		return estaFila;
	}

	// TODO 4 ------------------------------------------------------------------------------------------
	public static boolean estaEnColumna(int[][] celdas, int columna, int numero) {
		boolean estaColumna = false;
		int i = 0;
		while( i < DIMENSION_TABLERO && !estaColumna){
			if (celdas[i][columna - 1] == numero) {
				estaColumna = true;
			}
			i++;
		}
		return estaColumna;
	}

	// TODO 5 ------------------------------------------------------------------------------------------
	public static boolean estaEnCaja(int[][] celdas, int fila, int columna, int numero) {
		/* OTRA FORMA DE HACERLO
		do{
			fila--;
		}while(fila % DIMENSION_CAJA != 0);

		do{
			columna--;
		}while(columna % DIMENSION_CAJA != 0);

		fila++;
		columna++;
		*/
		
		fila = ((fila - 1)/DIMENSION_CAJA)*DIMENSION_CAJA;
		fila++;

		columna = ((columna - 1)/DIMENSION_CAJA)*DIMENSION_CAJA;
		columna++;

		boolean estaCaja = false;
		int i = fila;
		int j = columna;

		while( i < (fila + DIMENSION_CAJA) && !estaCaja){
			while( j < (columna + DIMENSION_CAJA) && !estaCaja){
				if(celdas[i - 1][j - 1] == numero){
					estaCaja = true;
				}
				j++;
			}
			i++;
			j = columna;
		}
		return estaCaja;
	}

}