import java.util.*;

public class PriorityQueueEx {
    public static void main(String[] args) {
        new PriorityQueueEx().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            if(s.contains("Insert")) {
                int i1 = s.lastIndexOf(" ") + 1;
                priorityQueue.add(Integer.parseInt(s.substring(i1)));
            } else {
                System.out.println(priorityQueue.poll());
            }
        }
    }
}
