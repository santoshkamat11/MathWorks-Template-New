package org.agileindia.mathworks;

import org.junit.jupiter.api.Disabled;
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
        List<Integer> perfectNumbers = Filter.selectPerfect(numbers);

        //Then
        assertThat(perfectNumbers, hasSize(2));
        assertThat(perfectNumbers, hasItems(6, 28));
    }

    @Test
    public void anyNegativeNumberOrZeroIsNotAPerfectNumber() {
        //Given
        List<Integer> numbers = Arrays.asList(-2, -1, 0, 6);

        //When
        List<Integer> primeNumbers = Filter.selectPerfect(numbers);

        //Then
        assertThat(primeNumbers, hasSize(1));
        assertThat(primeNumbers, hasItem(6));
    }
}
