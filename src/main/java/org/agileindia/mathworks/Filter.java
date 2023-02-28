package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static List<Integer> selectPerfect(List<Integer> numbers) {
        List<Integer> perfectNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (isPerfect(number)) {
                perfectNumbers.add(number);
            }
        }
        return perfectNumbers;
    }

    private static boolean isPerfect(int number) {
        if (number > 0) {
            List<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    factors.add(i);
                }
            }
            // Sum of factors
            int sumOfFactors = 0;
            for (Integer i : factors) {
                sumOfFactors += i;
            }
            // It is a perfect number if the difference between sum of factors and the
            // number is equal to the number itself
            return sumOfFactors - number == number;
        }
        return false;
    }

    public static List<Integer> selectEvens(List<Integer> numbers){
        return numbers.stream().filter(Filter::isEven).collect(Collectors.toList());
    }

    public static boolean isEven(Integer number){
        return number % 2 == 0;
    }

    public static List<Integer> selectEvenAndPerfect(List<Integer> numbers){
        return numbers.stream().filter(n -> isEven(n) && isPerfect(n)).collect(Collectors.toList());
    }
}