package Exercise_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static {

    }
    public static void main(String[] args) {
        List<Person> l = Arrays.asList(
                new Person("Mike", 29),
                new Person("John", 30),
                new Person("John", 32),
                new Person("Jack", 20),
                new Person("Sam", 20),
                new Person("Bob", 31),
                new Person("Bob", 20));

        /*
        1. Print the ages of all the Persons
        */
        l.stream().map(Person::getAge).forEach(System.out::println);
        System.out.println();

        /*
        2. Print the name of the Person with the greatest age
         */
        l.stream()
                .filter(p -> p.getAge() == (l.stream()
                    .mapToInt(Person::getAge)
                    .max()
                    .getAsInt()))
                .map(Person::getName)
                .limit(1)
                .forEach(System.out::println);

        System.out.println();

        /*
        3. Create a Map using as a Key the name of a Person and as
        a Value a List of Persons with said name
         */
        System.out.println(l.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.toList())));

        System.out.println();

        /*
        4. Print a comma separated String that will contain the ages
        of all the Persons in ascending order sans duplicates
         */
        System.out.println(l.stream()
                .map(Person::getAge)
                .sorted()
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining(","))
        );

        System.out.println();

        /*
        5. Print a comma separated String that will contain the ages
        of all the Persons multiplied by 10 in descending order
         */
        System.out.println(l.stream()
                .map(p -> p.getAge() * 10)
                .sorted((s1, s2) -> -Integer.compare(s1, s2))
                .map(String::valueOf)
                .collect(Collectors.joining(","))
        );

        System.out.println();

        /*
        6. Create a Map using as a Key the name of a Person and as
        a Value a List of ages of Persons with said name
         */
        System.out.println(l.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge, Collectors.toList()))));

        System.out.println();

        /*
        7. Create a Map using as a Key the age of a Person and as a
        Value the count of Persons that have said age
         */
        System.out.println(l.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting())));

    }
}