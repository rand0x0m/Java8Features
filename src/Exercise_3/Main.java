package Exercise_3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("cat", "dog", "duck", "elephant", "ship");

        /*
        1. Filter out 2 words using Lambda Expressions
         */
        l.stream().filter(s -> !s.equals("ship") && !s.equals("duck")).forEach(System.out::println);

        System.out.println();

        /*
        2. Filter out 2 words using Method References
         */
        l.stream().filter(Main.methodFactory("cat", "dog")).forEach(System.out::println);
    }

    private static Predicate<String> methodFactory(String value1, String value2) {
        return new Predicate<String>() {
            @Override
            public boolean test(String s) {
                    if (!s.equals(value1) && !s.equals(value2))
                        return true;
                    return false;
            }
        };
    }
}
