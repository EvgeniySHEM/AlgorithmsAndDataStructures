import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    private static final Random random = ThreadLocalRandom.current();

    public static void main(String[] args) {

        int[] sortArr = {2, 1, 10, 5, 6, 2, 3, 2, 15, 83, 42, 25, 50, 31, 0, -5, -10, 18};
        quickSort(sortArr, 0, sortArr.length - 1);
        System.out.println(Arrays.toString(sortArr));

    }

    public static void quickSort(int[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return;

        //выбираем опорный элемент
//        int middle = low + (high - low) / 2;
        int middle = random.nextInt(low, high + 1);
        int border = sortArr[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) swap(sortArr, i++, j--);
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }

    private static void swap(int[] sortArr, int i, int j) {
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
    }
}


