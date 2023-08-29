package TrenTestTinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class КурьерКатя {
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] data = Arrays.stream(bufferedReader.readLine().split(" "))
                    .filter(e -> !e.isBlank()).toArray(String[]::new);

            int countEmpl = Integer.parseInt(data[0]);
            int timeOut = Integer.parseInt(data[1]);

            int[] floors = Arrays.stream(bufferedReader.readLine().split(" "))
                    .filter(e -> !e.isBlank())
                    .mapToInt(Integer::parseInt).toArray();

            int leaveEmpl = Integer.parseInt(bufferedReader.readLine());

            int res = 0;
            if ((floors[leaveEmpl - 1] - floors[0]) > timeOut && (floors[countEmpl - 1] - floors[leaveEmpl - 1]) > timeOut) {
                if (floors[countEmpl - 1] - floors[leaveEmpl - 1] < floors[leaveEmpl - 1] - floors[0]) {
                    res += floors[countEmpl - 1] - floors[leaveEmpl - 1];
                } else {
                    res += floors[leaveEmpl - 1] - floors[0];
                }
            }
            res += floors[countEmpl - 1] - floors[0];

            System.out.println(res);
        }
    }
}
