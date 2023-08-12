import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class НаибольшаяПоследовательнократнаяПодпоследовательность {

    public static void main(String[] args) throws IOException {
        new НаибольшаяПоследовательнократнаяПодпоследовательность().run();
    }

    private void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arrayNumbers = new int[n];
        int[] arrayNVP = new int[n];

        String[] s = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrayNumbers[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < n; i++) {
            arrayNVP[i] = 1;
            int prev = 0;
            for (int j = 0; j < i; j++) {
                if(arrayNumbers[j] <= arrayNumbers[i] && arrayNumbers[i]
                        % arrayNumbers[j] == 0 && arrayNVP[j] + 1 > arrayNVP[i]) {
                    arrayNVP[i] = arrayNVP[j] + 1;
                }
            }
//            for (int j = i + 1; j < n; j++) {
//                if(prev > 0 && prev <= arrayNumbers[j] && arrayNumbers[j] % prev == 0) {
//                    prev = arrayNumbers[j];
//                    arrayNVP[i] += 1;
//                } else if (arrayNumbers[j - 1] <= arrayNumbers[j] && arrayNumbers[j] % arrayNumbers[j - 1] == 0){
//                    prev = arrayNumbers[j];
//                    arrayNVP[i] += 1;
//                }
//            }
        }

        int result = 0;
        for (int el : arrayNVP) {
            result = Math.max(result, el);
        }

        System.out.println(result);

        bufferedReader.close();
    }
}
