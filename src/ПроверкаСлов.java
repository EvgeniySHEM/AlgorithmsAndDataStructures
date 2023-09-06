import java.util.HashMap;
import java.util.Map;

public class ПроверкаСлов {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "Holle";
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int n = 0;
        while (n < s1.length()) {
            map1.merge(s1.charAt(n), 1, Integer::sum);
            n++;
        }

        n = 0;
        while (n < s2.length()) {
            map2.merge(s2.charAt(n), 1, Integer::sum);
            n++;
        }

        for (Map.Entry<Character, Integer> el : map1.entrySet()) {
            if (map2.containsKey(el.getKey()) && map2.get(el.getKey()).equals(el.getValue())) {
                map2.remove(el.getKey());
            }
        }

        System.out.println(map2.isEmpty());
    }
}
