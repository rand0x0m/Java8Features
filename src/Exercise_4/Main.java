package Exercise_4;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(50).toString());
    }

    private static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n).
            mapToObj(s -> BigInteger.valueOf(s)).
            reduce(BigInteger.
            valueOf(1), (a, b) -> a.multiply(b));
    }
}
