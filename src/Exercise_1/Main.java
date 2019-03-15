package Exercise_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<String> l = Arrays.asList("Athens","Thessaloniki","Patras","Larisa","Kozani","Karditsa","Trikala","Kalamata","Tripoli","Rethymno");

        /*
        1. Print the given list in alphabetical order
         */
        l.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        /*
        2. Print the list in length descending order
         */
        l.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        System.out.println();

        /*
        3. Print the first letter of each word without
        duplicates
         */
        l.stream()
                .map(s -> s.substring(0, 1))
                .sorted()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        /*
        4. Print the list in all CAPITALS
         */
        l.stream().
                map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println();

        /*
        5. Print all the words starting with K
         */
        l.stream()
                .filter(s -> s.startsWith("K"))
                .forEach(System.out::println);

        System.out.println();

        /*
        6. Print all the words excluding words starting with
        K or T
         */
        l.stream()
                .filter(s -> !s.startsWith("K") && !s.startsWith("T"))
                .forEach(System.out::println);

        System.out.println();

        /*
        7. Print the first word the most letters
         *
        l.stream()
                .filter(s -> s.length() == (l.stream().mapToInt(String::length)).max().getAsInt())
                .limit(1)
                .forEach(System.out::println);

        System.out.println();

        /*
        8. Print the first word the least letters
         */
        l.stream()
                .filter(s -> s.length() == (l.stream().mapToInt(String::length).min().getAsInt()))
                .limit(1)
                .forEach(System.out::println);
    }


}
