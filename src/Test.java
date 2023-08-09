import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
    public static void main(String[] args) throws IOException {
        minimumTotalLengthOfAllThreads();

    }


    private static void minimumTotalLengthOfAllThreads() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int countThreads = Integer.parseInt(reader.readLine());

        if (countThreads == 0 ) {
            writer.write(String.valueOf(countThreads));
            reader.close();
            writer.close();
            return;
        }

        int[] coordinatesThreads = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        Arrays.sort(coordinatesThreads);
        System.out.println(Arrays.toString(coordinatesThreads));
        long totalLength = 0;

        if(countThreads == 2) {
            totalLength = coordinatesThreads[1] - coordinatesThreads[0];
            writer.write(String.valueOf(totalLength));

            reader.close();
            writer.close();
            return;
        }

        if(countThreads == 3) {
            totalLength = coordinatesThreads[2] - coordinatesThreads[0];
            writer.write(String.valueOf(totalLength));

            reader.close();
            writer.close();
            return;
        }

        int sumLengthsExtremePoints = (coordinatesThreads[1] - coordinatesThreads[0]) +
                (coordinatesThreads[countThreads - 1] - coordinatesThreads[countThreads - 2]);

        if(countThreads == 4) {
            totalLength = sumLengthsExtremePoints;
            writer.write(String.valueOf(totalLength));

            reader.close();
            writer.close();
            return;
        }

        totalLength = sumLengthsExtremePoints;
        for (int i = 2; i < countThreads - 2; i++) {
            int before = coordinatesThreads[i] - coordinatesThreads[i - 1];
            int after = coordinatesThreads[i + 1] - coordinatesThreads[i];

            if(before >= after) {
                totalLength += after;
                i++;
            } else {
                totalLength += before;
            }
        }
        writer.write(String.valueOf(totalLength));

        reader.close();
        writer.close();
    }


    //Рекурсивное нахождение суммы элементов массива
    private static int sumElementsInArray(int[] array) {
        if(array.length == 0)
            return 0;

        if (array.length == 1)
            return array[0];

        return array[0] + sumElementsInArray(Arrays.copyOfRange(array, 1, array.length));
    }
}
