package TrenTestTinkoff;

import java.util.Scanner;

public class ЗаполнениеМатрицыПоДиагонали {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[m][n];
        int a = -1;
        int b = 0;
        int counter = 1;
        boolean flag = false;

        for (int i = 0; i < n + m - 1; i++) {// проходим по всем диагоналям
            a++;
            if(flag) {
                b++;
            }
            int maxN = Math.min(a, n - 1);
            int maxM = Math.min(b, m - 1);
            if(maxN == n - 1) {
                flag = true;
            }
            while (maxN >= 0 && maxM <= m - 1) { // заполняем диагональ
                matrix[maxM][maxN] = counter++;
                maxN--;
                maxM++;
                if (counter > n * m) { // если достигли последнего числа, выводим матрицу и завершаем программу
                    printMatrix(matrix);
                    return;
                }
            }
        }
    }

    // метод для вывода матрицы на экран
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
