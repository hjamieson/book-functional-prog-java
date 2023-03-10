package book.fujava.lazy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Primes {

    /**
     * determine if a number is prime
     */
    public static boolean isPrime(final int number){
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(divisor -> number % divisor == 0);
    }

    public static List<Integer> primes(final int number){
        if(isPrime(number))
            return concat(number, primes(number + 1));
        else
            return primes(number + 1);
    }
    private static List<Integer> concat(int num, List<Integer> list){
        list.add(num);
        return list;
    }

    private static int primeAfter(final int number){
        if (isPrime(number + 1))
            return number + 1;
        else
            return primeAfter(number + 1);
    }

    public static List<Integer> primes(final int fromNumber, final int count){
        return Stream.iterate(primeAfter(fromNumber - 1), Primes::primeAfter)
                .limit(count)
                .collect(Collectors.<Integer>toList());
    }
    public static void main(String[] args) {
        System.out.println(primes(5, 10));
        System.out.println(primes(4, 10));
        System.out.println(primes(100, 5));
    }
}
