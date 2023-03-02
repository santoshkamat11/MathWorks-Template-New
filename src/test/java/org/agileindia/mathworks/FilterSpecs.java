package org.agileindia.mathworks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class FilterSpecs {
    @Test
    public void itSelectsPerfectNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 28);

        //When
        List<Integer> perfectNumbers = Filter.select(numbers,Filter.PERFECT);

        //Then
        assertThat(perfectNumbers, hasSize(2));
        assertThat(perfectNumbers, hasItems(6, 28));
    }

    @Test
    public void anyNegativeNumberOrZeroIsNotAPerfectNumber() {
        //Given
        List<Integer> numbers = Arrays.asList(-2, -1, 0, 6);

        //When
        List<Integer> primeNumbers = Filter.select(numbers, Filter.PERFECT);

        //Then
        assertThat(primeNumbers, hasSize(1));
        assertThat(primeNumbers, hasItem(6));
    }

    @Test
    public void itSelectsEvenNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //When
        List<Integer> evenNumbers = Filter.select(numbers, Filter.EVEN);

        //Then
        assertThat(evenNumbers, hasItems(2,4));
    }

    @Test
    public void itSelectsEvenNumbersEvenIfNegatives() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, -4);

        //When
        List<Integer> evenNumbers = Filter.select(numbers,Filter.EVEN);
        //List<Integer> evenNumbers = Filter.selectEven(numbers);

        //Then
        assertThat(evenNumbers, hasItems(2,-4));
    }

    @Test
    public void itSelectsEvenAndPerfectNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 6, 8, 27, 28);

        //When
        List<Integer> evenPerfectNumbers = Filter.select(numbers,Filter.EVEN,Filter.PERFECT);

        //Then
        assertThat(evenPerfectNumbers, hasItems(6,28));
    }

}
