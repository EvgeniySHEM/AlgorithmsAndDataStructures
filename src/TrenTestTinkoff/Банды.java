package TrenTestTinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Банды {
    static int[] rank;
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(i, list);
        }


        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rank[i] = 1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = 0;
            if (type < 3) {
                y = Integer.parseInt(tokenizer.nextToken());
            }

            if (type == 1) {
                union(x, y);
            } else if (type == 2) {
                result.append(together(x, y) ? "YES\n" : "NO\n");
            } else {
                result.append(rank[x]).append("\n");
            }
        }
        System.out.print(result.toString());
    }

    private static boolean together(int x, int y) {
        boolean result = false;

        if(map.containsKey(x)) {
            if(map.get(x).contains(y)) {
                return true;
            }
        }

        if(map.containsKey(y)) {
            if(map.get(y).contains(x)) {
                return true;
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().contains(x) && entry.getValue().contains(x)) {
                return true;
            }
        }


        return false;
    }

    static void union(int x, int y) {
        if(!map.containsKey(x)) {
            map.entrySet().forEach(e -> {
                if(e.getValue().contains(x)) {
                    e.getValue().add(y);
                    for (Integer el : e.getValue()) {
                        rank[el]++;
                    }
                }
            });
            map.remove(y);
            return;
        }

        if(!map.containsKey(y)) {
            map.entrySet().forEach(e -> {
                if(e.getValue().contains(y)) {
                    e.getValue().add(x);
                    for (Integer el : e.getValue()) {
                        rank[el]++;
                    }
                }
            });
            map.remove(x);
            return;
        }

        if(map.get(x).size() >= map.get(y).size()) {
            map.get(x).add(y);
            map.remove(y);
            for (Integer el : map.get(x)) {
                rank[el]++;
            }
        } else {
            map.get(y).add(x);
            map.remove(x);
            for (Integer el : map.get(y)) {
                rank[el]++;
            }
        }
    }
}
