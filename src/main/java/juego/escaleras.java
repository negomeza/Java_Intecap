
package juego;

public class escaleras {
    public static void main(String[] args) {
        int[][] num = new int[8][8];
        int val = 64;
        boolean tab = true;
        
        for (int i = 0; i < num.length; i++) {
             if (tab) {
                 for (int j = num[i].length - 1; j >= 0; j--) {
                     num[i][j] = val;
                     val--;
                 }
                 tab = false;
                } else {
                    for (int j = 0; j < num[i].length; j++) {
                     num[i][j] = val;
                     val--;
                 }
                 tab = true;
                }
             
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
        System.out.println("");
        System.out.println("-----------------------------------------");
            
        }
        
        
        
    }
}
