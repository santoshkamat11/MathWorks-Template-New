package org.agileindia.mathworks;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {
    public static List<Integer> selectPrime(List<Integer> numbers) {
        List<Integer> primeNumbers = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }
        return primeNumbers;
    }

    public static Predicate<Integer> where(Predicate<Integer> first, Predicate<Integer> ...remaining) {
        return Stream.of(remaining).reduce(first, (acc, next) -> acc.or(next));
    }

    public static List<Integer> select(Predicate<Integer> predicate, Integer ...numbers) {
        return Stream.of(numbers)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static boolean isPrime(Integer number) {
        if (number < 2) {
            return false;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}