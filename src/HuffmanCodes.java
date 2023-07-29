
import java.util.*;

public class HuffmanCodes {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        huffmanCodes(s);
        huffmanDeCodes();
    }

    private static void huffmanCodes(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.merge(c, 1, Integer::sum);
        }

        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), leafNode);
            priorityQueue.add(leafNode);
        }

        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        if(count.size() == 1) {
            sum = s.length();
        }

        System.out.println(count.size() + " " + sum);
        Node root = priorityQueue.poll();
        if(count.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(charNodes.get(c).code);
        }
        System.out.println(stringBuilder);
    }

    private static void huffmanDeCodes() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt(); // кол-во различных букв
        int l = scanner.nextInt(); // размер получившейся закодированной строки
        scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        String[] array = new String[2];

        for (int i = 0; i < k; i++) {
            array = scanner.nextLine().split(": ");
            map.put(array[1],array[0]);
        }

        String s = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        int end = 1;
        while (end <= s.length()) {
            String b = s.substring(start, end);
            if(map.containsKey(b)) {
                stringBuilder.append(map.get(b));
                start = end;
                end++;
                continue;
            }
            end++;
        }
        System.out.println(stringBuilder);
    }

    static class Node implements Comparable<Node>{
        final int sum;
        String code;

        public Node(int sum) {
            this.sum = sum;
        }

        void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    static class InternalNode extends Node{
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    static class LeafNode extends Node{
        char symbol;

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }
    }
}
