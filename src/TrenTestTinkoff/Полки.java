package TrenTestTinkoff;

import java.util.Scanner;

public class Полки {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] shelves = new int[m];
        int nextShelf = 0;
        for (int i = 0; i < m; i++) {
            String event = sc.next();
            int x = sc.nextInt();
            if (event.equals("+")) {
                for (int j = 0; j < m; j++) {
                    if(shelves[j] == 0) {
                        nextShelf = j;
                        break;
                    }
                }
                shelves[nextShelf] = x;
                System.out.println(++nextShelf);
            } else {
                for (int j = 0; j < m; j++) {
                    if(shelves[j] == x) {
                        shelves[j] = 0;
                    }
                }
            }
        }
    }
}
