import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Число инверсий
 *
 * A[i]>A[j]. (Такая пара элементов называется инверсией массива.
 * Количество инверсий в массиве является в некотором смысле его мерой неупорядоченности:
 * например, в упорядоченном по неубыванию массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
 * инверсию образуют каждые два элемента.
 */

public class NumberOfInversions {
    long count = 0;

    public static void main(String[] args) {
        NumberOfInversions numberOfInversions = new NumberOfInversions();
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        scanner.nextLine();
        array = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> !e.equals(""))
                .mapToInt(Integer::parseInt).toArray();
//        System.out.println(new NumberOfInversions().naivMethod(array));

        int[] ints = numberOfInversions.recMethod(array, 0, array.length - 1);
        System.out.println(numberOfInversions.count);
        scanner.close();
    }

    /**
     * С помощью сортировки слиянием
     * @param array
     * @param left
     * @param right
     * @return
     */

    private int[] recMethod(int[] array, int left, int right) {

        if(left == right) {
            return new int[]{array[left]};
        }

        int mid = left + (right - left) / 2;

        int[] leftArray = recMethod(array, left, mid);
        int[] rightArray = recMethod(array, mid + 1, right);

        int[] m = mergeArrays(leftArray, rightArray);

        return m;
    }

    private int[] mergeArrays(int[] leftArray, int[] rightArray) {
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>(leftArray.length + rightArray.length);

        while (i < leftArray.length || j < rightArray.length) {

            if(j == rightArray.length || (i < leftArray.length && leftArray[i] <= rightArray[j])) {
                result.add(leftArray[i]);
                i++;
            }
            else {
                result.add(rightArray[j]);
                count += leftArray.length - i;
                j++;
            }
        }
        int[] array = result.stream().mapToInt(e -> (int) e).toArray();
        return array;
    }


    /**
     * O(n2)
     * @param array
     * @return
     */
    private int naivMethod(int[] array) {
        int result = 0;
        int i = 0;
        while (i < array.length - 1) {

            if(array[i] <= array[i + 1]) {
                i++;
                continue;
            }

            if(array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                result++;
                i = 0;
            }
        }

        return result;
    }
}
