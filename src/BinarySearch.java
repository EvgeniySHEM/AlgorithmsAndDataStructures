import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        new BinarySearch().run();
    }

    /**
     * Задача на программирование: двоичный поиск
     *
     * В первой строке дано размер массива в диапазоне от 1 до 10^5 и элементы массива типа int
     * (в диапазоне от 1 до 10^9 ) в порядке возрастания.
     * Вo второй строке первое число содержит количество искомых значений, далее сами искомые значения.
     * Для каждого искомого значения выведите индекс массива содержащий искомый элемент, или -1 в противном случае.
     */
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> !e.equals(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = scanner.nextInt();
        int[] array2 = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> !e.equals(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        search(array, array2);
    }

    private void search(int[] array, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : array2) {

            if(map.containsKey(el)) {
                System.out.println(map.get(el) + 1);
                continue;
            }

            int result = binarySearch(array, el, 0, array.length - 1);
            if(result >= 0) {
                map.put(el, result);
                System.out.println(result + 1);
            } else {
                System.out.println(-1);
            }
        }
    }

    /**
     * Рекурсивная реализация бинарного поиска
     * @param array - отсортированный массив
     * @param k - искомое число
     * @param low - нижняя граница поиска
     * @param high - верхняя граница поиска
     * @return
     */
    private int binarySearch(int[] array, int k, int low, int high) {

        if(k < array[low] || k > array[high]) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == k) {
            return mid;
        }

        if (k > array[mid]) {
            low = mid + 1;
            return binarySearch(array, k, low, high);
        } else if (k < array[mid]) {
            high = mid - 1;
            return binarySearch(array, k, low, high);
        }
        return -1;
    }
}
