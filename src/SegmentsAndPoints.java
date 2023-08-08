import java.util.Arrays;
import java.util.Scanner;

/**
 * Точка считается принадлежащей отрезку, если она находится внутри него или на границе.
 * Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
 */

public class SegmentsAndPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSegments = scanner.nextInt();
        int numberOfPoints = scanner.nextInt();

        int[] left = new int[numberOfSegments];
        int[] right = new int[numberOfSegments];

        for (int i = 0; i < numberOfSegments; i++) {
            left[i] = scanner.nextInt();
            right[i] = scanner.nextInt();
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int[] points = new int[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            points[i] = scanner.nextInt();
        }
        scanner.close();

        new SegmentsAndPoints().run(left, right, points);

    }

    private void run(int[] left, int[] right, int[] points) {
        int n = 0;
        int m = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.length; i++) {
            n = binarySearch(left, points[i], 0, left.length - 1);
            m = binarySearch(right, points[i] - 1, 0, right.length - 1);
            sb.append(n - m).append(" ");
        }
        System.out.println(sb);
    }

    private int binarySearch(int[] array, int k, int low, int high) {

        int result = 0;

        if (k < array[low]) {
            return low;
        }
        if (k > array[high]) {
            result = high + 1;
            return result;
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == k) {
            while (mid <= array.length - 1 && array[mid] == k) {
                mid++;
            }

            result = mid;
            return result;
        }

        if (k > array[mid]) {
            low = mid + 1;
            return binarySearch(array, k, low, high);
        } else if (k < array[mid]) {
            high = mid - 1;
            return binarySearch(array, k, low, high);
        }
        return result;
    }
}
