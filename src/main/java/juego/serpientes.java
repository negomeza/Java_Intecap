
package juego;

import java.util.Scanner;
import java.util.Random;

public class serpientes {
    public static void main(String[] args) {
        int[][] num = new int[8][8];
        int val = 64;
        boolean reverse = false;
        // Crea un objeto Random
        Random rand = new Random();

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
                    System.out.print("  #");
                } else {
                    System.out.print("   ");
                }
                } else {
                    System.out.print("|");
                    if (randomNum == 0) { // Establece una probabilidad del 10% de que la casilla sea una casilla de penalización
                    System.out.print("   #");
                } else {
                    System.out.print("    ");
                }
                }
            }
            
            System.out.println("|");
            System.out.println("-----------------------------------------");
        }
     
    }
}