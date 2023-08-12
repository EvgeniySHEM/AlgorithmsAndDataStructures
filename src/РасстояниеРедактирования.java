import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class РасстояниеРедактирования {
    private String first;
    private String second;
    int[][] d;
    boolean[][] calculated;

    public static void main(String[] args) throws IOException {
        new РасстояниеРедактирования().run();
    }

    private void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        first = bufferedReader.readLine();
        second = bufferedReader.readLine();
        d = new int[first.length() + 1][second.length() + 1];
//        calculated = new boolean[first.length() + 1][second.length() + 1];
        System.out.println(editingDistance(first.length(), second.length()));

        bufferedReader.close();
    }

    //ленивая динамика, рекурсивная функция с запоминанием
//    private int editingDistance(int n, int m) {
//        //first[0...n-1], second[0...m-1]
//        if(n == 0 && m == 0) return 0;
//        if(n == 0) return m;
//        if(m == 0) return n;
//        if(calculated[n][m]) {
//            return d[n][m];
//        }
//        int res1 = editingDistance(n, m - 1) + 1;
//        int res2 = editingDistance(n - 1, m) + 1;
//        int res3 = editingDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1)? 0 : 1);
//        int result = Math.min(Math.min(res1, res2), res3);
//        calculated[n][m] = true;
//        d[n][m] = result;
//        return result;
//    }

    //итеративная
    private int editingDistance(int f, int s) {
        int result = 0;
        for (int n = 0; n < f; n++) {
            for (int m = 0; m < s; m++) {
                if(n == 0 && m == 0) {
                    d[n][m] = 0;
                    continue;
                }
                if(n == 0) {
                    d[n][m] = m;
                    continue;
                }
                if(m == 0) {
                    d[n][m] = n;
                    continue;
                }
                int res1 = d[n][m - 1] + 1;
                int res2 = d[n - 1][m] + 1;
                int res3 = d[n - 1][m - 1] + (first.charAt(n - 1) == second.charAt(m - 1)? 0 : 1);
                result = Math.min(Math.min(res1, res2), res3);
                d[n][m] = result;
            }
        }
        return result;
    }
}
