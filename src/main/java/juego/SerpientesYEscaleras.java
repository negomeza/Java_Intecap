/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;


import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerpientesYEscaleras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean juegoIniciado = false;
        
        while (opcion != 3) {
            System.out.println("¡Bienvenido al juego de Serpientes y Escaleras!");
            System.out.println("1. Iniciar juego");
            if (juegoIniciado) {
                System.out.println("2. Retomar juego");
            }
            System.out.println("3. Salir");
            System.out.print("Por favor, seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¡Nuevo juego iniciado!");
                    iniciarJuego();
                    juegoIniciado = true;
                    break;
                case 2:
                    if (juegoIniciado) {
                        System.out.println("¡Juego retomado!");
                        iniciarJuego();
                        juegoIniciado = true;
                    } else {
                        System.out.println("¡No hay ningún juego en progreso!");
                    }
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("¡Opción inválida!");
            }

            System.out.println();
            
        }
    }

    public static void iniciarJuego() {
       int val = 64;
        // Crea un objeto Random
        Random rand = new Random();
        int posision = 0;
        int lanzamientos = 0;
        
        while (posision < val) {   
            int turno = rand.nextInt(6) +1;
            
            if ((posision + turno)<= val) {
                posision = posision + turno;
                lanzamientos = lanzamientos + 1;
                System.out.println("el dado salio " + turno + " la posision es: " + posision);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SerpientesYEscaleras.class.getName()).log(Level.SEVERE, null, ex);
                }
                partida(posision);
            } else {
                posision = posision + 0;
                lanzamientos = lanzamientos + 1;
                System.out.println("el dado salio " + turno + " la posision es: " + posision);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SerpientesYEscaleras.class.getName()).log(Level.SEVERE, null, ex);
                }
                partida(posision);
            }
            
        }
        
            System.out.println("Juego Finalizado");
            System.out.println("Tu puntuación es de: " + lanzamientos + " Lanzamientos");
            
        
    }
    
    public static void partida(int posision){
        
        int[][] num = new int[8][8];
        int val = 64;
        boolean reverse = true;
        Random rand = new Random();
        int penalizaciones = 0;
        int penalizaciones_acum = 0;
        //ACA INICIA LA PARTIDA DE JUEGO 
        
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (reverse) {
                    num[i][num[i].length - j - 1] = val--;
                } else {
                    num[i][j] = val--;
                }
            }
            reverse = !reverse;
        }
     
        
        System.out.println("-----------------------------------------");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (num[i][j] < 10) {
                    System.out.print("|   "+num[i][j]);
                } else {
                    System.out.print("|  "+num[i][j]);
                }
            }
            
            //for para colocar las casillas de penalización
            System.out.println("|");
            for (int j = 0; j < num.length; j++) {
                int randomNum = rand.nextInt(10); // Genera un número aleatorio entre 0 y 9
                if (num[i][j] < 10) {
                    System.out.print("| ");
                    if (randomNum == 0) { // Establece una probabilidad del 10% de que la casilla sea una casilla de penalización
                        if (posision == num[i][j]) {
                            System.out.print("  #");
                            System.out.println("Penalización");
                            penalizaciones = penalizaciones + 1;
                        } else {
                            System.out.print("  #");
                            penalizaciones = penalizaciones + 0;
                        }
                    } else {
                        System.out.print("   ");
                    }
                } else {
                    System.out.print("|");
                    if (randomNum == 0) { // Establece una probabilidad del 10% de que la casilla sea una casilla de penalización
                        if (posision == num[i][j]) {
                            System.out.print("  #");
                            System.out.println("Penalización");
                            penalizaciones = penalizaciones + 1;
                        } else {
                            System.out.print("  #");
                            penalizaciones = penalizaciones + 0;
                        }
                    } else {
                        System.out.print("    ");
                    }
                }
            }

             //for para colocar las casillas de penalización
            System.out.println("|");
            for (int j = 0; j < num.length; j++) {
                int randomNum = rand.nextInt(10); // Genera un número aleatorio entre 0 y 9
                if (num[i][j] < 10) {
                    System.out.print("| ");
                    if (posision == num[i][j]) { // Establece una probabilidad del 10% de que la casilla sea una casilla de penalización
                        System.out.print("  @" );
                    } else {
                        System.out.print("   ");
                    }
                } else {
                    System.out.print("|");
                    if (posision == num[i][j]) { // Establece una probabilidad del 10% de que la casilla sea una casilla de penalización
                        System.out.print("  @" );
                    } else {
                        System.out.print("    ");
                    }
                }
            }
            
            System.out.println("|");
            System.out.println("-----------------------------------------");
        }
         if (penalizaciones == 1) {
            System.out.println("***PELIGRO*** --->PENALIZACIÓN<---- ");
            System.out.println("                 ____");
            System.out.println("              .-\"    \"`-.");
            System.out.println("             /  .--.   \\");
            System.out.println("            /  /    \\   \\");
            System.out.println("            |  |      |  |");
            System.out.println("            \\  \\      /  /");
            System.out.println("             \\  `--'  /  /");
            System.out.println("          .--.`.___,.'--.`.");
            System.out.println("         /    `-----'     \\");
            System.out.println("        /                 \\");
            System.out.println("       /                   \\");
            System.out.println("      /                     \\");
            System.out.println("     /                       \\");
            System.out.println("    /                         \\");
            System.out.println("   /                           \\");
            System.out.println("  /                             \\");
            System.out.println(" |                               |");
            System.out.println(" |                               |");
            System.out.println(" |                               |");
            System.out.println("  \\                             /");
            System.out.println("   \\                           /");
            System.out.println("    `._                     _.'");
            System.out.println("       `--.             .--'");
            System.out.println("            `\"--.....--\"`");

        }
            penalizaciones_acum = penalizaciones_acum +0;
            //FINALIZA LA PARTIDA DE JUEGO
    }
   
}