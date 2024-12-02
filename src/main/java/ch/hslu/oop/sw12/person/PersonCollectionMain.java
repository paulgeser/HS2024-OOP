package ch.hslu.oop.sw12.person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonCollectionMain {

    private static final Comparator<Person> lastNameComp =
            (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
    private static final Comparator<Person> firstNameComp =
            (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(3, "Alice", "Wonderland"));
        people.add(new Person(1, "Bob", "Builder"));
        people.add(new Person(2, "Charlie", "Chaplin"));
        people.add(new Person(4, "Alice", "Anderson"));
        

        people.sort(lastNameComp);
        people.forEach(System.out::println);
        people.sort(lastNameComp.reversed());
        people.forEach(System.out::println);
        people.sort(lastNameComp
                .thenComparing(firstNameComp));
        people.forEach(System.out::println);
    }
}
