import java.util.Arrays;
import java.util.Scanner;

public class GreedyKnapsack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int W = scanner.nextInt();
        Item[] items = new Item[size];
        for (int i = 0; i < size; i++) {
            items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(items, (e1, e2) -> -Long.compare(((long) e1.cost * e2.weight),
                ((long) e2.cost * e1.weight)));

        double result = 0;
        for (Item el : items) {
            if(el.weight <= W) {
                result += el.cost;
                W -= el.weight;
            } else {
                result += (double) el.cost * W / el.weight;
                break;
            }
        }
        System.out.println(result);
    }

    static class Item {
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }
    }
}
