/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Random;
import java.util.Scanner;
import javax.tools.Tool;

/**
 *
 * @author NELSON
 */
public class escalerasyserpientes {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[][] tablero = generarTablero(); // Genera un nuevo tablero
        int[] posiciones = {0, 0}; // Posiciones iniciales de los jugadores
        boolean juegoEnCurso = false;
        
        // Menú principal
        while (true) {
            System.out.println("=== Menú principal ===");
            System.out.println("a. Iniciar juego");
            System.out.println("b. Retomar juego");
            System.out.println("c. Salir");
            System.out.print("Ingrese una opción: ");
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "a":
                    posiciones = new int[] {0, 0};
                    juegoEnCurso = true;
                    break;
                case "b":
                    if (juegoEnCurso) {
                        // Continuar el juego actual
                        break;
                    } else {
                        System.out.println("No hay juego en curso para retomar.");
                        continue;
                    }
                case "c":
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    continue;
            }
            
            // Juego en curso
            while (juegoEnCurso) {
                // Mostrar el tablero y las posiciones actuales de los jugadores
                mostrarTablero(tablero, posiciones);
                
                // Turno del jugador 1
                System.out.println("Jugador 1, es su turno.");
                int dado1 = lanzarDado();
                posiciones[0] += dado1;
                if (posiciones[0] >= 64) {
                    System.out.println("¡Felicidades, jugador 1! ¡Ha ganado el juego!");
                    juegoEnCurso = false;
                    break;
                }
                if (tablero[fila(posiciones[0])][columna(posiciones[0])] == -1) {
                    System.out.printf("¡Has caído en una penalización! (Casilla %d)%n", posiciones[0]);
                }
                
                // Turno del jugador 2
                System.out.println("Jugador 2, es su turno.");
                int dado2 = lanzarDado();
                posiciones[1] += dado2;
                if (posiciones[1] >= 64) {
                    System.out.println("¡Felicidades, jugador 2! ¡Ha ganado el juego!");
                    juegoEnCurso = false;
                    break;
                }
                if (tablero[fila(posiciones[1])][columna(posiciones[1])] == -1) {
                    System.out.printf("¡Has caído en una penalización! (Casilla %d)%n", posiciones[1]);
                }
                
                // Esperar un momento antes del siguiente turno
                esperar(1000);
            }
        }
       
    }
    
    
        // Genera un nuevo tablero de juego
private static int[][] generarTablero() {
    int[][] tablero = new int[8][8];
    Random random = new Random();
    
    // Distribuir las penalizaciones
    for (int i = 0; i < 8; i++) {
        int numPenalizaciones = random.nextInt(3) + 1; // De 1 a 3 penalizaciones por fila
        for (int j = 0; j < numPenalizaciones; j++) {
            int columna = random.nextInt(8);
            tablero[i][columna] = -1; // Penalización en esa casilla
        }
    }
    
    return tablero;
}


// Muestra el tablero de juego y las posiciones de los jugadores
private static void mostrarTablero(int[][] tablero, int[] posiciones) {
    for (int i = 7; i >= 0; i--) {
        for (int j = 0; j < 8; j++) {
            int casilla = i * 8 + j;
            if (casilla == posiciones[0]) {
                System.out.print("@ "); // Jugador 1
            } else if (casilla == posiciones[1]) {
                System.out.print("# "); // Jugador 2
            } else if (tablero[i][j] == -1) {
                System.out.printf("#%d ", casilla); // Penalización
            } else {
                System.out.print("| "); // Casilla normal
            }
        }
        System.out.println();
    }
    System.out.println();
}

// Devuelve el número de fila correspondiente a una casilla
private static int fila(int casilla) {
    return (casilla - 1) / 8;
}

// Devuelve el número de columna correspondiente a una casilla
private static int columna(int casilla) {
    return (casilla - 1) % 8;
}

// Lanza un dado de seis caras
private static int lanzarDado() {
    Random random = new Random();
    return random.nextInt(6) + 1;
}

// Espera un tiempo en milisegundos
private static void esperar(int milisegundos) {
    try {
        Thread.sleep(milisegundos);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    
    
}
