import Items.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchInWidth {
    private final Map<Person, List<Person>> friends;
    private List<Person> finish;
    private int count;

    public SearchInWidth() {
        this.friends = new HashMap<>();
        this.finish = new ArrayList<>();
        Person alice = new Person("Alice");
        Person tom = new Person("Tom");
        Person bob = new Person("Bob");
        Person mike = new Person("Mike");
        Person john = new Person("John");
        Person ric = new Person("Ric");
        Person bruce = new Person("Bruce");
        Person frank = new Person("Frank");
        Person rita = new Person("Rita");
        friends.put(alice, new ArrayList<>(List.of(tom, bob, mike)));
        friends.put(tom, new ArrayList<>(List.of(john, ric, bruce)));
        friends.put(bruce, new ArrayList<>(List.of(frank, rita, ric, tom)));
    }

    public static void main(String[] args) {

        new SearchInWidth().run(new Person("Alice"));
    }

    private void run(Person person) {
        if(friends.containsKey(person) && !finish.contains(person)) {
            count++;
            friends.get(person).forEach(e -> bingo(e));
            finish.add(person);
            friends.get(person).forEach(e -> run(e));
        }
    }

    private void bingo(Person person) {
        if(person.getName().equals("Ric")) {
            System.out.println(person.getName() + " " + count);
        }
    }
}
