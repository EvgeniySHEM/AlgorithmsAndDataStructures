import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        System.out.println(sumElementsInArray(new int[]{3,2,3}));
        int[] ints = {1, 2, 4, 5, 7, 9};

        System.out.println(binarySearch(ints, 46, 0, ints.length - 1));
    }


    //Рекурсивное нахождение суммы элементов массива
    private static int sumElementsInArray(int[] array) {
        if (array.length == 1)
            return array[0];

        return array[0] + sumElementsInArray(Arrays.copyOfRange(array, 1, array.length));
    }

    /**
     * Рекурсивная реализация бинарного поиска
     * @param array - отсортированный массив
     * @param k - искомое число
     * @param low - нижняя граница поиска
     * @param high - верхняя граница поиска
     * @return
     */
    private static int binarySearch(int[] array, int k, int low, int high) {

        if(k < array[low] || k > array[high]) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == k) {
            return mid;
        }

        if (k > array[mid] && k <= high) {
            low = mid + 1;
            return binarySearch(array, k, low, high);
        } else if (k < array[mid] && k >= low) {
            high = mid - 1;
            return binarySearch(array, k, low, high);
        }
        return -1;
    }
}
