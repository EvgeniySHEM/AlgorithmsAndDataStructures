import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithms {
    public static void main(String[] args) {

        int[] stations = {0, 200, 375, 550, 750, 950};
        System.out.println(minStops(stations, 400));
    }

    private static int minStops(int[] stations, int capacity) {
        int result = 0; //оптимальное количество остановок
        int currentStop = 0; //остановка, на которой находится машина

        while (currentStop < stations.length - 1) {
            int nextStop = currentStop;

            while (nextStop < stations.length - 1 &&
            stations[nextStop + 1] - stations[currentStop] <= capacity) {
                nextStop++;
            }

            if(currentStop == nextStop)
                return -1;

            if(nextStop < stations.length - 1)
                result++;

            currentStop = nextStop;
        }
        return result;
    }

    private static String maxNumberFromDigits1(int[] digits) {
        Arrays.sort(digits); //O (nlogn)
        StringBuilder result = new StringBuilder(digits.length);

        for (int i = digits.length - 1; i >= 0 ; i--) { //O(n)
            result.append(digits[i]);
        }

        return result.toString();
    }

    private static String maxNumberFromDigits2(int[] digits) {
        return String.join("", Arrays.stream(digits)
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }
}
