
package juego;

import java.util.Scanner;

public class juego {
    public static void main(String[] args) {
        int[][] num = new int[8][8];
        boolean[][] penalizacion = new boolean[8][8];
        int val = 64;
        boolean reverse = false;

        // Inicializar la matriz num con los valores del 64 al 1
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

        // Marcar algunas casillas como de penalización
        penalizacion[0][1] = true;
        penalizacion[2][2] = true;
        penalizacion[4][3] = true;
        penalizacion[6][4] = true;

        // Imprimir el tablero con las casillas de penalización
        System.out.println("-----------------------------------------");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (penalizacion[i][j]) {
                    System.out.print("|#  ");
                } else if (num[i][j] < 10) {
                    System.out.print("|   "+num[i][j]);
                } else {
                    System.out.print("|  "+num[i][j]);
                }
            }
            System.out.println("|");

            for (int j = 0; j < num.length; j++) {
                if (penalizacion[i][j]) {
                    System.out.print("|   ");
                } else {
                    System.out.print("|   @");
                }
            }
            System.out.println("|");

            for (int j = 0; j < num.length; j++) {
                if (penalizacion[i][j]) {
                    System.out.print("|   ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");

            System.out.println("-----------------------------------------");
        }
    }
}
